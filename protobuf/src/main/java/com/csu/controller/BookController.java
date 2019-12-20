package com.csu.controller;

import com.csu.model.Book;
import com.csu.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/books")
public class BookController {
  @Autowired
  private BookRepository bookRepository;

  @GetMapping("/{id}")
  public Optional<Book> findById(@PathVariable("id") int id) {
    return bookRepository.findById(id);
  }
}
