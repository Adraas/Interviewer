package ru.wkn.repository.service;

import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.dao.h2.H2QuestionnaireDao;

import java.util.Collection;

/**
 * The class {@code QuestionnaireService} represents a special case for the {@code Service} using for a special needs
 * for the {@code Questionnaire} entities.
 *
 * @author Orin Adraas
 * @see Service
 */
public class QuestionnaireService extends Service<Questionnaire, Long> {

    /**
     * Initializes a newly created {@code QuestionnaireService} object with the given DAO implementation.
     *
     * @param dao the {@code IDao} object represents a DAO layout implementation
     */
    public QuestionnaireService(IDao<Questionnaire, Long> dao) {
        super(dao);
    }

    /**
     * The method for the getting {@code Questionnaire} objects collection by the given author's
     * (existed {@code User} object) index from a repository.
     *
     * @param index the given author's (existed {@code User} object) index
     * @return the searched objects collection as the {@code Collection} type
     */
    public Collection<Questionnaire> getQuestionnairesByAuthorId(Long index) {
        return ((H2QuestionnaireDao) getDao()).getQuestionnairesByAuthorId(index);
    }
}
