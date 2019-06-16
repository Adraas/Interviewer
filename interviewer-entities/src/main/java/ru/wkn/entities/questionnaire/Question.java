package ru.wkn.entities.questionnaire;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * The class {@code Question} represents a single questionnaire's question wording with a preset answers.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Question {

    /**
     * The question wording.
     */
    private String questionWording;

    /**
     * The preset question answers.
     */
    private Set<Answer> answers;
}
