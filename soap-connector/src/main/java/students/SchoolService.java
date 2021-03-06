package students;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.7
 * 2019-04-16T08:38:19.965+02:00
 * Generated source version: 3.2.7
 */
@WebService(targetNamespace = "http://students/", name = "SchoolService")
@XmlSeeAlso({ObjectFactory.class})
public interface SchoolService {

    @WebMethod(action = "addStudent")
    @RequestWrapper(localName = "putStudent", targetNamespace = "http://students/", className = "students.PutStudent")
    @ResponseWrapper(localName = "putStudentResponse", targetNamespace = "http://students/", className = "students.PutStudentResponse")
    @WebResult(name = "success", targetNamespace = "")
    boolean putStudent(
            @WebParam(name = "studentName", targetNamespace = "")
                    java.lang.String studentName,
            @WebParam(name = "studentHeight", targetNamespace = "")
                    int studentHeight
    );

    @WebMethod(action = "filterByHeight")
    @RequestWrapper(localName = "studentsByHeight", targetNamespace = "http://students/", className = "students.StudentsByHeight")
    @ResponseWrapper(localName = "studentsByHeightResponse", targetNamespace = "http://students/", className = "students.StudentsByHeightResponse")
    @WebResult(name = "students", targetNamespace = "")
    java.util.List<students.Student> studentsByHeight();

    @WebMethod(action = "filterByAmountOfSubjects")
    @RequestWrapper(localName = "studentsBySubjects", targetNamespace = "http://students/", className = "students.StudentsBySubjects")
    @ResponseWrapper(localName = "studentsBySubjectsResponse", targetNamespace = "http://students/", className = "students.StudentsBySubjectsResponse")
    @WebResult(name = "students", targetNamespace = "")
    java.util.List<students.Student> studentsBySubjects();

    @WebMethod(action = "filterByName")
    @RequestWrapper(localName = "studentsByName", targetNamespace = "http://students/", className = "students.StudentsByName")
    @ResponseWrapper(localName = "studentsByNameResponse", targetNamespace = "http://students/", className = "students.StudentsByNameResponse")
    @WebResult(name = "students", targetNamespace = "")
    java.util.List<students.Student> studentsByName();

    @WebMethod(action = "getStudentAvatar")
    @RequestWrapper(localName = "getAvatar", targetNamespace = "http://students/", className = "students.GetAvatar")
    @ResponseWrapper(localName = "getAvatarResponse", targetNamespace = "http://students/", className = "students.GetAvatarResponse")
    @WebResult(name = "imageString", targetNamespace = "")
    java.lang.String getAvatar(
            @WebParam(name = "studentName", targetNamespace = "")
                    java.lang.String studentName
    );

    @WebMethod(action = "editStudent")
    @RequestWrapper(localName = "modStudent", targetNamespace = "http://students/", className = "students.ModStudent")
    @ResponseWrapper(localName = "modStudentResponse", targetNamespace = "http://students/", className = "students.ModStudentResponse")
    @WebResult(name = "success", targetNamespace = "")
    boolean modStudent(
            @WebParam(name = "studentName", targetNamespace = "")
                    java.lang.String studentName,
            @WebParam(name = "studentHeight", targetNamespace = "")
                    java.util.List<students.Subject> studentHeight
    );

    @WebMethod(action = "getStudentAvatar")
    @RequestWrapper(localName = "setAvatar", targetNamespace = "http://students/", className = "students.SetAvatar")
    @ResponseWrapper(localName = "setAvatarResponse", targetNamespace = "http://students/", className = "students.SetAvatarResponse")
    @WebResult(name = "saveImg", targetNamespace = "")
    boolean setAvatar(
            @WebParam(name = "studentName", targetNamespace = "")
                    java.lang.String studentName,
            @WebParam(name = "avatar", targetNamespace = "")
                    java.lang.String avatar
    );
}
