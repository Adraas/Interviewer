package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.repository.dao.EntityInstanceType;

import javax.persistence.Query;
import java.util.Collection;

/**
 * The class {@code H2QuestionnaireDao} represents a special case for the using {@code H2Dao} for a special needs for
 * the {@code QuestionnaireGroup} entities.
 *
 * @author Orin Adraas
 * @see H2Dao
 */
public class H2QuestionnaireGroupDao extends H2Dao<QuestionnaireGroup, Long> {

    /**
     * Initializes a newly created {@code H2QuestionnaireGroupDao} object with given parameters.
     *
     * @param instanceClass      {@link H2Dao#instanceClass}
     * @param session            {@link H2Dao#session}
     * @param entityInstanceType {@link H2Dao#entityInstanceType}
     */
    public H2QuestionnaireGroupDao(Class<QuestionnaireGroup> instanceClass, Session session,
                                   EntityInstanceType entityInstanceType) {
        super(instanceClass, session, entityInstanceType);
    }

    @SuppressWarnings(value = {"unchecked"})
    public Collection<QuestionnaireGroup> getQuestionnaireGroupByAuthorId(Long index) {
        Query query = getSession().createQuery("SELECT * FROM ".concat(getEntityInstanceType().getEntityName())
                .concat(" WHERE author_id = :index"));
        query.setParameter("index", index);
        return query.getResultList();
    }
}
