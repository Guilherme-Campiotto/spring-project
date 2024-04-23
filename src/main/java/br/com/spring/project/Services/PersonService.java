package br.com.spring.project.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.spring.project.Exceptions.ResourceNotFoundException;
import br.com.spring.project.Model.Person;
import br.com.spring.project.Repositories.PersonRepository;


@Service
public class PersonService {
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository personRepository;

    public Person findById(String id) {
        logger.info("Finding person");
        Person person = personRepository.findById(Long.valueOf(id))
            .orElseThrow(() -> new ResourceNotFoundException("No records found for id: " + id));
        
        return person;
    }

    public List<Person> findAll() {
        logger.info("Listing all persons");
        List<Person> personList = personRepository.findAll();

        return personList;
    }

    public Person createPerson(Person person) {
        logger.info("Creating person");
        
        return personRepository.save(person);
    }

    public Person updatePerson(Person person) {
        logger.info("Updating person");

        Person personFound = personRepository.findById(person.getId())
            .orElseThrow(() -> new ResourceNotFoundException("No records found for id: " + person.getId()));

        personFound.setFirstName(person.getFirstName());
        personFound.setLastName(person.getLastName());
        personFound.setAddress(person.getAddress());
        personFound.setGender(person.getGender());
        
        return personRepository.save(personFound);
    }

    public void deletePerson(String id) {
        logger.info("Deleting person");

        Person personFound = personRepository.findById(Long.valueOf(id))
        .orElseThrow(() -> new ResourceNotFoundException("No records found for id: " + id));

        personRepository.delete(personFound);

    }
}
