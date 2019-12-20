package com.csu.controller;

import com.csu.model.Person;
import com.csu.repository.PersonsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

  @Autowired
  private PersonsRepository repository;

  @GetMapping
  public List<Person> findAll() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Optional<Person> findById(@PathVariable("id") String id) {
    return repository.findById(id);
  }

  @PostMapping
  public Person add(@RequestBody Person person) {
    return repository.save(person);
  }
}
