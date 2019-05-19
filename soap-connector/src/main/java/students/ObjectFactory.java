
package students;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the students package.
 * <p>An ObjectFactory allows you to programatically
 * construct new instances of the Java representation
 * for XML content. The Java representation of XML
 * content can consist of schema derived interfaces
 * and classes representing the binding of schema
 * type definitions, element declarations and model
 * groups.  Factory methods for each of these are
 * provided in this class.
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetAvatar_QNAME = new QName("http://students/", "getAvatar");
    private final static QName _GetAvatarResponse_QNAME = new QName("http://students/", "getAvatarResponse");
    private final static QName _ModStudent_QNAME = new QName("http://students/", "modStudent");
    private final static QName _ModStudentResponse_QNAME = new QName("http://students/", "modStudentResponse");
    private final static QName _PutStudent_QNAME = new QName("http://students/", "putStudent");
    private final static QName _PutStudentResponse_QNAME = new QName("http://students/", "putStudentResponse");
    private final static QName _SetAvatar_QNAME = new QName("http://students/", "setAvatar");
    private final static QName _SetAvatarResponse_QNAME = new QName("http://students/", "setAvatarResponse");
    private final static QName _StudentsByHeight_QNAME = new QName("http://students/", "studentsByHeight");
    private final static QName _StudentsByHeightResponse_QNAME = new QName("http://students/", "studentsByHeightResponse");
    private final static QName _StudentsByName_QNAME = new QName("http://students/", "studentsByName");
    private final static QName _StudentsByNameResponse_QNAME = new QName("http://students/", "studentsByNameResponse");
    private final static QName _StudentsBySubjects_QNAME = new QName("http://students/", "studentsBySubjects");
    private final static QName _StudentsBySubjectsResponse_QNAME = new QName("http://students/", "studentsBySubjectsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: students
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Student }
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link GetAvatar }
     */
    public GetAvatar createGetAvatar() {
        return new GetAvatar();
    }

    /**
     * Create an instance of {@link GetAvatarResponse }
     */
    public GetAvatarResponse createGetAvatarResponse() {
        return new GetAvatarResponse();
    }

    /**
     * Create an instance of {@link ModStudent }
     */
    public ModStudent createModStudent() {
        return new ModStudent();
    }

    /**
     * Create an instance of {@link ModStudentResponse }
     */
    public ModStudentResponse createModStudentResponse() {
        return new ModStudentResponse();
    }

    /**
     * Create an instance of {@link PutStudent }
     */
    public PutStudent createPutStudent() {
        return new PutStudent();
    }

    /**
     * Create an instance of {@link PutStudentResponse }
     */
    public PutStudentResponse createPutStudentResponse() {
        return new PutStudentResponse();
    }

    /**
     * Create an instance of {@link SetAvatar }
     */
    public SetAvatar createSetAvatar() {
        return new SetAvatar();
    }

    /**
     * Create an instance of {@link SetAvatarResponse }
     */
    public SetAvatarResponse createSetAvatarResponse() {
        return new SetAvatarResponse();
    }

    /**
     * Create an instance of {@link StudentsByHeight }
     */
    public StudentsByHeight createStudentsByHeight() {
        return new StudentsByHeight();
    }

    /**
     * Create an instance of {@link StudentsByHeightResponse }
     */
    public StudentsByHeightResponse createStudentsByHeightResponse() {
        return new StudentsByHeightResponse();
    }

    /**
     * Create an instance of {@link StudentsByName }
     */
    public StudentsByName createStudentsByName() {
        return new StudentsByName();
    }

    /**
     * Create an instance of {@link StudentsByNameResponse }
     */
    public StudentsByNameResponse createStudentsByNameResponse() {
        return new StudentsByNameResponse();
    }

    /**
     * Create an instance of {@link StudentsBySubjects }
     */
    public StudentsBySubjects createStudentsBySubjects() {
        return new StudentsBySubjects();
    }

    /**
     * Create an instance of {@link StudentsBySubjectsResponse }
     */
    public StudentsBySubjectsResponse createStudentsBySubjectsResponse() {
        return new StudentsBySubjectsResponse();
    }

    /**
     * Create an instance of {@link Subject }
     */
    public Subject createSubject() {
        return new Subject();
    }

    /**
     * Create an instance of {@link Student.Subjects }
     */
    public Student.Subjects createStudentSubjects() {
        return new Student.Subjects();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvatar }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link GetAvatar }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "getAvatar")
    public JAXBElement<GetAvatar> createGetAvatar(GetAvatar value) {
        return new JAXBElement<GetAvatar>(_GetAvatar_QNAME, GetAvatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvatarResponse }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link GetAvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "getAvatarResponse")
    public JAXBElement<GetAvatarResponse> createGetAvatarResponse(GetAvatarResponse value) {
        return new JAXBElement<GetAvatarResponse>(_GetAvatarResponse_QNAME, GetAvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModStudent }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link ModStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "modStudent")
    public JAXBElement<ModStudent> createModStudent(ModStudent value) {
        return new JAXBElement<ModStudent>(_ModStudent_QNAME, ModStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ModStudentResponse }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link ModStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "modStudentResponse")
    public JAXBElement<ModStudentResponse> createModStudentResponse(ModStudentResponse value) {
        return new JAXBElement<ModStudentResponse>(_ModStudentResponse_QNAME, ModStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutStudent }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link PutStudent }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "putStudent")
    public JAXBElement<PutStudent> createPutStudent(PutStudent value) {
        return new JAXBElement<PutStudent>(_PutStudent_QNAME, PutStudent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PutStudentResponse }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link PutStudentResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "putStudentResponse")
    public JAXBElement<PutStudentResponse> createPutStudentResponse(PutStudentResponse value) {
        return new JAXBElement<PutStudentResponse>(_PutStudentResponse_QNAME, PutStudentResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAvatar }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link SetAvatar }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "setAvatar")
    public JAXBElement<SetAvatar> createSetAvatar(SetAvatar value) {
        return new JAXBElement<SetAvatar>(_SetAvatar_QNAME, SetAvatar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetAvatarResponse }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link SetAvatarResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "setAvatarResponse")
    public JAXBElement<SetAvatarResponse> createSetAvatarResponse(SetAvatarResponse value) {
        return new JAXBElement<SetAvatarResponse>(_SetAvatarResponse_QNAME, SetAvatarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentsByHeight }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link StudentsByHeight }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "studentsByHeight")
    public JAXBElement<StudentsByHeight> createStudentsByHeight(StudentsByHeight value) {
        return new JAXBElement<StudentsByHeight>(_StudentsByHeight_QNAME, StudentsByHeight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentsByHeightResponse }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link StudentsByHeightResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "studentsByHeightResponse")
    public JAXBElement<StudentsByHeightResponse> createStudentsByHeightResponse(StudentsByHeightResponse value) {
        return new JAXBElement<StudentsByHeightResponse>(_StudentsByHeightResponse_QNAME, StudentsByHeightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentsByName }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link StudentsByName }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "studentsByName")
    public JAXBElement<StudentsByName> createStudentsByName(StudentsByName value) {
        return new JAXBElement<StudentsByName>(_StudentsByName_QNAME, StudentsByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentsByNameResponse }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link StudentsByNameResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "studentsByNameResponse")
    public JAXBElement<StudentsByNameResponse> createStudentsByNameResponse(StudentsByNameResponse value) {
        return new JAXBElement<StudentsByNameResponse>(_StudentsByNameResponse_QNAME, StudentsByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentsBySubjects }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link StudentsBySubjects }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "studentsBySubjects")
    public JAXBElement<StudentsBySubjects> createStudentsBySubjects(StudentsBySubjects value) {
        return new JAXBElement<StudentsBySubjects>(_StudentsBySubjects_QNAME, StudentsBySubjects.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StudentsBySubjectsResponse }{@code >}
     *
     * @param value Java instance representing xml element's value.
     * @return the new instance of {@link JAXBElement }{@code <}{@link StudentsBySubjectsResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://students/", name = "studentsBySubjectsResponse")
    public JAXBElement<StudentsBySubjectsResponse> createStudentsBySubjectsResponse(StudentsBySubjectsResponse value) {
        return new JAXBElement<StudentsBySubjectsResponse>(_StudentsBySubjectsResponse_QNAME, StudentsBySubjectsResponse.class, null, value);
    }

}
