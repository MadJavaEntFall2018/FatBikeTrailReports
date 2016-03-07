package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.persistence.TrailDao;
import com.paulawaite.fbtr.persistence.TrailReportsDao;
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

@WebServlet(name = "ViewTrailReport", urlPatterns = { "/viewTrailReport" } )


public class ViewTrailReport extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        TrailReportsDao dao = new TrailReportsDao();
        req.setAttribute("trailReports", dao.getAllTrailReports());
        log.debug("Sending back the trail reports...");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
