package xyz.mdynani.etiqaassessment.service;

import xyz.mdynani.etiqaassessment.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService
{
    Student saveStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(Long studentId);

    void updateStudent(Student student);

    void deleteStudent(Long studentId);
}
