package Traitement;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static final ThreadLocal<Session> session = new ThreadLocal<>();

    static {
        try {
            sessionFactory = new Configuration().configure("/hibernate.cfg.xml").buildSessionFactory();
        } catch (HibernateException ex) {
            throw new RuntimeException("Problème de configuration : " + ex.getMessage(), ex);
        }
    }

    public static Session currentSession() throws HibernateException {
        Session s = session.get();
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession() throws HibernateException {
        Session s = session.get();
        session.set(null);
        if (s != null) s.close();
    }
}
