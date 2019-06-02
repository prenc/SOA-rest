package students;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "t_subjects")
public class SubjectJPA {

    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToMany
    @JoinTable(name = "t_students", inverseJoinColumns = @JoinColumn(name = "studentID"))
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

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
