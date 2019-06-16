package ru.wkn.entities.result;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

/**
 * The class {@code Report} represents analytical report based on results of questionnaire survey.
 *
 * @author Orin Adraas
 */
@NoArgsConstructor
@Getter
@Setter
public class Report {

    /**
     * The unique ID of report.
     */
    private long id;

    /**
     * The ID of report author.
     */
    private long authorId;

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
    private Map<String, Integer> grades;

    /**
     * Initializes a newly created {@code Report} object with the given parameter assignments to the fields of an
     * {@code Report} object.
     *
     * @param authorId    {@link #authorId}
     * @param title       {@link #title}
     * @param information {@link #information}
     * @param grades      {@link #grades}
     */
    @SuppressWarnings(value = {"unused"})
    public Report(long authorId, String title, String information, Map<String, Integer> grades) {
        this.authorId = authorId;
        this.title = title;
        this.information = information;
        this.grades = grades;
    }
}
