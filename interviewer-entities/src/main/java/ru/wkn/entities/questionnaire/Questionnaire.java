package ru.wkn.entities.questionnaire;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.Set;

/**
 * The class {@code Questionnaire} represents a questionnaire with a preset questions.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Questionnaire {

    /**
     * The unique ID of a questionnaire.
     */
    private long id;

    /**
     * The ID of a questionnaire author.
     */
    private long authorId;

    /**
     * The title of a questionnaire.
     */
    private String title;

    /**
     * The preset questions of a questionnaire.
     */
    private Set<Question> questions;

    /**
     * The preset analytical information containing grade criteria {@code String} values and appropriate them
     * {@code AnalyticalInformation} objects.
     */
    private Map<String, Set<AnalyticalInformation<Integer>>> analyticalInformation;

    /**
     * Initializes a newly created {@code Questionnaire} object with the given parameter assignments to the fields of
     * an {@code Questionnaire} object.
     *
     * @param authorId              {@link #authorId}
     * @param title                 {@link #title}
     * @param questions             {@link #questions}
     * @param analyticalInformation {@link #analyticalInformation}
     */
    public Questionnaire(long authorId, String title, Set<Question> questions,
                         Map<String, Set<AnalyticalInformation<Integer>>> analyticalInformation) {
        this.authorId = authorId;
        this.title = title;
        this.questions = questions;
        this.analyticalInformation = analyticalInformation;
    }
}
