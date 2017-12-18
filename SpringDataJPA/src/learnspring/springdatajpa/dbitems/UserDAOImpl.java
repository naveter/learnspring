package learnspring.springdatajpa.dbitems;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class UserDAOImpl {

    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager em;

//    public void setSessionFactory(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }

    @Transactional
    public User save(User p) {

//        sessionFactory.getCurrentSession().save(p);
//        return p;

        if (p.getId() == null) {
            em.persist(p);
            return p;
        } else {
            return em.merge(p);
        }
    }



//    @SuppressWarnings("unchecked")
//    @Override
//    public List<User> list() {
//        Session session = this.sessionFactory.openSession();
//        List<User> personList = session.createQuery("from User").list();
//        session.close();
//        return personList;
//    }
//
//    @Override
//    public User getById(int id){
//        Session session = this.sessionFactory.openSession();
//        User user = (User)session.load(User.class, (long)id);
//        Hibernate.initialize(user);
//        session.close();
//
//        return user;
//    }
}
