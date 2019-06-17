package ru.wkn.report;

import ru.wkn.entities.questionnaire.AnalyticalInformation;
import ru.wkn.entities.questionnaire.Answer;
import ru.wkn.entities.questionnaire.Interval;
import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.report.entities.Statistics;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * The class {@code StatisticsAnalyzer} represents a statistics analyzer for input questionnaire survey results.
 * This class reads all answers of a questionnaire and collects statistics.
 *
 * @author Orin Adraas
 */
public class StatisticsAnalyzer {

    /**
     * The  method for the statistics collecting by means input input questionnaire survey results.
     *
     * @param indicatedAnswers the user's indicated answers of the questionnaire
     * @param questionnaire the source questionnaire on the bases of which the {@code Statistics} object is created
     * @return a newly created {@code Statistics} object with the input questionnaire survey results statistics
     */
    public Statistics getStatisticsByResults(Set<Answer> indicatedAnswers, Questionnaire questionnaire) {
        Iterator<Answer> answerIterator = indicatedAnswers.iterator();
        Collection<String> gradeCriteria = questionnaire.getAnalyticalInformation().keySet();
        Map<String, Integer> gradesByCriteria = getGradesByCriteria(answerIterator, gradeCriteria);
        Map<String, String> analyticalInformationByCriteria =
                getAnalyticalInformationByCriteria(gradesByCriteria, questionnaire);
        return new Statistics(gradesByCriteria, analyticalInformationByCriteria);
    }

    private Map<String, Integer> getGradesByCriteria(Iterator<Answer> answerIterator,
                                                     Collection<String> gradeCriteria) {
        Map<String, Integer> gradesByCriteria = new HashMap<>();
        while (answerIterator.hasNext()) {
            Answer answer = answerIterator.next();
            for (String currentGradeCriteria : gradeCriteria) {
                if (answer.getGrades().keySet().contains(currentGradeCriteria)) {
                    if (!gradesByCriteria.keySet().contains(currentGradeCriteria)) {
                        gradesByCriteria.put(currentGradeCriteria, 0);
                    }
                    gradesByCriteria.replace(currentGradeCriteria, gradesByCriteria.get(currentGradeCriteria) + 1);
                }
            }
        }
        return gradesByCriteria;
    }

    private Map<String, String> getAnalyticalInformationByCriteria(Map<String, Integer> gradesByCriteria,
                                                                   Questionnaire questionnaire) {
        Map<String, String> analyticalInformationByCriteria = new HashMap<>();
        for (String currentGradeCriteria : gradesByCriteria.keySet()) {
            int grade = gradesByCriteria.get(currentGradeCriteria);
            Set<AnalyticalInformation> analyticalInformation =
                    questionnaire.getAnalyticalInformation().get(currentGradeCriteria);
            Iterator<AnalyticalInformation> analyticalInformationIterator = analyticalInformation.iterator();
            boolean isNotTrueInterval = true;
            while (analyticalInformationIterator.hasNext() && isNotTrueInterval) {
                AnalyticalInformation currentAnalyticalInformation = analyticalInformationIterator.next();
                Interval<Integer> interval = currentAnalyticalInformation.getInterval();
                if (grade >= interval.getMinValue() && grade <= interval.getMaxValue()) {
                    analyticalInformationByCriteria.put(currentGradeCriteria,
                            currentAnalyticalInformation.getInformation());
                    isNotTrueInterval = false;
                }
            }
        }
        return analyticalInformationByCriteria;
    }
}
