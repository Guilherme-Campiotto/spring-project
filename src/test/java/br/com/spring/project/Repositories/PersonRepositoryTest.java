package br.com.spring.project.Repositories;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.spring.project.Model.Person;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository repository;

    private Person person;
    private Person personTwo;

    @BeforeEach
    public void setup() {
        person = new Person(
            "Guilherme", 
             "Campiotto", 
              "Carapicuiba", 
               "M", 
                "g_camps@email.com");
        personTwo = new Person(
            "Fulano",
             "Silva",
              "Carapicuiba",
               "M",
                "g_camps@email.com");

    }

    @Test
    void testGivenPersonObjectWhenSavedThenReturnSavedPerson() {    
        Person savedPerson = repository.save(person);
        Assertions.assertNotNull(savedPerson);
        Assertions.assertTrue(savedPerson.getId() > 0);
    }

    @Test
    void testGivenPersonListWhenFindAllThenReturnSavedPerson() {
        repository.save(person);
        repository.save(personTwo);

        List<Person> personList = repository.findAll();

        Assertions.assertEquals(2, personList.size());
    }

    @Test
    void testGivenPersonObjectWhenFindByIdThenReturnPerson() {

        repository.save(person);

        Person personSaved = repository.findById(person.getId()).get();

        Assertions.assertNotNull(personSaved);
        Assertions.assertEquals(person.getId(), personSaved.getId());
    }

    @Test
    void testGivenPersonObjectWhenFindByEmailThenReturnPerson() {
        repository.save(person);

        Person personSaved = repository.findByEmail(person.getEmail()).get();

        Assertions.assertNotNull(personSaved);
        Assertions.assertEquals(person.getEmail(), personSaved.getEmail());
    }

    @Test
    void testGivenPersonObjectWhenUpdateThenReturnUpdatedPerson() {
        repository.save(person);

        Person personSaved = repository.findById(person.getId()).get();

        personSaved.setFirstName("William");
        personSaved.setEmail("g_camps2@email.com");
        repository.save(personSaved);

        Person personUpdated = repository.findById(person.getId()).get();

        Assertions.assertNotNull(personUpdated);
        Assertions.assertEquals("William", personUpdated.getFirstName());
        Assertions.assertEquals("g_camps2@email.com", personUpdated.getEmail());
    }
    
    @Test
    void testGivenPersonObjectWhenDeleteThenRemovePerson() {
        repository.save(person);

        repository.deleteById(person.getId());

        Optional<Person> personOptional = repository.findById(person.getId());

        Assertions.assertTrue(personOptional.isEmpty());
    }

    @Test
    void testGivenPersonObjectWhenFindByNameThenReturnPerson() {
        repository.save(person);

        Person personSaved = repository.findPersonByName(person.getFirstName(), person.getLastName());

        Assertions.assertNotNull(personSaved);
        Assertions.assertEquals(person.getId(), personSaved.getId());
    }
}
