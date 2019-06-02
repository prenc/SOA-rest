package students;

import javax.persistence.*;

@Entity
@Table(name = "t_tutors")
public class TutorJPA {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    @OneToOne
    @JoinColumn(name = "t_classes_id",
            referencedColumnName = "id")
    private ClassJPA group;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClassJPA getGroup() {
        return group;
    }

    public void setGroup(ClassJPA group) {
        this.group = group;
    }
}
