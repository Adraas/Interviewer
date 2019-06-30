package ru.wkn.servlets;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.questionnaire.Questionnaire;
import ru.wkn.entities.questionnaire.QuestionnaireGroup;
import ru.wkn.repository.util.EntityInstanceType;
import ru.wkn.util.CookieManager;
import ru.wkn.util.ImmutablePair;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CatalogServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookie = CookieManager.getCookie(req);
        checkCookie(cookie, resp);
        String request = (String) req.getAttribute("request");
        if (request != null) {
            switch (request) {
                case "update-data-table": {
                    sendUpdatingDataTable(resp);
                    break;
                }
                case "open-questionnaire": {
                    req.getRequestDispatcher("/current_questionnaire").forward(req, resp);
                    break;
                }
                default: {
                    resp.getWriter().println();
                }
            }
        }
    }

    private void sendUpdatingDataTable(HttpServletResponse resp) throws IOException {
        String attributeTable = "response-data";
        resp.getWriter().print(attributeTable
                .concat("=")
                .concat(generateAnswerTable()));
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
            setQuestionnaires.add(new ImmutablePair<>(questionnaire, "-"));
        }
        return generateAnswerTable(setQuestionnaires);
    }

    private String generateAnswerTable(Set<ImmutablePair<Questionnaire, String>> questionnaires) {
        String answerTable = "<table>\r\n\t<tbody>\r\n\t\t<tr>\r\n\t\t\t<th>Название анкеты</th>"
                .concat("\r\n\t\t\t<th>Тематика (если есть)</th>\r\n\t\t</tr>");
        for (ImmutablePair<Questionnaire, String> immutablePair : questionnaires) {
            answerTable = answerTable
                    .concat("\r\n\t\t<tr onclick=\"Interviewer.openElement('/catalog', 'request=open-questionnaire")
                    .concat("&indicated-questionnaire-id=")
                    .concat(String.valueOf(immutablePair.getQObject().getId()))
                    .concat("')\">\r\n\t\t\t<td>")
                    .concat(immutablePair.getQObject().getTitle())
                    .concat("</td>\r\n\t\t\t<td>")
                    .concat(immutablePair.getGObject())
                    .concat("</td>\r\n\t\t</tr>");
        }
        answerTable = answerTable.concat("\r\n\t</tbody>\r\n</table>");
        return answerTable;
    }

    private void checkCookie(String cookie, HttpServletResponse resp) throws IOException {
        if (cookie == null) {
            resp.sendRedirect("/sign_in.jsp");
        }
    }
}
