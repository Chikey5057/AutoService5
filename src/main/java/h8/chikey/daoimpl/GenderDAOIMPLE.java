package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class GenderDAOIMPLE implements DAO<Gender, Integer > {

     SessionFactory factory;

    public GenderDAOIMPLE(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public void create(Gender gender) {
        try(Session session= factory.openSession()){
            session.beginTransaction();
            session.save(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(Gender gender) {
        try(Session session= factory.openSession()){
            session.beginTransaction();
            session.delete(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Gender gender) {
        try(Session session= factory.openSession()){
            session.beginTransaction();
            session.update(gender);
            session.getTransaction().commit();
        }
    }

    @Override
    public Gender read(Integer integer) {
        try(Session session = factory.openSession()) {
            return session.get(Gender.class , integer);
        }
    }

    @Override
    public List<Gender> readAll() {
        try(Session session = factory.openSession()){
            Query<Gender> query = session.createQuery("FROM Gender");
            return query.list();
        }
    }
}















