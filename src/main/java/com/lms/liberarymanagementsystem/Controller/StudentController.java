package com.lms.liberarymanagementsystem.Controller;

import com.lms.liberarymanagementsystem.DTO.StudentRequestDto;
import com.lms.liberarymanagementsystem.DTO.StudentResponseDto;
import com.lms.liberarymanagementsystem.Entity.Student;
import com.lms.liberarymanagementsystem.DTO.StudentUpdateEmailRequestDto;
import com.lms.liberarymanagementsystem.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto) {
        studentService.addStudent(studentRequestDto);
        return "Student Added Successfully";
    }

    @GetMapping("/find_by_email")
    public String findStudentByEmail(@RequestParam("email") String email) {
        return studentService.findByEmail(email);
    }

    @GetMapping("students_get_by_age")
    public List<Student> findStudentsByAge(@RequestParam("age") int age) {
        return studentService.findStudentsByAge(age);
    }

    @PutMapping("/update_mob")
    public StudentResponseDto updateMob(@RequestBody StudentUpdateEmailRequestDto studentUpdateEmailRequestDto) {
        return studentService.updateMob(studentUpdateEmailRequestDto);
    }



}
