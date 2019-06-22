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

public class SignInServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String authorizationEncodingData = req.getHeader("Authorization");
        authorizationEncodingData = authorizationEncodingData.split("Basic ")[1];
        authorizationEncodingData = new String(Base64.getDecoder().decode(authorizationEncodingData));
        String[] authorizationData = authorizationEncodingData.split(", ");
        if (authorizationData.length == 2) {
            String login = authorizationData[0];
            String password = authorizationData[1];
            resp.setContentType("text/plain");
            User user;
            user = getUser(login, password);
            if (user != null) {
                resp.addCookie(new Cookie("user", user.getCookie()));
                req.getRequestDispatcher("catalog").forward(req, resp);
            } else {
                resp.getWriter().println("Wrong email or password");
            }
        } else {
            resp.sendError(400, "Wrong input data");
        }
    }

    private User getUser(String login, String password) {
        RepositoryFacade repositoryFacade =
                new RepositoryFacade("questionnaires_h2_entity_manager", EntityInstanceType.USER);
        return ((UserService) repositoryFacade.getService()).getUserByEmailAndPassword(login, password);
    }
}
