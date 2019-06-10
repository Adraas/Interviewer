package ru.wkn.entities.result;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;

/**
 * The class {@code Report} represents analytical report based on results of questionnaire survey.
 *
 * @author Orin Adraas
 */
@Entity(name = "report")
@Table(name = "report")
public class Report {

    /**
     * The unique ID of report.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, insertable = false, updatable = false)
    private long id;

    /**
     * The ID of report author.
     */
    @Column(name = "author_id", nullable = false)
    private String authorId;

    /**
     * The title of report.
     */
    @Column(name = "title", nullable = false, length = 100)
    private String title;

    /**
     * The general analytical information for report.
     */
    @Column(name = "information", nullable = false, length = 1000)
    private String information;

    /**
     * The result grades based on results of questionnaire survey by means specific criteria.
     */
    @ElementCollection(targetClass = Grade.class, fetch = FetchType.EAGER)
    @Enumerated(value = EnumType.STRING)
    private Map<GradeCriteria, Grade> grades;
}
