package students;

import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

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

    public static class Mapper {

        private static ModelMapper modelMapper = new ModelMapper();

        public static ClassJPA DTOtoEntity(MClass mClass) {
            return modelMapper.map(mClass, ClassJPA.class);
        }

        public static MClass EntityToDTO(ClassJPA subjectJPA) {
            return modelMapper.map(subjectJPA, MClass.class);
        }

        public static List<MClass> EntityToDTO(List<ClassJPA> sj) {
            return sj.stream().map(s -> modelMapper.map(s, MClass.class)).collect(Collectors.toList());
        }

        public static List<ClassJPA> DTOtoEntity(List<MClass> s) {
            return s.stream().map(st -> modelMapper.map(st, ClassJPA.class)).collect(Collectors.toList());
        }
    }

}
