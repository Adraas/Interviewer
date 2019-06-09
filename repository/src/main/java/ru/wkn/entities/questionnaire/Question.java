package ru.wkn.entities.questionnaire;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import java.util.Set;

/**
 * The class {@code Question} represents single questionnaire's question wording with preset answers.
 *
 * @author Orin Adraas
 */
@Embeddable
public class Question {

    /**
     * The question wording.
     */
    @Column(name = "question_wording", unique = true, nullable = false, length = 600)
    private String questionWording;

    /**
     * The question preset answers.
     */
    @ElementCollection(targetClass = Answer.class, fetch = FetchType.EAGER)
    private Set<Answer> answers;
}
