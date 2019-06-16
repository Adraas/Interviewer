package ru.wkn.entities.questionnaire;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.wkn.entities.result.Grade;
import ru.wkn.entities.result.GradeCriteria;

import java.util.Map;

/**
 * The class {@code Answer} represents a single answer for a questionnaire's question.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Answer {

    /**
     * The answer wording.
     */
    private String answerWording;

    /**
     * The grades for a single answer by means specific criteria.
     */
    private Map<GradeCriteria, Grade> grades;
}
