package ru.sapteh.Service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import ru.sapteh.Dao.DAO;
import ru.sapteh.Model.Computer;


import java.util.List;

public class ComputerService implements DAO<Computer,Integer> {
    private final SessionFactory factory;


    public ComputerService(SessionFactory factory) {
        this.factory = factory;
    }


    public void create(Computer computer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.save(computer);
            session.getTransaction();
        }

    }


    public Computer read(Integer id) {
        Session session = factory.openSession();
        return session.get(Computer.class, id);
    }


    public List<Computer> readByAll() {
        try(Session session = factory.openSession()) {
            Query<Computer> result = session.createQuery("FROM Computer");
            return result.list();
        }

    }


    public void update(Computer computer) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(computer);
            session.getTransaction().commit();
        }

    }


    public void delete(Computer computer) {
        try(Session session = factory.openSession()){
            session.beginTransaction();
            session.delete(computer);
            session.getTransaction().commit();
        }

    }
}