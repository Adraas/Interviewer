package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.repository.util.EntityInstanceType;

import javax.persistence.Query;
import java.util.Collection;

/**
 * The class {@code H2QuestionnaireDao} represents a special case for the {@code H2Dao} using for a special needs for
 * the {@code QuestionnaireGroup} entities.
 *
 * @author Orin Adraas
 * @see H2Dao
 */
public class H2QuestionnaireGroupDao extends H2Dao<QuestionnaireGroup, Long> {

    /**
     * Initializes a newly created {@code H2QuestionnaireGroupDao} object with the given parameters.
     *
     * @param instanceClass      {@link H2Dao#instanceClass}
     * @param session            {@link H2Dao#session}
     * @param entityInstanceType {@link H2Dao#entityInstanceType}
     */
    public H2QuestionnaireGroupDao(Class<QuestionnaireGroup> instanceClass, Session session,
                                   EntityInstanceType entityInstanceType) {
        super(instanceClass, session, entityInstanceType);
    }

    /**
     * The method for the getting {@code QuestionnaireGroup} objects collection by the given author's
     * (existed {@code User} object) index from a repository.
     *
     * @param index the given author's (existed {@code User} object) index
     * @return the searched objects collection as the {@code Collection} type
     */
    @SuppressWarnings(value = {"unchecked"})
    public Collection<QuestionnaireGroup> getQuestionnaireGroupsByAuthorId(Long index) {
        Query query = getSession().createQuery("SELECT * FROM ".concat(getEntityInstanceType().getEntityName())
                .concat(" WHERE author_id = :index"));
        query.setParameter("index", index);
        return query.getResultList();
    }
}
