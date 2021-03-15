package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.Client;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDAOIMPL implements DAO <Client, Integer> {

    SessionFactory factory;

    public ClientDAOIMPL(SessionFactory factory) {
        this.factory=factory;
    }

    @Override
    public void create(Client client) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }
    @Override
    public void delete(Client client) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Client client) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.update(client);
            session.getTransaction().commit();
        }
    }

    @Override
    public Client read(Integer integer) {
        try(Session session = factory.openSession()) {
            return session.get(Client.class,integer);
        }
    }

    @Override
    public List<Client> readAll() {
        try(Session session = factory.openSession()){
            Query<Client> query = session.createQuery("FROM Client");
            return query.list();
        }
    }
}






























