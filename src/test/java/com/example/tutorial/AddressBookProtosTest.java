package com.example.tutorial;

import com.google.protobuf.Descriptors;
import org.junit.jupiter.api.Test;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class AddressBookProtosTest
{
  @Test
  void InitPersonWithEmail() {
    AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
        .setName("Zhang San")
        .setId(123)
        .setEmail("123456@hello.com")
        .build();

    assertThat(person.getName(), is("Zhang San"));
    assertThat(person.getId(), is(123));
    assertThat(person.hasEmail(), is(true));
  }

  @Test
  void InitPersonWithoutEmail() {
    AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
        .setName("Zhang San")
        .setId(123)
        .build();

    assertThat(person.getName(), is("Zhang San"));
    assertThat(person.getId(), is(123));
    assertThat(person.hasEmail(), is(false));
  }

  @Test
  void InitPersonWithoutPhoneNumber() {
    AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
        .setName("Zhang San")
        .setId(123)
        .setEmail("123456@hello.com")
        .build();

    assertThat(person.getName(), is("Zhang San"));
    assertThat(person.getId(), is(123));
    assertThat(person.getEmail(), is("123456@hello.com"));

    assertThat(person.getPhonesCount(), is(0));
  }

  @Test
  void InitPersonWithPhoneNumber() {
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

    assertThat(person.getName(), is("Zhang San"));
    assertThat(person.getId(), is(123));
    assertThat(person.getEmail(), is("123456@hello.com"));

    assertThat(person.getPhonesCount(), is(2));
  }

  @Test
  void PrintFiledNameGivenPersonWithPhoneNumber() {
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

    Map<Descriptors.FieldDescriptor, Object> FieldsMap = person.getAllFields();
    FieldsMap.forEach((k, v) -> {

      System.out.println("filed name:" + k.getName());
    });
  }

  @Test
  void PrintFiledNameGivenPersonWithoutPhoneNumber() {
    AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
        .setName("Zhang San")
        .setId(123)
        .setEmail("123456@hello.com")
        .build();

    Map<Descriptors.FieldDescriptor, Object> FieldsMap = person.getAllFields();
    FieldsMap.forEach((k, v) -> {

      System.out.println("filed name:" + k.getName());
    });
  }


  @Test
  void CallToStringOfPerson() {
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

    System.out.println(person.toString());
  }


  @Test
  void CallMergeFromOfPerson() {
    AddressBookProtos.Person.PhoneNumber phoneNumber1 = AddressBookProtos.Person.PhoneNumber.newBuilder()
        .setNumber("110")
        .setType(AddressBookProtos.Person.PhoneType.WORK).build();

    AddressBookProtos.Person.PhoneNumber phoneNumber2 = AddressBookProtos.Person.PhoneNumber.newBuilder()
        .setNumber("123")
        .setType(AddressBookProtos.Person.PhoneType.WORK).build();

    AddressBookProtos.Person person1 = AddressBookProtos.Person.newBuilder()
        .setName("Zhang San")
        .setId(123)
        .setEmail("123456@hello.com")
        .addPhones(phoneNumber1)
        .addPhones(phoneNumber2)
        .build();

    System.out.println("person1: " + person1.toString());

    AddressBookProtos.Person.Builder personBuilder = AddressBookProtos.Person.newBuilder().mergeFrom(person1);

    System.out.println("person2: " + personBuilder.setName("Li Si").build().toString());
  }


  @Test
  void CallWriteToAndParseFromOfPerson() {
    AddressBookProtos.Person.PhoneNumber phoneNumber1 = AddressBookProtos.Person.PhoneNumber.newBuilder()
        .setNumber("110")
        .setType(AddressBookProtos.Person.PhoneType.WORK).build();

    AddressBookProtos.Person.PhoneNumber phoneNumber2 = AddressBookProtos.Person.PhoneNumber.newBuilder()
        .setNumber("123")
        .setType(AddressBookProtos.Person.PhoneType.WORK).build();

    AddressBookProtos.Person person1 = AddressBookProtos.Person.newBuilder()
        .setName("Zhang San")
        .setId(123)
        .setEmail("123456@hello.com")
        .addPhones(phoneNumber1)
        .addPhones(phoneNumber2)
        .build();

    System.out.println("person1: " + person1.toString());

    try {
      File file = ResourceUtils.getFile("classpath:protobufFile.txt");

      OutputStream outputStream = new FileOutputStream(file);
      person1.writeTo(outputStream);
      outputStream.close();
      System.out.println("The length of protobufFile: " + file.length());

      InputStream inputStream = new FileInputStream(file);
      AddressBookProtos.Person person2 = AddressBookProtos.Person.parseFrom(inputStream);
      System.out.println("The name of person2: " + person2.getName());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @Test
  void CallGetSerializedSizeOfPerson() {
    AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
        .setName("Zhang San")
        .setId(123)
        .setEmail("123456@hello.com")
        .build();

    System.out.println("==================" + person.getSerializedSize());
  }

  @Test
  void ConvertMessageToJson() {
    AddressBookProtos.Person person = AddressBookProtos.Person.newBuilder()
        .setName("Zhang San")
        .setId(123)
        .setEmail("123456@hello.com")
        .build();
  }
}