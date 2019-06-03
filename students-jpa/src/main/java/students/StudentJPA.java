package students;


import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "t_students")
public class StudentJPA {
    @Id
    @GeneratedValue
    private Integer id;

    private String name;
    private Integer height;

    @Lob
    private String avatar;

    @ManyToOne(targetEntity = ClassJPA.class)
    @JoinColumn(name = "classID")
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

    static public class Mapper {

        public StudentJPA DTOtoEntity(Student student) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(student, StudentJPA.class);
        }

        public Student EntityToDTO(StudentJPA studentJPA) {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(studentJPA, Student.class);
        }

        public List<Student> EntityToDTO(List<StudentJPA> sj) {
            ModelMapper modelMapper = new ModelMapper();
            return sj.stream().map(s -> modelMapper.map(s, Student.class)).collect(Collectors.toList());
        }

        public List<StudentJPA> DTOtoEntity(List<Student> s) {
            ModelMapper modelMapper = new ModelMapper();
            return s.stream().map(st -> modelMapper.map(st, StudentJPA.class)).collect(Collectors.toList());
        }
    }
}
