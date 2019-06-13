package ru.wkn.repository.dao;

import org.hibernate.Session;
import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.entities.user.User;
import ru.wkn.repository.dao.h2.H2QuestionnaireDao;
import ru.wkn.repository.dao.h2.H2QuestionnaireGroupDao;
import ru.wkn.repository.dao.h2.H2UserDao;
import ru.wkn.repository.util.EntityInstanceType;

import java.io.Serializable;

/**
 * The class {@code DaoFactory} represents implementation for the DAO layout factory.
 *
 * @author Orin Adraas
 * @see IDaoFactory
 */
public class DaoFactory<V, I extends Serializable> implements IDaoFactory<V, I> {

    /**
     * @see IDaoFactory#createDao(EntityInstanceType, Session)
     */
    @SuppressWarnings(value = {"unchecked"})
    @Override
    public IDao<V, I> createDao(EntityInstanceType entityInstanceType, Session session) {
        return entityInstanceType.equals(EntityInstanceType.USER)
                ? (IDao<V, I>) new H2UserDao(User.class, session, entityInstanceType)
                : entityInstanceType.equals(EntityInstanceType.QUESTIONNAIRE)
                ? (IDao<V, I>) new H2QuestionnaireDao(Questionnaire.class, session, entityInstanceType)
                : entityInstanceType.equals(EntityInstanceType.QUESTIONNAIRE_GROUP)
                ? (IDao<V, I>) new H2QuestionnaireGroupDao(QuestionnaireGroup.class, session, entityInstanceType)
                : null;
    }
}
