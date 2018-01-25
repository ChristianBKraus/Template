package jupiterpa.template.domain.model;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TemplateEntityRepo extends MongoRepository<TemplateEntity,Long>{
	public List<TemplateEntity> findAll();
}
