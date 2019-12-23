package com.csu.bms;

import com.csu.bms.model.Person;
import com.csu.bms.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping
  public List<Person> findAllPersons() {
    return personService.findAllPersons();
  }

  @GetMapping("/{id}")
  public Person findPersonById(@PathVariable("id") String id) {
    return personService.findPersonById(id);
  }

  @PostMapping
  public Person createPerson(@RequestBody Person person) {
    return personService.createPerson(person);
  }
}
