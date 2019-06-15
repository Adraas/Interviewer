package ru.wkn.entities.questionnaire;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.wkn.entities.result.GradeCriteria;

import java.util.Set;

/**
 * The class {@code Questionnaire} represents questionnaire with preset questions.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Questionnaire {

    /**
     * The unique ID of questionnaire.
     */
    private long id;

    /**
     * The ID of questionnaire author.
     */
    private long authorId;

    /**
     * The title of questionnaire.
     */
    private String title;

    /**
     * The preset questions of questionnaire.
     */
    private Set<Question> questions;

    /**
     * The preset accessed {@code GradeCriteria} enum types for a single current questionnaire.
     */
    private Set<GradeCriteria> gradeCriteria;

    /**
     * Initializes a newly created {@code Questionnaire} object with the given parameter assignments to the fields of
     * an {@code Questionnaire} object.
     *
     * @param authorId      {@link #authorId}
     * @param title         {@link #title}
     * @param questions     {@link #questions}
     * @param gradeCriteria {@link #gradeCriteria}
     */
    public Questionnaire(long authorId, String title, Set<Question> questions, Set<GradeCriteria> gradeCriteria) {
        this.authorId = authorId;
        this.title = title;
        this.questions = questions;
        this.gradeCriteria = gradeCriteria;
    }
}
