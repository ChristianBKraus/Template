package jupiterpa.template.intf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.*;
import jupiterpa.template.domain.model.*;
import jupiterpa.template.domain.service.*;


@RequestMapping(path = Controller.PATH)
@RestController
@Api(value="template controller", description="Template Controller")
public class Controller {
    public static final String PATH ="/template";
    
    @Autowired TemplateRepo repo;
    @Autowired TemplateService service;
    
    @GetMapping("")
    @ApiOperation(value = "GET first Entity", response = TemplateEntity.class)
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Successfully retrieved Entity")
    })
    public TemplateEntity get() {  
    	return repo.findAll().get(0);
    }
    
    @PostMapping("")
    @ApiOperation(value = "Create new Entity")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Created Successfully")
    })
    public TemplateEntity post(@RequestBody TemplateEntity entity) {
    	return service.create(entity);
    }

}
