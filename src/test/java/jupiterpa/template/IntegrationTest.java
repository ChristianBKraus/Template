package jupiterpa.template;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jupiterpa.template.client.ClientMocking;
import jupiterpa.template.domain.client.*;
import jupiterpa.template.domain.model.*;
import jupiterpa.template.ext.controller.Controller;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles="ADMIN")
@ActiveProfiles({"mock","test"})
public class IntegrationTest { 
	final String PATH = Controller.PATH; 

	@Autowired
    private MockMvc mockMvc;
	@Autowired
	private TemplateClient client;
	
	@Before
	public void initialize() {
        ClientMocking mock = (ClientMocking) client;
        mock.inject(new ArrayList<TemplateEntity>());
	}
    
    @Test
    public void test() throws Exception {
    	ClientMocking test = (ClientMocking) client;
    	
    	TemplateEntity entity = new TemplateEntity("Test");

    	mockMvc.perform( post(PATH).content(toJson(entity)).contentType(APPLICATION_JSON_UTF8) )
        .andExpect(status().isOk());
    	
    	mockMvc.perform(get(PATH))
        .andExpect(status().isOk())
        .andExpect(content().contentType(APPLICATION_JSON_UTF8))
        .andExpect(jsonPath("$.value").value("Test"));
    }
    private String toJson(Object object) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(object);
    }
}