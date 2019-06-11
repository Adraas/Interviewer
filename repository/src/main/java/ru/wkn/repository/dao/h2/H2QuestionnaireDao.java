package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.repository.dao.EntityInstanceType;

public class H2QuestionnaireDao extends H2Dao<Questionnaire, Long> {

    public H2QuestionnaireDao(Class<Questionnaire> instanceClass, Session session,
                              EntityInstanceType entityInstanceType) {
        super(instanceClass, session, entityInstanceType);
    }
}
