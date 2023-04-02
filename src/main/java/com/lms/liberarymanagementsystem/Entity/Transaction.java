package com.lms.liberarymanagementsystem.Entity;

import com.lms.liberarymanagementsystem.Enum.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    private String transationNumber;
    @Enumerated(EnumType.STRING)
    TransactionStatus transactionStatus;

    @CreatedDate
    private Date transationDate;

    private boolean isIssueOperation;
    private String message;

    @ManyToOne
    @JoinColumn
    Book book;

    @ManyToOne
    @JoinColumn
    LiberaryCard card;




}
