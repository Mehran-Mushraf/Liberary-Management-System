package com.lms.liberarymanagementsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lms.liberarymanagementsystem.Entity.Author;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {

}
