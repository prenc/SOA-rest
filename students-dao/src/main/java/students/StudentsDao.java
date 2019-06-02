package students;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class StudentsDao extends Dao {

    @SuppressWarnings("unchecked")
    @Override
    protected Class<StudentJPA> getType() {
        return StudentJPA.class;
    }

    public void add(Student student) {
        StudentJPA.Mapper sm = new StudentJPA.Mapper();

        StudentJPA sJPA = sm.DTOtoEntity(student);

        this.create(sJPA);

        student.setId(sJPA.getId());
    }

    public boolean update(Integer id, Student student) {
        StudentJPA.Mapper sm = new StudentJPA.Mapper();

        StudentJPA sJPA = sm.DTOtoEntity(student);

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

        StudentJPA.Mapper sm = new StudentJPA.Mapper();

        return sm.EntitytoDTO(results);
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

        StudentJPA.Mapper sm = new StudentJPA.Mapper();

        return sm.EntitytoDTO(results);
    }

    public Student getOne(Integer id) {
        StudentJPA.Mapper sm = new StudentJPA.Mapper();

        StudentJPA studentJPA = this.entityManager.find(StudentJPA.class, id);

        return sm.EntitytoDTO(studentJPA);
    }

}
