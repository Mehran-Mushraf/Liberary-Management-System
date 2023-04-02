package com.lms.liberarymanagementsystem.Service;

import com.lms.liberarymanagementsystem.DTO.BookRequestDto;
import com.lms.liberarymanagementsystem.DTO.BookResponseDto;
import com.lms.liberarymanagementsystem.Entity.Author;
import com.lms.liberarymanagementsystem.Entity.Book;
import com.lms.liberarymanagementsystem.Repository.AuthorRepository;
import com.lms.liberarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorRepository authorRepository;

    public BookResponseDto addBook(BookRequestDto bookRequestDto) throws Exception {


//             get the author object
        Author author = authorRepository.findById(bookRequestDto.getAuthorId()).get();

        Book book = new Book();
        book.setTitle(bookRequestDto.getTitle());
        book.setGenre(bookRequestDto.getGenre());
        book.setPrice(bookRequestDto.getPrice());
        book.setIssued(false);
        book.setAuthor(author);

        author.getBooks().add(book);
        authorRepository.save(author); //this will save both book and author object

//      create a response alse
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setTitle(book.getTitle());
        bookResponseDto.setPrice(book.getPrice());

        return bookResponseDto;


    }


}
