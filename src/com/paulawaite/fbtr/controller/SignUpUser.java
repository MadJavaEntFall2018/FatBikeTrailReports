package com.paulawaite.fbtr.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.paulawaite.fbtr.entity.*;
import com.paulawaite.fbtr.persistence.UserDao;
import org.apache.log4j.Logger;

/**
 * Created by paulawaite on 3/3/16.
 */

@WebServlet(name = "SignUpUser", urlPatterns = { "/signUpUser" } )


public class SignUpUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Users user = new Users(0, req.getParameter("firstName"), req
                .getParameter("lastName"), req.getParameter("emailAddress"),
                req.getParameter("password"));
        log.debug("Adding User: " + user);
        UserDao dao = new UserDao();
        dao.addUser(user);
    }
}
