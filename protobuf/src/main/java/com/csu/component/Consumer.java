package com.csu.component;

import com.example.tutorial.AddressBookProtos;
import com.google.protobuf.InvalidProtocolBufferException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Base64;

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
