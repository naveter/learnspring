package learnspring.myblog.dao;

import learnspring.myblog.dbitems.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public User save(User p) {
        if (p.getId() == null) {
            em.persist(p);
            return p;
        } else {
            return em.merge(p);
        }
    }

    @SuppressWarnings("unchecked")
    public List<User> getAll(int start, int limit) {
        Query tmp = em.createQuery("SELECT u FROM User u ORDER BY u.id", User.class);
        tmp.setFirstResult(start);
        tmp.setMaxResults(limit);

        return tmp.getResultList();
    }

    public User findById(int id){
        User user = em.find(User.class, (long) id);
        return user;
    }


}
