package com.csu.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class Producer {
  private static final String TOPIC = "users";

  @Autowired
  private KafkaTemplate<String,byte[]> kafkaTemplate;

  public void sendMessage(byte[] message){
    System.out.println("---------Producer: message length is "+ message.length);
    this.kafkaTemplate.send(TOPIC,message);
  }
}
