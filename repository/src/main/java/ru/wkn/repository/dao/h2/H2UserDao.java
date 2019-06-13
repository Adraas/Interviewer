package ru.wkn.repository.dao.h2;

import lombok.extern.java.Log;
import org.hibernate.Session;
import ru.wkn.entities.user.User;
import ru.wkn.repository.dao.EntityInstanceType;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * The class {@code H2UserDao} represents a special case for the {@code H2Dao} using for a special needs for
 * the {@code User} entities.
 *
 * @author Orin Adraas
 * @see H2Dao
 */
@Log
public class H2UserDao extends H2Dao<User, Long> {

    /**
     * Initializes a newly created {@code H2UserDao} object with the given parameters.
     *
     * @param instanceClass      {@link H2Dao#instanceClass}
     * @param session            {@link H2Dao#session}
     * @param entityInstanceType {@link H2Dao#entityInstanceType}
     */
    public H2UserDao(Class<User> instanceClass, Session session, EntityInstanceType entityInstanceType) {
        super(instanceClass, session, entityInstanceType);
    }

    /**
     * The method for the getting {@code User} object by the given email and password (log-in process, for example)
     * from a repository.
     *
     * @param email    the given email for the searching
     * @param password the given password for the searching
     * @return the searched object, casted to the {@code User} type
     * @throws ru.wkn.exceptions.PersistenceException thrown if some problems with cortege searching
     */
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

    /**
     * The method for the checking to existence for the given cookie value.
     *
     * @param cookie the given cookie value as the {@code String} for the checking
     * @return {@code true} if the given cookie value is exists in a repository, else - {@code false}
     */
    public boolean isCookieExists(String cookie) {
        Query query = getSession().createQuery("SELECT cookie FROM ".concat(getEntityInstanceType().getEntityName()
                .concat(" WHERE cookie = :cookie")));
        query.setParameter("cookie", cookie);
        return query.getResultList().size() != 0;
    }
}
