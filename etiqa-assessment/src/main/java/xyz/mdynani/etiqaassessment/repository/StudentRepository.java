package xyz.mdynani.etiqaassessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.mdynani.etiqaassessment.model.Student;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>
{
//    @Query("SELECT s from Student s WHERE s.identification= ?1")
    Optional<Student> findStudentByIdentification(String identification);

    //    @Query("SELECT s from Student s WHERE s.email= ?1")
    Optional<Student> findStudentByEmail(String email);
}
