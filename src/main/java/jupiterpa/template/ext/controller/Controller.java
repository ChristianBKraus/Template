package jupiterpa.template.ext.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import jupiterpa.template.domain.model.*;
import jupiterpa.template.domain.service.*;


@RequestMapping(path = Controller.PATH)
@RestController
@Api(value="template", description="A template service")
public class Controller {
    public static final String PATH ="/";
    
    @Autowired TemplateEntityRepo repo;
    @Autowired TemplateService service;
    
    @GetMapping("")
    @ApiOperation(value = "Get Entity", response = TemplateEntity.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved Weather")
    })
    public List<TemplateEntity> get() {  
    	return repo.findAll();
    }
    
    @PostMapping("")
    @ApiOperation(value = "Store an Entity")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Updated Successfully")
    })
    public void update(@RequestBody TemplateEntity entity) {
    	service.store(entity);
    }

}
