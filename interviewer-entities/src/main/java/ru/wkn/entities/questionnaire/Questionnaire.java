package ru.wkn.entities.questionnaire;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * The class {@code Questionnaire} represents questionnaire with preset questions.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
@Setter
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
     * Initializes a newly created {@code Questionnaire} object with the given parameter assignments to the fields of
     * an {@code Questionnaire} object.
     *
     * @param authorId {@link #authorId}
     * @param title {@link #title}
     * @param questions {@link #questions}
     */
    public Questionnaire(long authorId, String title, Set<Question> questions) {
        this.authorId = authorId;
        this.title = title;
        this.questions = questions;
    }
}
