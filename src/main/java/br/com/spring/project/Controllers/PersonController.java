package br.com.spring.project.Controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.spring.project.Model.Person;
import br.com.spring.project.Services.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping(value= "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findPerson(
        @PathVariable( "id") String id) {

        return personService.findById(id);
    }

    @GetMapping(value= "/list-all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAllPersons() {
        return personService.findAll();
    }
 
    @PostMapping(value= "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    @PutMapping(value= "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Person updatePerson(@RequestBody Person person) {
        return personService.updatePerson(person);
    }

    @DeleteMapping(value= "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deletePerson(@PathVariable( "id") String id) {
        personService.deletePerson(id);
    }
}
