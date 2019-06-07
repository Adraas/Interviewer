package ru.wkn.entities.result;

import java.util.Map;

public class Report {

    private long id;
    private String title;
    private String information;
    private Map<GradeCriteria, Grade> grades;
    private String questionnaireCookie;
    private String authorCookie;
}
