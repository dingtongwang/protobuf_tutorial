package com.csu.controller;

import com.csu.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingController.class)
class GreetingControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private GreetingService service;

  @Test
  void should_return_ok_when_call_API() throws Exception {
    when(service.greet()).thenReturn("Hello World");

    mockMvc.perform(get("/greeting"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Hello World")));
  }
}