package ru.wkn.repository.util;

import org.hibernate.Session;
import ru.wkn.repository.jpa.HibernateJPAContextInitializer;

import java.util.HashMap;
import java.util.Map;

public class SessionRepository {

    private static Map<String, Session> sessionMap;

    static {
        sessionMap = new HashMap<>();
    }

    public static void addSession(String persistenceUnitName) {
        sessionMap.put(persistenceUnitName,
                (Session) HibernateJPAContextInitializer.getEntityManagerFactory(persistenceUnitName));
    }

    public static Session getSession(String persistenceUnitName) {
        if (!sessionMap.containsKey(persistenceUnitName)) {
            addSession(persistenceUnitName);
        }
        return sessionMap.get(persistenceUnitName);
    }
}
