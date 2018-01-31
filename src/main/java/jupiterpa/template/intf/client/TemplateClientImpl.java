package jupiterpa.template.intf.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import jupiterpa.infrastructure.client.ClientBase;
import jupiterpa.template.domain.client.TemplateClient;
import jupiterpa.template.domain.model.*;

@Component
@Profile("default")
public class TemplateClientImpl extends ClientBase<TemplateEntity> implements TemplateClient {
    private static final Marker TECHNICAL = MarkerFactory.getMarker("TECHNICAL");
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@HystrixCommand(fallbackMethod = "defaultSet")
	public void set(TemplateEntity entity) {
		put("ledStrip","/ledstrip",entity);
	}
	
	public void defaultSet(TemplateEntity entity) {
		logger.warn(TECHNICAL, "SET LEDStrip failed");
	}
}
