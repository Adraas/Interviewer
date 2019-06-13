package ru.wkn.repository.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.entities.user.User;

import javax.persistence.Table;

/**
 * The enum {@code EntityInstanceType} contains values represented entity names for a repository.
 *
 * @author Orin Adraas
 */
@AllArgsConstructor
@Getter
public enum EntityInstanceType {

    /**
     * The {@code User} entity.
     */
    USER(User.class.getAnnotation(Table.class).name()),

    /**
     * The {@code Questionnaire} entity.
     */
    QUESTIONNAIRE(Questionnaire.class.getAnnotation(Table.class).name()),

    /**
     * The {@code QuestionnaireGroup} entity.
     */
    QUESTIONNAIRE_GROUP(QuestionnaireGroup.class.getAnnotation(Table.class).name());

    /**
     * The entity name as a {@code String} value.
     */
    private String entityName;
}
