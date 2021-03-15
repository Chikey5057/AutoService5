package h8.chikey.daoimpl;

import h8.chikey.dao.DAO;
import h8.chikey.model.ClientService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ClientServiceDAOIMPL implements DAO<ClientService,Integer> {


    public ClientServiceDAOIMPL(SessionFactory factory) {
        this.factory = factory;
    }

    SessionFactory factory;


    @Override
    public void create(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.save(clientService);
            session.getTransaction().commit();
        }
    }

    @Override
    public void delete(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(clientService);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(ClientService clientService) {
        try (Session session = factory.openSession()){
            session.beginTransaction();
            session.update(clientService);
            session.getTransaction().commit();
        }
    }

    @Override
    public ClientService read(Integer integer) {
        try(Session session = factory.openSession()) {
            return session.get(ClientService.class,integer);
        }
    }

    @Override
    public List<ClientService> readAll(){
        try (Session session = factory.openSession()) {
            Query<ClientService> query = session.createQuery("FROM ClientService");
            return query.list();
        }
    }
}
