package com.csu.bms.service;

import com.csu.bms.model.Book;
import com.csu.bms.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

  @Autowired
  private BookRepository bookRepository;

  public Book findBookById(int id) {
    Optional<Book> optionalBook = bookRepository.findById(id);
    if (optionalBook.isPresent()) {
      return optionalBook.get();
    }
    return null;
  }
}
