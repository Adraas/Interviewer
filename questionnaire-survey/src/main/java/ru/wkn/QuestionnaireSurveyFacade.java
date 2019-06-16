package ru.wkn;

import lombok.Getter;
import ru.wkn.report.AnalyticalInformationGenerator;
import ru.wkn.report.ReportCreator;
import ru.wkn.report.StatisticsAnalyzer;

/**
 * The class {@code QuestionnaireSurveyFacade} represents the facade pattern for this module.
 *
 * @author Orin Adraas
 */
@Getter
public class QuestionnaireSurveyFacade {

    private StatisticsAnalyzer statisticsAnalyzer;
    private AnalyticalInformationGenerator analyticalInformationGenerator;
    private ReportCreator reportCreator;

    public QuestionnaireSurveyFacade() {
        statisticsAnalyzer = new StatisticsAnalyzer();
        reportCreator = new ReportCreator();
    }
}
