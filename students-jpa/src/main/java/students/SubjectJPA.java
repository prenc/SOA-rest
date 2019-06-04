package students;

import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "t_subjects")
public class SubjectJPA implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "students_to_subjects", joinColumns = @JoinColumn(name = "t_subjects_id"),
            inverseJoinColumns = @JoinColumn(name = "t_students_id"))
    private Set<StudentJPA> studentId = new HashSet<>();

    public SubjectJPA() {
    }

    public Set<StudentJPA> getStudentId() {
        return studentId;
    }

    public void setStudentId(Set<StudentJPA> studentId) {
        this.studentId = studentId;
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
