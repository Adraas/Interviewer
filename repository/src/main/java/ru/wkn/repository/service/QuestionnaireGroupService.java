package ru.wkn.repository.service;

import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.dao.h2.H2QuestionnaireGroupDao;

import java.util.Collection;

/**
 * The class {@code QuestionnaireGroupService} represents a special case for the {@code Service} using for a special
 * needs for the {@code QuestionnaireGroup} entities.
 *
 * @author Orin Adraas
 * @see Service
 */
public class QuestionnaireGroupService extends Service<QuestionnaireGroup, Long> {

    /**
     * Initializes a newly created {@code QuestionnaireGroupService} object with the given DAO implementation.
     *
     * @param dao the {@code IDao} object represents a DAO layout implementation
     */
    public QuestionnaireGroupService(IDao<QuestionnaireGroup, Long> dao) {
        super(dao);
    }

    /**
     * The method for the getting {@code Questionnaire} objects collection by the given author's
     * (existed {@code User} object) index from a repository.
     *
     * @param index the given author's (existed {@code User} object) index
     * @return the searched objects collection as the {@code Collection} type
     */
    public Collection<QuestionnaireGroup> getQuestionnaireGroupByAuthorId(Long index) {
        return ((H2QuestionnaireGroupDao) getDao()).getQuestionnaireGroupByAuthorId(index);
    }
}
