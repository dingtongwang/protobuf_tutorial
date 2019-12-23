package com.csu.kafka;

import com.example.tutorial.AddressBookProtos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
  @Autowired
  private Producer producer;

  private AddressBookProtos.Person initPerson() {

    AddressBookProtos.Person.PhoneNumber phoneNumber1 = AddressBookProtos.Person.PhoneNumber.newBuilder()
        .setNumber("110")
        .setType(AddressBookProtos.Person.PhoneType.WORK).build();

    AddressBookProtos.Person.PhoneNumber phoneNumber2 = AddressBookProtos.Person.PhoneNumber.newBuilder()
        .setNumber("123")
        .setType(AddressBookProtos.Person.PhoneType.WORK).build();

    AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
        .setName("Zhang San")
        .setId(123)
        .setEmail("123456@hello.com")
        .addPhones(phoneNumber1)
        .addPhones(phoneNumber2)
        .build();

    return person;
  }

  @GetMapping(value = "/publish")
  public void sendMessageToKafkaTopic(){

    AddressBookProtos.Person person = initPerson();
    System.out.println("person: " + person.toString());

    this.producer.sendMessage(person.toByteArray());
  }

  @GetMapping(value = "/writeToFile")
  public void writeMessageToFile() {

    AddressBookProtos.Person person = initPerson();
    System.out.println("person: " + person.toString());

    try {
      File file = ResourceUtils.getFile("classpath:protobufFile.txt");

      OutputStream outputStream = new FileOutputStream(file);
      person.writeTo(outputStream);
      outputStream.flush();
      outputStream.close();
      System.out.println("The length of protobufFile: " + file.length());

      InputStream inputStream = new FileInputStream(file);
      AddressBookProtos.Person person2 = AddressBookProtos.Person.parseFrom(inputStream);
      System.out.println("The name of person2: " + person2.getName());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
