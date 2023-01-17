package com.pitz.localtravel.service;

import com.pitz.localtravel.domain.Student;
import com.pitz.localtravel.dto.student.SaveStudentDTO;
import com.pitz.localtravel.repositories.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {

    private StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> list() {
        return studentRepository.findAll();
    }

    public Student save(SaveStudentDTO studentDTO) {
        validateSave(studentDTO);

        Student student = new Student(studentDTO.getName(),
                studentDTO.getEmail(),
                studentDTO.getDob());
        return studentRepository.save(student);
    }

    private void validateSave(SaveStudentDTO studentDTO) {
        Optional<Student> student = studentRepository.findStudentByEmail(studentDTO.getEmail());
        if (student.isPresent()) throw new IllegalStateException("E-mail already in use!");
    }
}
