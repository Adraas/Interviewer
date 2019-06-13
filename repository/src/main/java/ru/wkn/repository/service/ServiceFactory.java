package ru.wkn.repository.service;

import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.entities.user.User;
import ru.wkn.repository.dao.IDao;
import ru.wkn.repository.util.EntityInstanceType;

/**
 * The class {@code ServiceFactory} represents the service layout factory implementation.
 *
 * @author Orin Adraas
 * @see IServiceFactory
 */
public class ServiceFactory implements IServiceFactory {

    /**
     * @see IServiceFactory#createService(EntityInstanceType, IDao)
     */
    @SuppressWarnings(value = {"unchecked"})
    @Override
    public IService createService(EntityInstanceType entityInstanceType, IDao dao) {
        return entityInstanceType.equals(EntityInstanceType.USER)
                ? new UserService((IDao<User, Long>) dao)
                : entityInstanceType.equals(EntityInstanceType.QUESTIONNAIRE)
                ? new QuestionnaireService((IDao<Questionnaire, Long>) dao)
                : entityInstanceType.equals(EntityInstanceType.QUESTIONNAIRE_GROUP)
                ? new QuestionnaireGroupService((IDao<QuestionnaireGroup, Long>) dao)
                : null;
    }
}
