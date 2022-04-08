package xyz.mdynani.etiqaassessment.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
@Table(name = "student")
public class Student implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Identification is required!")
    @Size(min = 3, max = 50, message = "Email must be between 3 and 50 characters long")
    @Column(length = 50, unique = true, nullable = false)
    private String identification;
    @NotEmpty(message = "Name is required!")
    @Size(min = 3, max = 255, message = "Email must be between 3 and 255 characters long")
    @Column(nullable = false)
    private String name;
    @Email
    @NotEmpty(message = "Email is required!")
    @Size(min = 5, max = 254, message = "Email must be between 5 and 254 characters long")
    @Column(length = 254, unique = true, nullable = false)
    private String email;
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private Course course;
}
