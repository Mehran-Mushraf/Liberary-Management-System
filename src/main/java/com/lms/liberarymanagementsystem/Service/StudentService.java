package com.lms.liberarymanagementsystem.Service;

import com.lms.liberarymanagementsystem.Entity.LiberaryCard;
import com.lms.liberarymanagementsystem.Entity.Student;
import com.lms.liberarymanagementsystem.Enum.CardStatus;
import com.lms.liberarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
    public void addStudent(Student student) {
        LiberaryCard card = new LiberaryCard();
        card.setStatus(CardStatus.ACTIVATED);
        card.setValidTill("03/2025");
        card.setStudent(student);
//        set the card attribute in student
        student.setCard(card);
        studentRepository.save(student);
    }
}
