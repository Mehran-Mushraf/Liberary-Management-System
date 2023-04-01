package com.lms.liberarymanagementsystem.Service;

import com.lms.liberarymanagementsystem.Entity.Author;
import com.lms.liberarymanagementsystem.Entity.Book;
import com.lms.liberarymanagementsystem.Repository.AuthorRepository;
import com.lms.liberarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public String addBook(Book book) throws Exception {
        Author author;

        try {
            author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e) {
            return "Book not added";
        }

        List<Book> booksWritten = author.getBooks();
        booksWritten.add(book);

        authorRepository.save(author);
        return "Book added successfully";
    }


}
