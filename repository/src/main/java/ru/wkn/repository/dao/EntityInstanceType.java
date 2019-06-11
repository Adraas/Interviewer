package ru.wkn.repository.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.entities.user.User;

import javax.persistence.Table;

@AllArgsConstructor
@Getter
public enum EntityInstanceType {

    USER(User.class.getAnnotation(Table.class).name()),
    QUESTIONNAIRE(Questionnaire.class.getAnnotation(Table.class).name()),
    QUESTIONNAIRE_GROUP(QuestionnaireGroup.class.getAnnotation(Table.class).name());

    /**
     * The entity name as a {@code String} value.
     */
    private String entityName;
}
