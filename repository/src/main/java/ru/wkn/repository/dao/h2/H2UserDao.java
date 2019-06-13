package ru.wkn.repository.dao.h2;

import lombok.extern.java.Log;
import org.hibernate.Session;
import ru.wkn.entities.user.User;
import ru.wkn.repository.dao.EntityInstanceType;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * The class {@code H2UserDao} represents a special case for the using {@code H2Dao} for a special needs for
 * the {@code User} entities.
 *
 * @author Orin Adraas
 * @see H2Dao
 */
@Log
public class H2UserDao extends H2Dao<User, Long> {

    /**
     * Initializes a newly created {@code H2UserDao} object with given parameters.
     *
     * @param instanceClass      {@link H2Dao#instanceClass}
     * @param session            {@link H2Dao#session}
     * @param entityInstanceType {@link H2Dao#entityInstanceType}
     */
    public H2UserDao(Class<User> instanceClass, Session session, EntityInstanceType entityInstanceType) {
        super(instanceClass, session, entityInstanceType);
    }

    public User getUserByEmailAndPassword(String email, String password) throws ru.wkn.exceptions.PersistenceException {
        Query query = getSession().createQuery("SELECT * FROM ".concat(getEntityInstanceType().getEntityName())
                .concat(" WHERE email = :email AND password = :password"));
        query.setParameter("email", email);
        query.setParameter("password", password);
        try {
            return (User) query.getSingleResult();
        } catch (PersistenceException e) {
            String message = e.getMessage();
            log.warning(message);
            throw new ru.wkn.exceptions.PersistenceException(message, e.getCause());
        }
    }

    public boolean isCookieExists(String cookie) {
        Query query = getSession().createQuery("SELECT cookie FROM ".concat(getEntityInstanceType().getEntityName()
                .concat(" WHERE cookie = :cookie")));
        query.setParameter("cookie", cookie);
        return query.getResultList().size() != 0;
    }
}
