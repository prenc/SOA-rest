package students;

import javax.persistence.*;

@Entity
@Table(name = "t_classes")
public class ClassJPA {

    @GeneratedValue
    private Integer id;

    private String name;

    @OneToOne
    private TutorJPA tutor;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TutorJPA getTutor() {
        return tutor;
    }

    public void setTutor(TutorJPA teacher) {
        this.tutor = teacher;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
