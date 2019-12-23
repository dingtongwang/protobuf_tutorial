package com.csu.kafka;

import com.example.tutorial.AddressBookProtos;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

  //@KafkaListener(topics = "users", groupId = "group_id")
  public void consume(byte[] message){
    System.out.println("---------Consumer: message length is "+ message.length);
    try {
      AddressBookProtos.Person person = AddressBookProtos.Person.parseFrom(message);
      System.out.println("The name of the person is: " + person.getName());
    } catch (InvalidProtocolBufferException e) {
      e.printStackTrace();
    }
  }
}
