package com.lms.liberarymanagementsystem.Repository;

import com.lms.liberarymanagementsystem.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
