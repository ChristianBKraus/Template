package jupiterpa.weather.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import jupiterpa.weather.domain.client.TemplateClient;
import jupiterpa.weather.domain.model.TemplateEntity;

@Component
@Profile("mock")
public class TemplateClientMock implements TemplateClient, ClientMocking {
	
	List<TemplateEntity> entities = new ArrayList<TemplateEntity>();
	
	@SuppressWarnings("unchecked")
	public void inject(Object result) {
		if (result != null)
		  entities = (List<TemplateEntity>) result;
	}
	public Object getState() {
		return entities;
	}

	public void set(TemplateEntity entity) {
		entities.add(entity);
	}
	@Override
	public void defaultSet(TemplateEntity entity) {
		// TODO Auto-generated method stub
		
	}

}
