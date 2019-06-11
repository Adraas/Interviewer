package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.entities.user.User;
import ru.wkn.repository.dao.EntityInstanceType;

/**
 * The class {@code H2UserDao} represents a special case for the using {@code H2Dao} for a special needs for
 * the {@code User} entities.
 *
 * @author Orin Adraas
 */
public class H2UserDao extends H2Dao<User, Long> {

    /**
     * Initializes a newly created {@code H2UserDao} object with given parameters.
     *
     * @param instanceClass {@link H2Dao#instanceClass}
     * @param session {@link H2Dao#session}
     * @param entityInstanceType {@link H2Dao#entityInstanceType}
     */
    public H2UserDao(Class<User> instanceClass, Session session, EntityInstanceType entityInstanceType) {
        super(instanceClass, session, entityInstanceType);
    }
}
