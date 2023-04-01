package com.lms.liberarymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.lms.liberarymanagementsystem.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
