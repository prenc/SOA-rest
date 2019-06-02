package students;

import javax.persistence.*;

@Entity
@Table(name = "t_classes")
public class ClassJPA {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    private String name;

    @OneToOne(mappedBy = "group")
    private TutorJPA tutor;

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
