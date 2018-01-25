package jupiterpa.template.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jupiterpa.template.domain.model.TemplateEntity;
import jupiterpa.template.domain.model.TemplateEntityRepo;

@Service
public class TemplateService {
	
	@Autowired Transformer transformer;
	@Autowired TemplateEntityRepo repo;
	
	public void store(TemplateEntity entity) {
		TemplateEntity transformed = Transformer.transformTemplateEntity(entity);
		repo.save(transformed);
	}
}
