package students;

import org.jboss.annotation.security.SecurityDomain;
import org.jboss.ws.api.annotation.WebContext;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;


@Stateless
@WebService
@SecurityDomain("mySchool")
@DeclareRoles({"admins", "teachers"})
@WebContext(authMethod = "BASIC", transportGuarantee = "NONE")
public class SchoolService {

    private HashMap<String, Student> school = new HashMap<>();

    public SchoolService() {
        school.put("jas", new Student("jas", 185, new ArrayList<>(Collections.singletonList(new Subject("PE")))));
        school.put("malgosia", new Student("malgosia", 166, new ArrayList<>(Collections.singletonList(new Subject("Religion")))));
        school.put("jaga", new Student("jaga", 175, new ArrayList<>(Arrays.asList(new Subject("Math"), new Subject("Religion")))));
    }

    @WebMethod(action = "addStudent")
    @WebResult(name = "success")
    @RolesAllowed("teacher")
    public boolean putStudent(
            @WebParam(name = "studentName")
            @XmlElement(required = true)
                    String name,
            @WebParam(name = "studentHeight")
            @XmlElement(required = true)
                    int height) {
        school.put(name, new Student(name, height, new ArrayList<>()));
        return true;
    }

    @WebMethod(action = "editStudent")
    @WebResult(name = "success")
    @RolesAllowed({"admin"})
    public boolean modStudent(
            @WebParam(name = "studentName")
            @XmlElement(required = true)
                    String name,
            @WebParam(name = "studentHeight")
            @XmlElement(required = true)
                    int height,
            @WebParam(name = "studentHeight")
            @XmlElement(required = true)
                    ArrayList<Subject> subjects
    ) {
        if (school.containsKey(name)) {
            school.put(name, new Student(name, height, subjects));
            return true;
        }

        return false;
    }

    @WebMethod(action = "filterByName")
    @WebResult(name = "students")
    @PermitAll
    public ArrayList<Student> studentsByName() {
        ArrayList<Student> list = new ArrayList<Student>(school.values());
        list.sort(new Student.byName());
        return list;
    }

    @WebMethod(action = "filterByHeight")
    @WebResult(name = "students")
    @PermitAll
    public ArrayList<Student> studentsByHeight() {
        ArrayList<Student> list = new ArrayList<Student>(school.values());
        list.sort(new Student.byHeight());
        return list;
    }

    @WebMethod(action = "filterByAmountOfSubjects")
    @WebResult(name = "students")
    @PermitAll
    public ArrayList<Student> studentsBySubjects() {
        ArrayList<Student> list = new ArrayList<Student>(school.values());
        list.sort(new Student.bySubjects());
        return list;
    }

    @WebMethod(action = "getStudentAvatar")
    @WebResult(name = "imageString")
    @PermitAll
    public String getAvatar(
            @WebParam(name = "studentName")
            @XmlElement(required = true)
                    String name) {

        return school.get(name).getAvatar();
    }

    @WebMethod(action = "getStudentAvatar")
    @WebResult(name = "saveImg")
    @PermitAll
    public boolean setAvatar(
            @WebParam(name = "studentName")
            @XmlElement(required = true)
                    String name,
            @WebParam(name = "avatar")
            @XmlElement(required = true)
                    String avatar
    ) {

        school.get(name).setAvatar(avatar);
        return true;
    }

}
