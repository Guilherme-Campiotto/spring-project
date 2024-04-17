package br.com.spring.project.Controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.spring.project.Model.Person;
import br.com.spring.project.Services.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value= "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(
        @PathVariable( "id") String id) {

        return personService.findById(id);
    }
 
}
