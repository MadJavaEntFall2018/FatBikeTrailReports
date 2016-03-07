package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.User;
import com.paulawaite.fbtr.persistence.TrailDao;
import com.paulawaite.fbtr.persistence.UserDao;
import com.paulawaite.fbtr.persistence.UserDaoWithHibernate;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by paulawaite on 3/3/16.
 */

@WebServlet(name = "ViewTrail", urlPatterns = { "/viewTrail" } )


public class ViewTrail extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        TrailDao dao = new TrailDao();
        req.setAttribute("trail", dao.getTrailById(1));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewTrail" +
                ".jsp");

            }
}
