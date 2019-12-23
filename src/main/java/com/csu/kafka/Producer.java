package com.csu.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

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
