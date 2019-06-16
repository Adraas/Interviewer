package ru.wkn.entities.questionnaire;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * The class {@code QuestionnaireGroup} represents a questionnaire group.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
@Setter
public class QuestionnaireGroup {

    /**
     * The unique ID of a questionnaire group.
     */
    private long id;

    /**
     * The ID of a questionnaire group author.
     */
    private long authorId;

    /**
     * The theme of a questionnaire group.
     */
    private String theme;

    /**
     * The preset questionnaires of a questionnaire group.
     */
    private Set<Questionnaire> questionnaires;

    /**
     * Initializes a newly created {@code QuestionnaireGroup} object with the given parameter assignments to the fields
     * of an {@code QuestionnaireGroup} object.
     *
     * @param authorId       {@link #authorId}
     * @param theme          {@link #theme}
     * @param questionnaires {@link #questionnaires}
     */
    public QuestionnaireGroup(long authorId, String theme, Set<Questionnaire> questionnaires) {
        this.authorId = authorId;
        this.theme = theme;
        this.questionnaires = questionnaires;
    }
}
