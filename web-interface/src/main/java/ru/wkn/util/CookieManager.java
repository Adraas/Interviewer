package ru.wkn.util;

import lombok.Getter;
import lombok.Setter;
import ru.wkn.RepositoryFacade;
import ru.wkn.repository.service.UserService;
import ru.wkn.repository.util.EntityInstanceType;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieManager {

    @Getter
    @Setter
    private static String cookieName = "interviewer-user";

    public static String getCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        int i = 0;
        if (cookies != null) {
            if (cookies.length > 0) {
                while (i < cookies.length - 1 && !cookies[i].getName().equals(cookieName)) {
                    i++;
                }
                Cookie cookie = cookies[i];
                if (cookie.getName().equals(cookieName)) {
                    String cookieValue = cookie.getValue();
                    RepositoryFacade repositoryFacade =
                            new RepositoryFacade("questionnaires_h2_entity_manager", EntityInstanceType.USER);
                    if (((UserService) repositoryFacade.getService()).checkCookieToExist(cookieValue)) {
                        return cookie.getValue();
                    }
                }
            }
        }
        return null;
    }
}
