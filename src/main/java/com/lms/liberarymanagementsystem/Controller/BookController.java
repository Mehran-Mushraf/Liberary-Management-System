package com.lms.liberarymanagementsystem.Controller;

import com.lms.liberarymanagementsystem.Entity.Author;
import com.lms.liberarymanagementsystem.Entity.Book;
import com.lms.liberarymanagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public String addBook(@RequestBody Book book) {
       try {
           return bookService.addBook(book);
       }
       catch (Exception e) {
           throw new RuntimeException(e.getMessage() + "Book not added");
       }
//        return "Book Added Successfully";
    }



}
