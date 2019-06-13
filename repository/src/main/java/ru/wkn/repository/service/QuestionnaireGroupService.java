package ru.wkn.repository.service;

import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.dao.h2.H2QuestionnaireGroupDao;

import java.util.Collection;

public class QuestionnaireGroupService extends Service<QuestionnaireGroup, Long> {

    public QuestionnaireGroupService(IDao<QuestionnaireGroup, Long> dao) {
        super(dao);
    }

    public Collection<QuestionnaireGroup> getQuestionnaireGroupByAuthorId(Long index) {
        return ((H2QuestionnaireGroupDao) getDao()).getQuestionnaireGroupByAuthorId(index);
    }
}
