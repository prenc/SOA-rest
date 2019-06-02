package students;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "t_subjects")
public class SubjectJPA implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(name = "students_to_subjects", joinColumns = @JoinColumn(name = "subjectsID"), inverseJoinColumns = @JoinColumn(name = "studentsID"))
    private List<StudentJPA> studentId;

    public SubjectJPA() {
    }

    public List<StudentJPA> getStudentId() {
        return studentId;
    }

    public void setStudentId(List<StudentJPA> studentsId) {
        this.studentId = studentsId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
