package jupiterpa.template.domain.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

import jupiterpa.template.domain.model.*;

public class Transformer {
    private static final Marker TECHNICAL = MarkerFactory.getMarker("TECHNICAL");
	private static final Logger logger = LoggerFactory.getLogger(new Transformer().getClass());
	
	public static TemplateEntity transformTemplateEntity(TemplateEntity entity) {
		logger.info(TECHNICAL," start");
		// do nothing
		logger.info(TECHNICAL," end");
		return entity;
	}
}
