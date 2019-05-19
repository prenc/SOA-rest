package students;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

@Singleton
public class School extends HashMap<Integer, Student> {

    @PostConstruct
    public void init() {
        enroll(new Student("Jasiek", 185, new ArrayList<>(Collections.singletonList(new Subject("PE")))));
        enroll(new Student("Malgoska", 166, new ArrayList<>(Collections.singletonList(new Subject("Religion")))));
        enroll(new Student("Baba Jaga", 175, new ArrayList<>(Arrays.asList(new Subject("Math"), new Subject("Religion")))));
    }

    public void enroll(Student s) {
        put(size() + 1, s);
    }
}