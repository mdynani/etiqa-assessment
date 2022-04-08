package xyz.mdynani.etiqaassessment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import xyz.mdynani.etiqaassessment.model.Student;
import xyz.mdynani.etiqaassessment.service.StudentService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @PostMapping
    public void saveStudent(@Valid @RequestBody Student student)
    {
        studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudent()
    {
        return studentService.getAllStudent();
    }

    @GetMapping(path = "/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId)
    {
        return new ResponseEntity<>(studentService.getStudentById(studentId), HttpStatus.OK);
    }

    @PutMapping
    public void updateStudent(@Valid @RequestBody Student student)
    {
        studentService.updateStudent(student);
    }

    @DeleteMapping(path = "/{studentId}")
    public void deleteStudent(@PathVariable Long studentId)
    {
        studentService.deleteStudent(studentId);
    }
}
