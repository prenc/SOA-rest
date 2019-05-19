package students;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.*;

@Singleton
public class School {

    private HashMap<Integer, Student> school;

    @PostConstruct
    public void init() {
        school = new HashMap<>();

        enroll(new Student("Jasiek", 185, new ArrayList<>(Collections.singletonList(new Subject("PE")))));
        enroll(new Student("Malgoska", 166, new ArrayList<>(Collections.singletonList(new Subject("Religion")))));
        enroll(new Student("Baba Jaga", 175, new ArrayList<>(Arrays.asList(new Subject("Math"), new Subject("Religion")))));
    }

    public Student get(int id) {
        return school.get(id);
    }

    public Boolean containsKey(int id) {
        return school.containsKey(id);
    }

    public Student put(int id, Student s) {
        return school.put(id, s);
    }

    public Student remove(int id) {
        return school.remove(id);
    }

    public Collection<Student> values() {
        return school.values();
    }

    public void enroll(Student s) {
        school.put(school.size() + 1, s);
    }
}