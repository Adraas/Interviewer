package ru.wkn.entities.questionnaire;

import java.util.Set;

/**
 * The class {@code Questionnaire} represents questionnaire with preset questions.
 *
 * @author Orin Adraas
 */
public class Questionnaire {

    /**
     * The unique ID of questionnaire.
     */
    private long id;

    /**
     * The title of questionnaire.
     */
    private String title;

    /**
     * The preset questions of questionnaire.
     */
    private Set<Question> questions;

    /**
     * The cookie for unique indicating questionnaire in the system.
     */
    private String cookie;

    /**
     * The cookie of questionnaire author.
     */
    private String authorCookie;
}
