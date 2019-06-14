package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.entities.result.Report;
import ru.wkn.repository.util.EntityInstanceType;

import javax.persistence.Query;
import java.util.Collection;

/**
 * The class {@code H2ReportDao} represents a special case for the {@code H2Dao} using for a special needs for
 * the {@code Report} entities.
 *
 * @author Orin Adraas
 * @see H2Dao
 */
public class H2ReportDao extends H2Dao<Report, Long> {

    /**
     * Initializes a newly created {@code H2ReportDao} object with the given parameters.
     *
     * @param instanceClass      {@link H2Dao#instanceClass}
     * @param session            {@link H2Dao#session}
     * @param entityInstanceType {@link H2Dao#entityInstanceType}
     */
    public H2ReportDao(Class<Report> instanceClass, Session session, EntityInstanceType entityInstanceType) {
        super(instanceClass, session, entityInstanceType);
    }

    /**
     * The method for the getting {@code Report} objects collection by the given author's
     * (existed {@code User} object) index from a repository.
     *
     * @param index the given author's (existed {@code User} object) index
     * @return the searched objects collection as the {@code Collection} type
     */
    @SuppressWarnings(value = {"unchecked"})
    public Collection<Report> getReportsByAuthorId(Long index) {
        Query query = getSession().createQuery("SELECT * FROM ".concat(getEntityInstanceType().getEntityName())
                .concat(" WHERE author_id = :index"));
        query.setParameter("index", index);
        return query.getResultList();
    }
}
