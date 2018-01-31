package jupiterpa.weather;

import java.util.Collection;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;

import jupiterpa.weather.domain.model.*;
import jupiterpa.weather.domain.service.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles({"mock","test"})
public class TransformerTest { 
	@Test
    public void test() throws Exception {
    	TemplateEntity entity = new TemplateEntity("Test");

    	TemplateEntity newEntity = TemplateTransformer.transform(entity);
    	
    	assertEquals(newEntity.toString(), "Test" );
    }
}