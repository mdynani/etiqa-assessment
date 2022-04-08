package xyz.mdynani.etiqaassessment.service;

import xyz.mdynani.etiqaassessment.model.Course;

import java.util.List;

public interface CourseService
{
    void saveCourse(Course course);

    List<Course> getAllCourse();

    Course getAllStudentByCourseId(Long courseId);
}
