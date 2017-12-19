package learnspring.myblog.dao;

import learnspring.myblog.dbitems.Category;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class CategoryDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Category save(Category p) {
        if (p.getId() == null) {
            em.persist(p);
            return p;
        } else {
            return em.merge(p);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Category> getAll(int start, int limit) {
        Query tmp = em.createQuery("SELECT u FROM Category u ORDER BY u.id", Category.class);
        tmp.setFirstResult(start);
        tmp.setMaxResults(limit);

        return tmp.getResultList();
    }

    public Category findById(int id){
        Category user = em.find(Category.class, (long) id);
        return user;
    }


}
