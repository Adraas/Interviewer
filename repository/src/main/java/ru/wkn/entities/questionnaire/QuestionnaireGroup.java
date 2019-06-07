package ru.wkn.entities.questionnaire;

import java.util.Set;

public class QuestionnaireGroup {

    private long id;
    private String theme;
    private Set<Questionnaire> questionnaires;
    private String authorCookie;
}
