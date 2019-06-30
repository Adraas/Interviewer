package ru.wkn.servlets;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.repository.util.EntityInstanceType;
import ru.wkn.util.CookieManager;
import ru.wkn.util.ImmutablePair;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class CatalogServlet extends HttpServlet {

    private static Map<String, Date> lastUpdatingDates = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cookie = CookieManager.getCookie(req);
        checkCookie(cookie, resp);
        String attributeDate = "last-updating-date";
        String lastUpdatingDateAsString = (String) req.getAttribute(attributeDate);
        if (lastUpdatingDateAsString != null && !lastUpdatingDateAsString.trim().equals("")) {
            updateLastUpdatingDate(cookie, new Date(Long.valueOf(lastUpdatingDateAsString)), resp, attributeDate);
        } else {
            updateLastUpdatingDate(cookie, new Date(System.currentTimeMillis()), resp, attributeDate);
        }
    }

    private void updateLastUpdatingDate(String cookie, Date lastUpdatingDate, HttpServletResponse resp,
                                        String attributeDate) throws IOException {
        String attributeTable = "response-table";
        if (lastUpdatingDates.containsKey(cookie)) {
            if (!lastUpdatingDates.get(cookie).equals(lastUpdatingDate)) {
                resp.getWriter().print(attributeDate
                        .concat("=")
                        .concat(String.valueOf(System.currentTimeMillis()))
                        .concat("&")
                        .concat(attributeTable)
                        .concat("=")
                        .concat(generateAnswerTable()));
            } else {
                resp.getWriter().println();
            }
        } else {
            Date newUpdatingDate = new Date(System.currentTimeMillis());
            lastUpdatingDates.put(cookie, newUpdatingDate);
            resp.getWriter().print(attributeDate
                    .concat("=")
                    .concat(String.valueOf(System.currentTimeMillis()))
                    .concat("&")
                    .concat(attributeTable)
                    .concat("=")
                    .concat(generateAnswerTable()));
        }
    }

    @SuppressWarnings(value = {"unchecked"})
    private String generateAnswerTable() {
        Set<ImmutablePair<Questionnaire, String>> setQuestionnaires = new HashSet<>();
        RepositoryFacade repositoryFacade =
                new RepositoryFacade("questionnaires_h2_entity_manager", EntityInstanceType.QUESTIONNAIRE_GROUP);
        Collection<QuestionnaireGroup> questionnaireGroups = repositoryFacade.getService().getAll();
        repositoryFacade.setEntityInstanceType(EntityInstanceType.QUESTIONNAIRE);
        Collection<Questionnaire> questionnaires = repositoryFacade.getService().getAll();
        for (QuestionnaireGroup questionnaireGroup : questionnaireGroups) {
            for (Questionnaire questionnaire : questionnaireGroup.getQuestionnaires()) {
                setQuestionnaires.add(new ImmutablePair<>(questionnaire, questionnaireGroup.getTheme()));
            }
        }
        Collection<Questionnaire> questionnairesForDeleting = setQuestionnaires
                .stream()
                .map(ImmutablePair::getQObject)
                .collect(Collectors.toList());
        for (ImmutablePair<Questionnaire, String> immutablePair : setQuestionnaires) {
            questionnairesForDeleting.add(immutablePair.getQObject());
        }
        questionnaires.removeAll(questionnairesForDeleting);
        for (Questionnaire questionnaire : questionnaires) {
            setQuestionnaires.add(new ImmutablePair<>(questionnaire, null));
        }
        return generateAnswerTable(setQuestionnaires);
    }

    private String generateAnswerTable(Set<ImmutablePair<Questionnaire, String>> questionnaires) {
        String answerTable = "";
        // TODO: create other implementation
        return answerTable;
    }

    private void checkCookie(String cookie, HttpServletResponse resp) throws IOException {
        if (cookie == null) {
            resp.sendRedirect("/sign_in.jsp");
        }
    }
}
