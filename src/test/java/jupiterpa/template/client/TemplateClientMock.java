package jupiterpa.template.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jupiterpa.template.domain.client.TemplateClient;
import jupiterpa.template.domain.model.TemplateEntity;

@Component
@Profile("mock")
public class TemplateClientMock implements TemplateClient, ClientMocking {
	
	List<TemplateEntity> entities = new ArrayList<TemplateEntity>();
	
	@SuppressWarnings("unchecked")
	public void inject(Object obj) {
		if (obj != null)
		  entities = (List<TemplateEntity>) obj;
	}
	public Object getState() {
		return entities;
	}

	@Override
	public void set(TemplateEntity entity) {
		entities.add(entity);
	}

}
