package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.entities.user.User;
import ru.wkn.repository.dao.EntityInstanceType;

public class H2UserDao extends H2Dao<User, Long> {

    public H2UserDao(Class<User> instanceClass, Session session, EntityInstanceType entityInstanceType) {
        super(instanceClass, session, entityInstanceType);
    }
}
