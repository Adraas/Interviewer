package ru.wkn.entities.questionnaire;

/**
 * The class {@code Answer} represents single answer for questionnaire's question.
 *
 * @author Orin Adraas
 */
public class Answer {

    /**
     * The unique ID of answer.
     */
    private long id;

    /**
     * The ID of question, to whom answer belongs.
     */
    private long questionId;

    /**
     * The answer wording.
     */
    private String answerWording;
}
