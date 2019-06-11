package ru.wkn.repository.dao.h2;

import org.hibernate.Session;
import ru.wkn.repository.dao.EntityInstanceType;

public class H2QuestionnaireGroupDao extends H2Dao<H2QuestionnaireDao, Long> {

    public H2QuestionnaireGroupDao(Class<H2QuestionnaireDao> instanceClass, Session session,
                                   EntityInstanceType entityInstanceType) {
        super(instanceClass, session, entityInstanceType);
    }
}
