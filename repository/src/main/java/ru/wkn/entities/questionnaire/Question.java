package ru.wkn.entities.questionnaire;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.Set;

/**
 * The class {@code Question} represents single questionnaire's question wording with preset answers.
 *
 * @author Orin Adraas
 */
@Entity(name = "question")
@Table(name = "question")
public class Question {

    /**
     * The unique ID of question.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;

    /**
     * The question wording.
     */
    @Column(name = "question_wording", unique = true, nullable = false, length = 300)
    private String questionWording;

    /**
     * The question preset answers.
     */
    @ElementCollection(targetClass = Answer.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "answer",
            joinColumns = {@JoinColumn(name = "question_id", referencedColumnName = "answer_wording")})
    private Set<Answer> answers;
}
