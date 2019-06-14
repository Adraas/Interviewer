package ru.wkn.entities.questionnaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.wkn.entities.result.Grade;
import ru.wkn.entities.result.GradeCriteria;

import java.util.Map;

/**
 * The class {@code Answer} represents single answer for questionnaire's question.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Answer {

    /**
     * The answer wording.
     */
    private String answerWording;

    /**
     * The grades for single answer by means specific criteria.
     */
    private Map<GradeCriteria, Grade> grades;
}
