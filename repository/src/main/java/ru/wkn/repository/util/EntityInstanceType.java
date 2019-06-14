package ru.wkn.repository.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

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
    USER("user"),

    /**
     * The {@code Questionnaire} entity.
     */
    QUESTIONNAIRE("questionnaire"),

    /**
     * The {@code QuestionnaireGroup} entity.
     */
    QUESTIONNAIRE_GROUP("questionnaire_group"),

    /**
     * The {@code Report} entity.
     */
    REPORT("report");

    /**
     * The entity name as a {@code String} value.
     */
    private String entityName;
}
