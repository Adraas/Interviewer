package ru.wkn.report;

import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.entities.result.Report;
import ru.wkn.report.entities.Statistics;

/**
 * The class {@code ReportCreator} represents a class creating and setting for a view the {@code Report} objects.
 *
 * @author Orin Adraas
 */
public class ReportCreator {

    /**
     * The method for the {@code Report} object creating by the questionnaire survey result statistics.
     *
     * @param statistics the questionnaire survey result statistics
     * @param questionnaire the source questionnaire on the bases of which the {@code Report} object is created
     * @param authorId the ID of the user who passed the questionnaire survey
     * @return a newly created {@code Report} object
     */
    public Report getReportByStatistics(Statistics statistics, Questionnaire questionnaire, long authorId) {
        String information = "";
        for (String currentGradeCriteria : statistics.getAnalyticalInformationByCriteria().keySet()) {
            String currentAnalyticalInformation =
                    statistics.getAnalyticalInformationByCriteria().get(currentGradeCriteria);
            information = information
                    .concat(currentGradeCriteria)
                    .concat("\n")
                    .concat(currentAnalyticalInformation)
                    .concat("\n\n");
        }
        return new Report(authorId, questionnaire.getTitle(), information, statistics.getGradesByCriteria());
    }

    /**
     * The method for the analytical information scaling to width for the report printing.
     *
     * @param analyticalInformation the analytical information for the scaling to width
     * @param maxLineLength the max length of each line
     * @return a scaled to width analytical information
     */
    // TODO: implement this method
    private String scaleToWidth(String analyticalInformation, int maxLineLength) {
        return "";
    }
}
