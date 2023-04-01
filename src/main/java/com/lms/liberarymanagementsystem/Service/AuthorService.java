package com.lms.liberarymanagementsystem.Service;

import com.lms.liberarymanagementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lms.liberarymanagementsystem.Entity.*;

import java.util.List;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public void addAuthor(Author author) {
        authorRepository.save(author);
        System.out.println(author.getName() + author.getAge());

    }
    public List<Author> getAuthor() {
        return authorRepository.findAll();
    }
}
