package ru.wkn.servlets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CatalogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        doPost(req, resp);
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String cookie = getCookie(req);
        checkCookie(cookie, resp);
        // TODO: create other implementation
    }

    private String getCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        int i = 0;
        while (!cookies[i].getName().equals("user")) {
            i++;
        }
        Cookie cookie = cookies[i];
        if (!cookie.getName().equals("user")) {
            return null;
        } else {
            return cookie.getValue();
        }
    }

    private void checkCookie(String cookie, HttpServletResponse resp) throws IOException {
        if (cookie == null) {
            resp.sendRedirect("sign_in");
        }
    }
}
