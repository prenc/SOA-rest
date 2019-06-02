package students;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "t_subjects")
public class SubjectJPA {

    private Integer id;
    private String name;

    @ManyToMany
    private List<StudentJPA> studentsId;


    public SubjectJPA() {
    }

    public List<StudentJPA> getStudentsId() {
        return studentsId;
    }

    public void setStudentsId(List<StudentJPA> studentsId) {
        this.studentsId = studentsId;
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
