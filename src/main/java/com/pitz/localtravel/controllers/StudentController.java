package com.pitz.localtravel.controllers;

import com.pitz.localtravel.domain.Student;
import com.pitz.localtravel.dto.student.SaveStudentDTO;
import com.pitz.localtravel.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/list")
    public List<Student> list() {
        return studentService.list();
    }

    @PostMapping()
    public Student save(@RequestBody SaveStudentDTO studentDTO) {
        return studentService.save(studentDTO);
    }
}
