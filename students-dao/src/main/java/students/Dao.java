package students;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;
import java.util.Map;
import java.util.Optional;

abstract class Dao {

    @PersistenceContext(unitName = "student-unit")
    EntityManager entityManager;

    <T> void create(T obj) {
        entityManager.persist(obj);
    }

    <T> void update(T obj) {
        entityManager.merge(obj);
    }

    <T> void delete(T obj) {
        entityManager.remove(obj);
    }

    public <T> List<T> list(final int offset, final int limit) {
        final CriteriaQuery<T> criteriaQuery = entityManager.getCriteriaBuilder().createQuery(getType());
        criteriaQuery.from(getType());
        final TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        query.setFirstResult(offset).setMaxResults(limit);
        return query.getResultList();
    }

    public <T> T get(Object pk) {
        return entityManager.find(getType(), pk);
    }

    protected <T> Optional<T> getSingleResult(List<T> resultList) {
        return resultList.isEmpty() ? Optional.empty() : Optional.of(resultList.get(0));
    }

    protected void fillQueryParameters(final Query query, final Map<String, Object> filters) {
        for (final Map.Entry<String, Object> filter : filters.entrySet()) {
            query.setParameter(filter.getKey(), filter.getValue());
        }
    }

    protected <T> T getSingleResult(final TypedQuery<T> query) {
        try {
            return query.getSingleResult();
        } catch (final NoResultException e) {
            return null;
        }
    }
    
    protected abstract <T> Class<T> getType();

}
