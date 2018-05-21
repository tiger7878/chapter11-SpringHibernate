package spittr.db.hibernate4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spittr.db.SpitterRepository;
import spittr.domain.Spitter;

import javax.inject.Inject;
import java.util.List;

/**
 * User: monkey
 * Date: 2018-05-21 20:22
 */
@Repository
public class HibernateSpitterRepository implements SpitterRepository {

    private SessionFactory sessionFactory;

    @Inject
    public HibernateSpitterRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    //从sessionFactory中获取当前session
    private Session currentSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public long count() {
        return findAll().size();
    }

    @Override
    public Spitter save(Spitter spitter) {
        return null;
    }

    @Override
    public Spitter findOne(long id) {
        return null;
    }

    @Override
    public Spitter findByUsername(String username) {
        return null;
    }

    @Override
    public List<Spitter> findAll() {
        Session session=currentSession();
        return (List<Spitter>) currentSession().createCriteria(Spitter.class).list();
    }
}
