package learnspring.springdatajpa.dao;

import learnspring.springdatajpa.dbitems.Post;
import learnspring.springdatajpa.dbitems.Source;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class SourceDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Source save(Source p) {
        if (p.getId() == null) {
            em.persist(p);
            return p;
        } else {
            return em.merge(p);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Source> getAll(int start, int limit) {
        Query tmp = em.createQuery("SELECT u FROM Source u ORDER BY u.created DESC", Source.class);
        tmp.setFirstResult(start);
        tmp.setMaxResults(limit);

        return tmp.getResultList();
    }

    public Source findById(int id){
        Source post = em.find(Source.class, (long) id);
        return post;
    }

    @SuppressWarnings("unchecked")
    public List<Source> findByUserId(int user_id, int start, int limit) {
        TypedQuery tmp = em.createQuery("SELECT p FROM Source p where p.user_id = ?1 ORDER BY p.created DESC", Source.class);
        tmp.setParameter(1, (long) user_id);
        tmp.setFirstResult(start);
        tmp.setMaxResults(limit);

        return tmp.getResultList();
    }


}
