package students;

import java.util.ArrayList;
import java.util.Comparator;


public class Student {

    private String name;

    private int height;

    private String avatar;

    private ArrayList<Subject> subjects;

    private MClass mClass;

    public Student() {
    }

    public Student(String name, int height) {
        this.name = name;
        this.height = height;
    }

    public Student(String name, int height, ArrayList<Subject> subjects) {
        this.name = name;
        this.height = height;
        this.subjects = subjects;
    }

    public Student(String name, int height, ArrayList<Subject> subjects, MClass mClass) {
        this.name = name;
        this.height = height;
        this.subjects = subjects;
        this.mClass = mClass;
    }

    String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "Student(" + getName() + ", " + getHeight() + ")";
    }

    public String getName() {
        return name;
    }

    public MClass getmClass() {
        return mClass;
    }

    public void setmClass(MClass mClass) {
        this.mClass = mClass;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public void setName(String name) {
        this.name = name;
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
