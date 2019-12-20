package com.csu.repository;

import com.csu.model.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase
class PersonsRepositoryTest {

  @Autowired
  PersonsRepository personsRepository;

  @Test
  void should_return_person_size_when_find_all_given_person() {
    //Given
    Person person1 = Person.builder().id("1").firstName("Ding").lastName("tongwang").build();
    Person person2 = Person.builder().id("2").firstName("Yan").lastName("Yu").build();
    personsRepository.save(person1);
    personsRepository.save(person2);

    //When
    List<Person> personList = personsRepository.findAll();

    //Then
    assertEquals(2, personList.size());
  }
}