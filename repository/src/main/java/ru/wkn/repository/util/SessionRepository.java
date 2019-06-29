package ru.wkn.repository.util;

import org.hibernate.Session;
import ru.wkn.repository.jpa.HibernateJPAContextInitializer;

import javax.persistence.EntityManagerFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * The class {@code SessionRepository} represents the {@code Session} objects repository.
 *
 * @author Orin Adraas
 */
public class SessionRepository {

    /**
     * The {@code Map} collection with {@code Session} objects.
     */
    private static Map<String, Session> sessionMap;

    static {
        sessionMap = new HashMap<>();
    }

    /**
     * @see Map#put(Object, Object)
     */
    public static void addSession(String persistenceUnitName) {
        EntityManagerFactory entityManagerFactory = HibernateJPAContextInitializer.getEntityManagerFactory();
        if (entityManagerFactory == null) {
            entityManagerFactory = HibernateJPAContextInitializer.getEntityManagerFactory(persistenceUnitName);
        }
        sessionMap.put(persistenceUnitName, (Session) entityManagerFactory.createEntityManager().getDelegate());
    }

    /**
     * The method for the getting an existed {@code Session} object with an opportunity to create a not existed
     * required object.
     *
     * @see Map#get(Object)
     */
    public static Session getSession(String persistenceUnitName) {
        if (!sessionMap.containsKey(persistenceUnitName)) {
            addSession(persistenceUnitName);
        }
        return sessionMap.get(persistenceUnitName);
    }
}
