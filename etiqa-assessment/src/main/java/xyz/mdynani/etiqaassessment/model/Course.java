package xyz.mdynani.etiqaassessment.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import org.springframework.util.CollectionUtils;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "course")
public class Course implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message = "Course name is required!")
    @Size(min = 3, max = 255, message = "Email must be between 3 and 255 characters long")
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "course", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Student> students;
    @Transient
    private Integer countStudent;

    /**
     * @return the countStudent
     */
    public Integer getCountStudent()
    {
        return CollectionUtils.isEmpty(students) ? 0 : students.size();
    }
}
