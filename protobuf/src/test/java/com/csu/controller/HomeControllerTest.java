package com.csu.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void should_return_ok_when_call_API() throws Exception {

    mockMvc.perform(get("/home"))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("welcome to home")));
  }
}