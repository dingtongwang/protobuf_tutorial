package com.csu.bms.service;

import com.csu.bms.model.Person;
import com.csu.bms.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

  @Autowired
  private PersonRepository personRepository;

  public List<Person> findAllPersons() {
    return personRepository.findAll();
  }

  public Person findPersonById(String id) {
    Optional<Person> optionalPerson = personRepository.findById(id);
    if (optionalPerson.isPresent()) {
      return optionalPerson.get();
    }
    return null;
  }

  public Person createPerson(Person person) {
    return personRepository.save(person);
  }
}
