package xyz.mdynani.etiqaassessment.service;

import org.springframework.stereotype.Service;
import xyz.mdynani.etiqaassessment.model.Course;
import xyz.mdynani.etiqaassessment.repository.CourseRepository;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService
{
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository)
    {
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveCourse(Course course)
    {
        courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourse()
    {
        return courseRepository.findAll();
    }

    @Override
    public Course getAllStudentByCourseId(Long courseId)
    {
        return courseRepository.findById(courseId).orElseThrow(() -> new IllegalStateException("Course with id " + courseId + " does not exist!"));
    }
}
