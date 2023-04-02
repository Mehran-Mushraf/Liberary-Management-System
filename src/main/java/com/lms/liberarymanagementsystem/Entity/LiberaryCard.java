package com.lms.liberarymanagementsystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lms.liberarymanagementsystem.Enum.CardStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class LiberaryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cardNo;

    @Enumerated(EnumType.STRING)
    private CardStatus status;

    @CreationTimestamp
    private Date createionDate;
    @UpdateTimestamp
    private Date updationDate;

    @OneToOne
    @JoinColumn
    @JsonIgnore
    Student student;

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Transaction> transactionList = new ArrayList<>();

    @OneToMany(mappedBy = "card", cascade = CascadeType.ALL)
    List<Book> booksIssued = new ArrayList<>();

}
