package xyz.mdynani.etiqaassessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.mdynani.etiqaassessment.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long>
{
}
