package students;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "t_students")
public class JPAStudentMapper implements Serializable {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private String surname;

    private String avatar;

}
