package ru.wkn.repository.dao;

import org.hibernate.Session;
import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.entities.result.Report;
import ru.wkn.entities.user.User;
import ru.wkn.repository.dao.h2.H2QuestionnaireDao;
import ru.wkn.repository.dao.h2.H2QuestionnaireGroupDao;
import ru.wkn.repository.dao.h2.H2ReportDao;
import ru.wkn.repository.dao.h2.H2UserDao;
import ru.wkn.repository.util.EntityInstanceType;

/**
 * The class {@code DaoFactory} represents the DAO layout factory implementation.
 *
 * @author Orin Adraas
 * @see IDaoFactory
 */
public class DaoFactory implements IDaoFactory {

    /**
     * @see IDaoFactory#createDao(EntityInstanceType, Session)
     */
    @Override
    public IDao createDao(EntityInstanceType entityInstanceType, Session session) {
        return entityInstanceType.equals(EntityInstanceType.USER)
                ? new H2UserDao(User.class, session, entityInstanceType)
                : entityInstanceType.equals(EntityInstanceType.QUESTIONNAIRE)
                ? new H2QuestionnaireDao(Questionnaire.class, session, entityInstanceType)
                : entityInstanceType.equals(EntityInstanceType.QUESTIONNAIRE_GROUP)
                ? new H2QuestionnaireGroupDao(QuestionnaireGroup.class, session, entityInstanceType)
                : entityInstanceType.equals(EntityInstanceType.REPORT)
                ? new H2ReportDao(Report.class, session, entityInstanceType)
                : null;
    }
}
