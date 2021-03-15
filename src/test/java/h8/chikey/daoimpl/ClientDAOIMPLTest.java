package h8.chikey.daoimpl;

import h8.chikey.model.Client;

import h8.chikey.model.Gender;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.Test;

import java.util.Date;
import java.util.List;

public class ClientDAOIMPLTest {
    SessionFactory factory = new Configuration().configure().buildSessionFactory();
    Client client = new Client();
    Client client2 = new Client();
    Gender gender = new Gender();


    @Test
    public void create() {
        try(Session session= factory.openSession()){
            gender.setCodeGender('м');
            client.setGender(gender);
            client.setFirstName("Moloko");
            client.setLastName("lol");
            client.setPhone("889");
            client.setRegistrationDate(new Date());
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Test
    public void delete() {
        try(Session session= factory.openSession()){
            gender.setCodeGender('м');
            client.setGender(gender);
            client.setFirstName("Moloko");
            client.setLastName("lol");
            client.setPhone("889");
            client.setRegistrationDate(new Date());
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Test
    public void update() {
        try(Session session= factory.openSession()){
            gender.setCodeGender('м');
            client.setGender(gender);
            client.setFirstName("Moloko");
            client.setLastName("lol");
            client.setPhone("889");
            client.setRegistrationDate(new Date());
            session.beginTransaction();
            session.save(client);
            session.getTransaction().commit();
        }
    }

    @Test
    public void read() {
        try(Session session = factory.openSession()) {
            System.out.println(session.get(Client.class, 202).toString());
            System.out.println(session.get(Client.class, 203).toString());
        }
    }

    @Test
    public void readAll() {
        try(Session session = factory.openSession()){
            Query<Client> query = session.createQuery("FROM Client");
            List<Client> list = query.list();
        }
    }
}