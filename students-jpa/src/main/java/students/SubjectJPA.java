package students;

import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "t_subjects")
public class SubjectJPA implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
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

    public static class Mapper {

        private static ModelMapper modelMapper = new ModelMapper();

        public static SubjectJPA DTOtoEntity(Subject subject) {
            return modelMapper.map(subject, SubjectJPA.class);
        }

        public static Subject EntityToDTO(SubjectJPA subjectJPA) {
            return modelMapper.map(subjectJPA, Subject.class);
        }

        public static List<Subject> EntityToDTO(List<SubjectJPA> sj) {
            return sj.stream().map(s -> modelMapper.map(s, Subject.class)).collect(Collectors.toList());
        }

        public static List<SubjectJPA> DTOtoEntity(List<Subject> s) {
            return s.stream().map(st -> modelMapper.map(st, SubjectJPA.class)).collect(Collectors.toList());
        }
    }
}
