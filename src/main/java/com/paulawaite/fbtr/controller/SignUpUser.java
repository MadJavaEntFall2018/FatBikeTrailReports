package com.paulawaite.fbtr.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.paulawaite.fbtr.entity.*;
import com.paulawaite.fbtr.persistence.AbstractDao;
import com.paulawaite.fbtr.util.DaoFactory;
import org.apache.log4j.Logger;

/**
 * Created by paulawaite on 3/3/16.
 */

@WebServlet(name = "SignUpUser", urlPatterns = { "/signUpUser" } )


public class SignUpUser extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setUserName(req.getParameter("userName"));
        user.setEmail(req.getParameter("emailAddress"));
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setPassword(req.getParameter("password"));
        log.debug("Adding User: " + user);
        Role role = new Role();
        role.setUser(user);
        role.setRole("user");
        user.addRole(role);

        AbstractDao dao = DaoFactory.createDao(User.class);
        dao.create(user);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/signInConfirmation" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
