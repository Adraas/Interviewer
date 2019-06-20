package ru.wkn.servlets;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.user.User;
import ru.wkn.repository.service.UserService;
import ru.wkn.repository.util.EntityInstanceType;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Base64;
import java.util.Enumeration;

public class SignInServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Enumeration<String> authorizationHeaderData = req.getHeaders("Authorization");
        String login = null;
        String password = null;
        if (authorizationHeaderData.hasMoreElements()) {
            login = new String(Base64.getDecoder().decode(authorizationHeaderData.nextElement()));
        }
        if (authorizationHeaderData.hasMoreElements()) {
            password = new String(Base64.getDecoder().decode(authorizationHeaderData.nextElement()));
        }

        resp.setContentType("text/plain");
        if (!authorizationHeaderData.hasMoreElements() && login != null && password != null) {
            User user;
            user = getUser(login, password);
            if (user != null) {
                resp.addCookie(new Cookie("user", user.getCookie()));
                req.getRequestDispatcher("/interviewer/catalog.jsp").forward(req, resp);
            } else {
                resp.sendError(400, "Wrong email or password");
            }
        } else {
            resp.sendError(400, "Wrong email or password");
        }
    }

    private User getUser(String login, String password) {
        RepositoryFacade repositoryFacade =
                new RepositoryFacade("questionnaires_h2_entity_manager", EntityInstanceType.USER);
        return ((UserService) repositoryFacade.getService()).getUserByEmailAndPassword(login, password);
    }
}
