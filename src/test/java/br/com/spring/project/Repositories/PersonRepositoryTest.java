package br.com.spring.project.Repositories;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.spring.project.Model.Person;

@DataJpaTest
public class PersonRepositoryTest {

    @Autowired
    PersonRepository repository;

    @Test
    void testGivenPersonObjectWhenSavedThenReturnSavedPerson() {
        Person person = new Person("Guilherme", "Campiotto", "Carapicuiba", "M", "g_camps@email.com"); //Mockito.mock(Person.class);
    
        Person savedPerson = repository.save(person);
        Assertions.assertNotNull(savedPerson);
        Assertions.assertTrue(savedPerson.getId() > 0);
    }

    @Test
    void testGivenPersonListWhenFindAllThenReturnSavedPerson() {
        Person personOne = new Person("Guilherme", "Campiotto", "Carapicuiba", "M", "g_camps@email.com");
        Person personTwo = new Person("Fulano", "Silva", "Carapicuiba", "M", "g_camps@email.com");


        repository.save(personOne);
        repository.save(personTwo);

        List<Person> personList = repository.findAll();

        Assertions.assertEquals(2, personList.size());
    }

    @Test
    void testGivenPersonObjectWhenFindByIdThenReturnPerson() {
        Person person = new Person("Guilherme", "Campiotto", "Carapicuiba", "M", "g_camps@email.com");

        repository.save(person);

        Person personSaved = repository.findById(person.getId()).get();

        Assertions.assertNotNull(personSaved);
        Assertions.assertEquals(person.getId(), personSaved.getId());
    }

    @Test
    void testGivenPersonObjectWhenFindByEmailThenReturnPerson() {
        Person person = new Person("Guilherme", "Campiotto", "Carapicuiba", "M", "g_camps@email.com"); //Mockito.mock(Person.class);

        repository.save(person);

        Person personSaved = repository.findByEmail(person.getEmail()).get();

        Assertions.assertNotNull(personSaved);
        Assertions.assertEquals(person.getEmail(), personSaved.getEmail());
    }

    @Test
    void testGivenPersonObjectWhenUpdateThenReturnUpdatedPerson() {
        Person person = new Person("Guilherme", "Campiotto", "Carapicuiba", "M", "g_camps@email.com");

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
}
