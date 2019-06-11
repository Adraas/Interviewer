package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.repository.dao.EntityInstanceType;

/**
 * The class {@code H2QuestionnaireDao} represents a special case for the using {@code H2Dao} for a special needs for
 * the {@code QuestionnaireGroup} entities.
 *
 * @author Orin Adraas
 */
public class H2QuestionnaireGroupDao extends H2Dao<H2QuestionnaireDao, Long> {

    /**
     * Initializes a newly created {@code H2QuestionnaireGroupDao} object with given parameters.
     *
     * @param instanceClass {@link H2Dao#instanceClass}
     * @param session {@link H2Dao#session}
     * @param entityInstanceType {@link H2Dao#entityInstanceType}
     */
    public H2QuestionnaireGroupDao(Class<H2QuestionnaireDao> instanceClass, Session session,
                                   EntityInstanceType entityInstanceType) {
        super(instanceClass, session, entityInstanceType);
    }
}
