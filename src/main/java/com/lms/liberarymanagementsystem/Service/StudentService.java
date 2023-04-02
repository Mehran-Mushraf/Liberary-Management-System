package com.lms.liberarymanagementsystem.Service;

import com.lms.liberarymanagementsystem.DTO.StudentRequestDto;
import com.lms.liberarymanagementsystem.DTO.StudentResponseDto;
import com.lms.liberarymanagementsystem.DTO.StudentUpdateEmailRequestDto;
import com.lms.liberarymanagementsystem.Entity.LiberaryCard;
import com.lms.liberarymanagementsystem.Entity.Student;
import com.lms.liberarymanagementsystem.Enum.CardStatus;
import com.lms.liberarymanagementsystem.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;
        public void addStudent(StudentRequestDto studentRequestDto) {
        // create a student object
            Student student  = new Student();
            student.setAge(studentRequestDto.getAge());
            student.setName(studentRequestDto.getName());
            student.setDepartment(studentRequestDto.getDepartment());
            student.setEmail(studentRequestDto.getEmail());

//            create a card Object
            LiberaryCard card = new LiberaryCard();
            card.setStatus(CardStatus.ACTIVATED);
            card.setStudent(student);

//            set card in student
            student.setCard(card);

//            check
            studentRepository.save(student);

    }

    public String findByEmail(String email) {
        Student student = studentRepository.findByEmail(email);
        return student.getName();
    }

    public List<Student> findStudentsByAge( int age) {
        return studentRepository.findByAge(age);
    }

    public StudentResponseDto updateMob(StudentUpdateEmailRequestDto studentUpdateEmailRequestDto) {

        Student student = studentRepository.findById(studentUpdateEmailRequestDto.getId()).get();
        student.setEmail(studentUpdateEmailRequestDto.getEmail());

//        update step
        Student updatedStudent = studentRepository.save(student);


//        convert updated studetn to response dto
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(updatedStudent.getId());
        studentResponseDto.setName(updatedStudent.getName());
        studentResponseDto.setEmail(updatedStudent.getEmail());

        return studentResponseDto;
    }


}
