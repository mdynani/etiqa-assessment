package xyz.mdynani.etiqaassessment.controller;

import org.springframework.web.bind.annotation.*;
import xyz.mdynani.etiqaassessment.model.Course;
import xyz.mdynani.etiqaassessment.service.CourseService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController
{
    private final CourseService courseService;

    public CourseController(CourseService courseService)
    {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllCourse(){
       return courseService.getAllCourse();
    }

    @PostMapping
    public void saveCourse(@Valid @RequestBody Course course){
        courseService.saveCourse(course);
    }

    @GetMapping(path = "/{courseId}/students")
    public Course getAllStudentByCourseId(@PathVariable Long courseId){
        return courseService.getAllStudentByCourseId(courseId);
    }
}
