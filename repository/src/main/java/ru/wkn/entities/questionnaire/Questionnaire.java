package ru.wkn.entities.questionnaire;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.Set;

/**
 * The class {@code Questionnaire} represents questionnaire with preset questions.
 *
 * @author Orin Adraas
 */
@Entity(name = "questionnaire")
@Table(name = "questionnaire",
        uniqueConstraints = {@UniqueConstraint(name = "questionnaire_unique",
                columnNames = {"author_id", "title", "question"})})
public class Questionnaire {

    /**
     * The unique ID of questionnaire.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;

    /**
     * The ID of questionnaire author.
     */
    @Column(name = "author_id", nullable = false)
    private String authorId;

    /**
     * The title of questionnaire.
     */
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    /**
     * The preset questions of questionnaire.
     */
    @ElementCollection(targetClass = Question.class, fetch = FetchType.EAGER)
    private Set<Question> questions;
}
