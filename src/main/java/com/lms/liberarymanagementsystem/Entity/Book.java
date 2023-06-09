package com.lms.liberarymanagementsystem.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int price;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    private boolean isIssued;

    @ManyToOne
    @JoinColumn
//    @JsonIgnore
    Author author;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL)
    List<Transaction> transactions = new ArrayList<>();

    @ManyToOne
    @JoinColumn
    LiberaryCard card;




}
