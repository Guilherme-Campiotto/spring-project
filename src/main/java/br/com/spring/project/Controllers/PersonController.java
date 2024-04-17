package br.com.spring.project.Controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.spring.project.Model.Person;
import br.com.spring.project.Services.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value= "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(
        @PathVariable( "id") String id) {

        return personService.findById(id);
    }

    @GetMapping(value= "/list-all/", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAllPersons() {

        return personService.findAll();
    }
 
}
