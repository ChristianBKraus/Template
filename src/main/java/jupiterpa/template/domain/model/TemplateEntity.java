package jupiterpa.template.domain.model;

import org.springframework.data.annotation.Id;

public class TemplateEntity {
	
	@Id
	public String id;
	
	String value;
	
	public TemplateEntity() {
		
	}
	public TemplateEntity(String value) {
		this.value = value;
	}
	
	
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return value; 
	}
}
