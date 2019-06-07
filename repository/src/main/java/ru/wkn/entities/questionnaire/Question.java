package ru.wkn.entities.questionnaire;

import java.util.Set;

/**
 * The class {@code Question} represents single questionnaire's question with preset answers.
 *
 * @author Orin Adraas
 */
public class Question {

    /**
     * The question wording.
     */
    private String question;

    /**
     * The question preset answers.
     */
    private Set<String> answers;
}
