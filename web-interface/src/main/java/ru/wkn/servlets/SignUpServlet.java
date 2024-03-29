package ru.wkn.servlets;

import ru.wkn.RepositoryFacade;
import ru.wkn.entities.user.User;
import ru.wkn.exceptions.PersistenceException;
import ru.wkn.repository.service.UserService;
import ru.wkn.repository.util.EntityInstanceType;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader bufferedReader = req.getReader();
        String bodyRequest = "";
        while (bufferedReader.ready()) {
            bodyRequest = bodyRequest.concat(bufferedReader.readLine());
        }
        String[] inputData = bodyRequest.split("&");
        if (inputData.length == 3) {
            String[] nameData = inputData[0].split("=");
            String[] loginData = inputData[1].split("=");
            String[] passwordData = inputData[2].split("=");
            if ((nameData.length == 2 && nameData[0].equals("nickname"))
                    && (loginData.length == 2 && loginData[0].equals("login"))
                    && (passwordData.length == 2 && passwordData[0].equals("password"))) {
                String name = nameData[1];
                String login = loginData[1];
                String password = passwordData[1];
                try {
                    if (checkStringToValid(name, ',', ';', ':')
                            && checkStringToValid(login, ' ', ',', ';', ':')
                            && checkStringToValid(password, ' ', ',', ';', ':')) {
                        boolean isCreated;
                        isCreated = saveUser(name, login, password);
                        if (!isCreated) {
                            resp.getWriter().println("User not saved");
                        }
                    } else {
                        resp.getWriter().println("Input data contains forbidden symbols");
                    }
                } catch (PersistenceException e) {
                    e.printStackTrace();
                    resp.getWriter().println("User not saved: ".concat(e.getMessage()));
                }
            } else {
                resp.getWriter().println("Input data contains forbidden symbols");
            }
        } else {
            resp.getWriter().println("Missing required input data");
        }
    }

    private boolean checkStringToValid(String value, char... forbiddenSymbols) {
        for (char forbiddenSymbol : forbiddenSymbols) {
            if (value.contains(String.valueOf(forbiddenSymbol))) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings(value = {"unchecked"})
    private boolean saveUser(String name, String login, String password) throws PersistenceException {
        RepositoryFacade repositoryFacade =
                new RepositoryFacade("questionnaires_h2_entity_manager", EntityInstanceType.USER);
        String cookie = ((UserService) repositoryFacade.getService()).generateCookie(name, login, password);
        User user = new User(name, login, password, cookie);
        return repositoryFacade.getService().create(user);
    }

}
