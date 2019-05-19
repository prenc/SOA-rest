package students;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.Comparator;


@XmlType(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {

    private String name;
    private int height;
    private String avatar;
    @XmlElementWrapper
    @XmlElement(name = "subjects")
    private ArrayList<Subject> subjects;

    public Student() {
    }

    Student(String name, int height, ArrayList<Subject> subjects) {
        this.name = name;
        this.height = height;
        this.subjects = subjects;
    }

    String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Student(" + getName() + ", " + getHeight() + ", " + subjects.toString() + ")";
    }

    public String getName() {
        return name;
    }

    int getHeight() {
        return height;
    }

    ArrayList<Subject> getSubjects() {
        return subjects;
    }

    static class byName implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareTo(o2.getName());
        }
    }

    static class byHeight implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getHeight() - o2.getHeight();
        }
    }

    static class bySubjects implements Comparator<Student> {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getSubjects().size() - o2.getSubjects().size();
        }
    }
}
