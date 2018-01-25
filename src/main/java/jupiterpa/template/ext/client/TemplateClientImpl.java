package jupiterpa.template.ext.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import jupiterpa.template.domain.client.TemplateClient;
import jupiterpa.template.domain.model.*;
import jupiterpa.template.infrastructure.client.ClientBase;

@Component
@Profile("default")
public class TemplateClientImpl extends ClientBase<TemplateEntity> implements TemplateClient {
    private static final Marker TECHNICAL = MarkerFactory.getMarker("TECHNICAL");
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@HystrixCommand(fallbackMethod = "defaultSet")
	public void set(TemplateEntity entity) {
		put("clientName","/",entity);
	}
	
	public void defaultSet(TemplateEntity entity) {
		logger.warn(TECHNICAL, "SET for client failed");
	}
	
}
