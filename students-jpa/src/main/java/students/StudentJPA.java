package students;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "t_students")
public class StudentJPA implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private Integer height;

    private String avatar;

    @ManyToOne
    private ClassJPA group;

    public StudentJPA() {
    }

    public StudentJPA(ClassJPA group) {
        this.group = group;
    }

    public ClassJPA getGroup() {
        return group;
    }

    public void setGroup(ClassJPA group) {
        this.group = group;
    }

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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }
}
