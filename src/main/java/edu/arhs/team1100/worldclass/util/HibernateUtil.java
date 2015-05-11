package edu.arhs.team1100.worldclass.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static String username = "", password = "", address = "";
    private static ServiceRegistry serviceRegistry;

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
            cfg.setProperty("hibernate.connection.username", username);
            cfg.setProperty("hibernate.connection.password", password);
            cfg.setProperty("hibernate.connection.url", "jdbc:mysql://" + address + "/worldclass2014");
            StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
            sb.applySettings(cfg.getProperties());
            StandardServiceRegistry standardServiceRegistry = sb.build();
            return cfg.buildSessionFactory(standardServiceRegistry);
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            sessionFactory = buildSessionFactory();
        }
        return sessionFactory;
    }

    public static void testConnection(String username, String password, String address) {
        HibernateUtil.username = username;
        HibernateUtil.password = password;
        HibernateUtil.address = address;

        Configuration cfg = new Configuration().configure("hibernate.cfg.xml");
        cfg.setProperty("hibernate.connection.username", username);
        cfg.setProperty("hibernate.connection.password", password);
        cfg.setProperty("hibernate.connection.url", "jdbc:mysql://" + address + "/scouting2014");
        StandardServiceRegistryBuilder sb = new StandardServiceRegistryBuilder();
        sb.applySettings(cfg.getProperties());
        StandardServiceRegistry standardServiceRegistry = sb.build();
        cfg.buildSessionFactory(standardServiceRegistry);
    }

}
