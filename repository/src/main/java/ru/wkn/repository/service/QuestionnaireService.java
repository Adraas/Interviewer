package ru.wkn.repository.service;

import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.dao.h2.H2QuestionnaireDao;

import java.util.Collection;

public class QuestionnaireService extends Service<Questionnaire, Long> {

    public QuestionnaireService(IDao<Questionnaire, Long> dao) {
        super(dao);
    }

    public Collection<Questionnaire> getQuestionnaireByAuthorId(Long index) {
        return ((H2QuestionnaireDao) getDao()).getQuestionnaireByAuthorId(index);
    }
}
