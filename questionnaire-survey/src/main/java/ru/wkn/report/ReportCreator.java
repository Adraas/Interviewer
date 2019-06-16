package ru.wkn.report;

import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.entities.result.Report;
import ru.wkn.report.entities.Statistics;

public class ReportCreator {

    public Report getReportByStatistics(Statistics statistics, Questionnaire questionnaire, long authorId,
                                        int maxLineLength) {
        String information = "";
        for (String currentGradeCriteria : statistics.getAnalyticalInformationByCriteria().keySet()) {
            String currentAnalyticalInformation =
                    statistics.getAnalyticalInformationByCriteria().get(currentGradeCriteria);
            information = information
                    .concat(currentGradeCriteria)
                    .concat("\n")
                    .concat(mergeStrings(separateString(currentAnalyticalInformation, maxLineLength)))
                    .concat("\n\n");
        }
        return new Report(authorId, questionnaire.getTitle(), information, statistics.getGradesByCriteria());
    }

    // TODO: implement this method
    private String[] separateString(String currentAnalyticalInformation, int maxLineLength) {
        return new String[]{};
    }

    // TODO: implement this method
    private String mergeStrings(String[] separatedStrings) {
        return "";
    }
}
