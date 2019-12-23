package com.csu.bms;

import com.csu.bms.model.Book;
import com.csu.bms.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @GetMapping("/{id}")
  public Book findById(@PathVariable("id") int id) {
    return bookService.findBookById(id);
  }
}
