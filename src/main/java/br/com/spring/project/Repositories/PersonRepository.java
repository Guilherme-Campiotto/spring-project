package br.com.spring.project.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.spring.project.Model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}