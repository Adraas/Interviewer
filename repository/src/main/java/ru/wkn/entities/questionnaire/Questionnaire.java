package ru.wkn.entities.questionnaire;

import java.util.Set;

public class Questionnaire {

    private long id;
    private String title;
    private Set<Question> questions;
    private String cookie;
    private String authorCookie;
}
