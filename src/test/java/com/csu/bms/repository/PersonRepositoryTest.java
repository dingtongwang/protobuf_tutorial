package com.csu.bms.repository;

import com.csu.bms.model.Address;
import com.csu.bms.model.Person;
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
class PersonRepositoryTest {

  @Autowired
  PersonRepository personRepository;

  @Test
  void should_return_person_size_when_find_all_given_person() {
    //Given
    Person person1 = Person.builder().id("1").firstName("Ding").lastName("tongwang").build();
    Person person2 = Person.builder().id("2").firstName("Yan").lastName("Yu").build();
    personRepository.save(person1);
    personRepository.save(person2);

    //When
    List<Person> personList = personRepository.findAll();

    //Then
    assertEquals(2, personList.size());
  }

  @Test
  void should_return_correct_person_when_save_given_person_with_address() {
    //Given
    Address address = Address.builder()
        .country("China")
        .city("XinYang")
        .postalCode("")
        .street("")
        .houseNo("2-2")
        .flatNo("1402")
        .build();
    Person person = Person.builder()
        .id("1")
        .firstName("Ding")
        .lastName("tongwang")
        .address(address)
        .build();

    //When
    Person actual = personRepository.save(person);

    //Then
    assertEquals(address, actual.getAddress());
  }
}