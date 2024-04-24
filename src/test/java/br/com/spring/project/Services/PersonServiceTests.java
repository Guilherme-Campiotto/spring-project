package br.com.spring.project.Services;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.spring.project.Exceptions.ResourceNotFoundException;
import br.com.spring.project.Model.Person;
import br.com.spring.project.Repositories.PersonRepository;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTests {

    Person person;

    @Mock
    PersonRepository personRepository;

    @InjectMocks
    PersonService personService;

    @BeforeEach
    public void setup() {
        person = new Person(
            "Guilherme", 
             "Campiotto", 
              "Carapicuiba", 
               "M", 
                "g_camps@email.com");

    }

    @Test
    void testGivenPersonWhenSavePersonShouldReturnNewPerson() {
        Mockito.when(personRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.empty());
        Mockito.when(personRepository.save(person)).thenReturn(person);

        Person personSaved = personService.createPerson(person);

        Assertions.assertNotNull(personSaved);
        Assertions.assertEquals("Guilherme", personSaved.getFirstName());
    }

    @Test
    void testGivenExistingEmailWhenSavePersonShouldThrowException() {
        Mockito.when(personRepository.findByEmail(Mockito.anyString())).thenReturn(Optional.of(person));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            personService.createPerson(person);
        });

        Mockito.verify(personRepository, never()).save(any(Person.class));
    }
}
