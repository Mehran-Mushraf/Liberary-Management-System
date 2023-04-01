package com.lms.liberarymanagementsystem.Entity;

import com.lms.liberarymanagementsystem.Enum.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    Department department;
    @Column(unique = true)
    private String email;

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    LiberaryCard card;
}
