package learnspring.springdatajpa.dao;

import learnspring.springdatajpa.dbitems.Category;
import learnspring.springdatajpa.dbitems.Post;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class PostDAO {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public Post save(Post p) {
        if (p.getId() == null) {
            em.persist(p);
            return p;
        } else {
            return em.merge(p);
        }
    }

    @SuppressWarnings("unchecked")
    public List<Post> getAll(int start, int limit) {
        Query tmp = em.createQuery("SELECT u FROM Post u ORDER BY u.created DESC", Post.class);
        tmp.setFirstResult(start);
        tmp.setMaxResults(limit);

        return tmp.getResultList();
    }

    public Post findById(int id){
        Post post = em.find(Post.class, (long) id);
        return post;
    }

    @SuppressWarnings("unchecked")
    public List<Post> findByUserId(int user_id, int start, int limit) {
        TypedQuery tmp = em.createQuery("SELECT p FROM Post p where p.user_id = ?1 ORDER BY p.created DESC", Post.class);
        tmp.setParameter(1, (long) user_id);
        tmp.setFirstResult(start);
        tmp.setMaxResults(limit);

        return tmp.getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Post> findByCategoryId(int category_id, int start, int limit) {
        TypedQuery tmp = em.createQuery("SELECT p FROM Post p where p.category_id = ?1 ORDER BY p.created DESC", Post.class);
        tmp.setParameter(1, (long) category_id);
        tmp.setFirstResult(start);
        tmp.setMaxResults(limit);

        return tmp.getResultList();
    }


}
