package ru.wkn.entities.questionnaire;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * The class {@code Answer} represents single answer for questionnaire's question.
 *
 * @author Orin Adraas
 */
@Entity(name = "answer")
@Table(name = "answer",
        uniqueConstraints = {@UniqueConstraint(name = "unique_answer", columnNames = {"question_id, answer_wording"})})
public class Answer {

    /**
     * The unique ID of answer.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;

    /**
     * The ID of question, to whom answer belongs.
     */
    @Column(name = "question_id", nullable = false)
    private long questionId;

    /**
     * The answer wording.
     */
    @Column(name = "answer", nullable = false, length = 300)
    private String answerWording;
}
