package ru.wkn.entities.questionnaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

/**
 * The class {@code Question} represents single questionnaire's question wording with preset answers.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {

    /**
     * The question wording.
     */
    private String questionWording;

    /**
     * The question preset answers.
     */
    private Set<Answer> answers;
}
