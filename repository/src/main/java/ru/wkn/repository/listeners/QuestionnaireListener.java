package ru.wkn.repository.listeners;

import ru.wkn.entities.questionnaire.Questionnaire;

/**
 * The class {@code QuestionnaireListener} represents the listener for the {@code Questionnaire} entity.
 *
 * @author Orin Adraas
 */
public class QuestionnaireListener {

    /**
     * The method for the updating {@code Answer}'s grade criteria (the cascade deleting for a {@code GradeCriteria}
     * enum types).
     *
     * @param questionnaire the listened {@code Questionnaire} entity for which the monitored event was executed
     */
    public void updateAnswerGradeCriteria(Questionnaire questionnaire) {
        questionnaire.getQuestions().forEach(question ->
                question.getAnswers().forEach((answer ->
                        answer.getGrades().keySet().forEach(gradeCriteria -> {
                            if (!questionnaire.getAnalyticalInformation().keySet().contains(gradeCriteria)) {
                                answer.getGrades().remove(gradeCriteria);
                            }
                        }))));
    }
}
