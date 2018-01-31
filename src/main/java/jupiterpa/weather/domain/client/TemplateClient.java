package jupiterpa.weather.domain.client;

import jupiterpa.weather.domain.model.TemplateEntity;

public interface TemplateClient {
	public void set(TemplateEntity entity);
	public void defaultSet(TemplateEntity entity);
}
