package jupiterpa.template.domain.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jupiterpa.template.domain.client.*;
import jupiterpa.template.domain.model.*;
import jupiterpa.template.infrastructure.actuator.*;

@Service
public class TemplateService {

	@Autowired
	TemplateClient client;
	@Autowired
	TemplateRepo repo;
	@Autowired 
	InterfaceHealth health;

	public TemplateEntity create(TemplateEntity entity) {
		TemplateEntity new_entity = TemplateTransformer.transform(entity);
		client.set(new_entity);
		repo.save(new_entity);
		return new_entity;
	}
}
