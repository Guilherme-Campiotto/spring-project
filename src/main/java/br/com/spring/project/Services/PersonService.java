package br.com.spring.project.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import br.com.spring.project.Model.Person;


@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding person");
        Person person = mockNewPerson(Integer.valueOf(id));
        return person;
    }

    public List<Person> findAll() {
        logger.info("Listing all persons");
        List<Person> personList = new ArrayList<>();

        for(int i = 0; i < 8 ; i++) {
            Person mockPerson = mockNewPerson(i);
            personList.add(mockPerson);
        }

        return personList;
    }

    public Person createPerson(Person person) {
        logger.info("Creating person");
        
        return person;
    }

    public Person updatePerson(Person person) {
        logger.info("Updating person");
        
        return person;
    }

    public void deletePerson(String id) {
        logger.info("Deleting person");
    }

    private Person mockNewPerson(int index) {
        Person mockPerson = new Person();
        mockPerson.setId(counter.incrementAndGet());
        mockPerson.setFirstName("Guilherme " + index);
        mockPerson.setLastName("Campiotto");
        mockPerson.setAdress("Carapicuiba address " + index);
        mockPerson.setGender("M");
        return mockPerson;
    }
}
