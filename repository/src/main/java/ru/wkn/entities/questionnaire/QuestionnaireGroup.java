package ru.wkn.entities.questionnaire;

import java.util.Set;

/**
 * The class {@code QuestionnaireGroup} represents questionnaire group.
 *
 * @author Orin Adraas
 */
public class QuestionnaireGroup {

    /**
     * The unique ID of questionnaire group.
     */
    private long id;

    /**
     * The theme of questionnaire group.
     */
    private String theme;

    /**
     * The preset questionnaires of questionnaire group.
     */
    private Set<Questionnaire> questionnaires;

    /**
     * The cookie of questionnaire group author.
     */
    private String authorCookie;
}
