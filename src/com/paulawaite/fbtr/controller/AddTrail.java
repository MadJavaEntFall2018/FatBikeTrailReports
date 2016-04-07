package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.persistence.TrailDao;
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

@WebServlet(name = "AddTrail", urlPatterns = { "/addTrail" } )


public class AddTrail extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Trail trail = new Trail();
        trail.setName(req.getParameter("name"));
        trail.setZip(req.getParameter("zip"));
        TrailDao dao = new TrailDao();
        int id = dao.addTrail(trail);

        req.setAttribute("trail", dao.getTrailById(id));
        log.debug("Sending back the trail...");


        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewTrail" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
