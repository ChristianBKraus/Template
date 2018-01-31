package jupiterpa.template.domain.client;

import jupiterpa.template.domain.model.TemplateEntity;

public interface TemplateClient {
	public void set(TemplateEntity entity);
	public void defaultSet(TemplateEntity entity);
}
