package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.persistence.AbstractDao;
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
        AbstractDao<Trail> dao = new AbstractDao(Trail.class);
        req.setAttribute("trail", dao.get(1));
        log.debug("Sending back the trail...");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewTrail" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
