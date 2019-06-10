package ru.wkn.entities.result;

import java.util.Map;

/**
 * The class {@code Report} represents analytical report based on results of questionnaire survey.
 *
 * @author Orin Adraas
 */
public class Report {

    /**
     * The unique ID of report.
     */
    private long id;

    /**
     * The title of report.
     */
    private String title;

    /**
     * The general analytical information for report.
     */
    private String information;

    /**
     * The result grades based on results of questionnaire survey by means specific criteria.
     */
    private Map<GradeCriteria, Grade> grades;

    /**
     * The cookie of report author.
     */
    private String authorCookie;
}
