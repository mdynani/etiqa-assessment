package xyz.mdynani.etiqaassessment.service;

import org.springframework.stereotype.Service;
import xyz.mdynani.etiqaassessment.repository.CourseRepository;
import xyz.mdynani.etiqaassessment.repository.StudentRepository;
import xyz.mdynani.etiqaassessment.model.Student;

import javax.validation.Validator;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService
{
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository studentRepository, CourseRepository courseRepository)
    {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public Student saveStudent(Student student)
    {
        boolean courseExist = courseRepository.findById(student.getCourse().getId()).isPresent();
        if (!courseExist)
        {
            throw new IllegalStateException("Course with id " + student.getCourse().getId() + " does not exist!");
        }
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent()
    {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentById(Long studentId)
    {
        return studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Student with id " + studentId + " does not exist!"));
    }

    @Override
    public void updateStudent(Student student)
    {
        boolean courseExist = courseRepository.findById(student.getCourse().getId()).isPresent();
        if (!courseExist)
        {
            throw new IllegalStateException("Course with id " + student.getCourse().getId() + " does not exist!");
        }
        studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long studentId)
    {
        boolean exist = studentRepository.existsById(studentId);
        if (!exist)
        {
            throw new IllegalStateException("Student with id " + studentId + " does not exist!");
        }
        studentRepository.deleteById(studentId);
    }
}
