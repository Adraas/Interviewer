package ru.wkn.entities.questionnaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.wkn.entities.result.Grade;
import ru.wkn.entities.result.GradeCriteria;

import javax.persistence.Column;
import javax.persistence.Embeddable;
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
@Embeddable
public class Answer {

    /**
     * The answer wording.
     */
    @Column(name = "answer", nullable = false, length = 300)
    private String answerWording;

    /**
     * The grades for single answer by means specific criteria.
     */
    @Column(name = "grade", nullable = false)
    private Map<GradeCriteria, Grade> grades;
}
