package students;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Set;

@Stateless
public class StudentsDao extends Dao {

    @SuppressWarnings("unchecked")
    @Override
    protected Class<StudentJPA> getType() {
        return StudentJPA.class;
    }

    public void add(Student student) {

        StudentJPA sJPA = StudentJPA.Mapper.DTOtoEntity(student);

        List<SubjectJPA> subjects = SubjectJPA.Mapper.DTOtoEntity(student.getSubjects());

        for (SubjectJPA subject : subjects) {
            Set<StudentJPA> s = subject.getStudentId();
            s.add(sJPA);
            subject.setStudentId(s);
            this.create(subject);
        }
        //  create(sJPA);
    }

    public boolean update(Integer id, Student student) {
        StudentJPA sJPA = StudentJPA.Mapper.DTOtoEntity(student);

        if (this.getOne(id) != null) {
            sJPA.setId(id);
            this.update(sJPA);
            return true;
        } else {
            return false;
        }
    }


    public boolean deleteStudent(Integer id) {
        if (this.getOne(id) != null) {
            this.delete(id);
            return true;
        } else {
            return false;
        }
    }

    public List<Student> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentJPA> q = cb.createQuery(StudentJPA.class);
        Root<StudentJPA> c = q.from(StudentJPA.class);
        q.select(c);

        TypedQuery<StudentJPA> query = entityManager.createQuery(q);

        List<StudentJPA> results = query.getResultList();


        return StudentJPA.Mapper.EntityToDTO(results);
    }

    public List<Student> getStudentsBySubject(String subject) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentJPA> q = cb.createQuery(StudentJPA.class);
        Root<StudentJPA> c = q.from(StudentJPA.class);
        ParameterExpression<String> p = cb.parameter(String.class);
        Join<StudentJPA, SubjectJPA> subjects = c.join("subjectID", JoinType.LEFT);

        Predicate predicate = cb.equal(subjects.get("name"), p);

        q.select(c).distinct(true).where(predicate);

        TypedQuery<StudentJPA> query = entityManager.createQuery(q);
        List<StudentJPA> results = query.setParameter(p, subject).getResultList();

        return StudentJPA.Mapper.EntityToDTO(results);
    }

    public List<Student> getAllByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<StudentJPA> q = cb.createQuery(StudentJPA.class);
        Root<StudentJPA> c = q.from(StudentJPA.class);
        ParameterExpression<String> p = cb.parameter(String.class);

        q.select(c).where(cb.equal(c.get("name"), p));

        TypedQuery<StudentJPA> query = entityManager.createQuery(q);
        query.setParameter(p, name);

        List<StudentJPA> results = query.getResultList();


        return StudentJPA.Mapper.EntityToDTO(results);
    }

    public Student getOne(Integer id) {

        StudentJPA studentJPA = this.entityManager.find(StudentJPA.class, id);

        return StudentJPA.Mapper.EntityToDTO(studentJPA);
    }

}
