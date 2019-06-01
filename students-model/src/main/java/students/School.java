package students;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.HashMap;

@Singleton
public class School extends HashMap<Integer, Student> {

    @PostConstruct
    public void init() {

    }

    public void enroll(Student s) {
        put(size() + 1, s);
    }
}