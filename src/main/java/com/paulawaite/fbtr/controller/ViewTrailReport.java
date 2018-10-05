package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.TrailReport;
import com.paulawaite.fbtr.persistence.GenericDao;
import com.paulawaite.fbtr.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by paulawaite on 3/3/16.
 */

@WebServlet(name = "ViewTrailReport", urlPatterns = { "/viewReport" } )


public class ViewTrailReport extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        GenericDao<TrailReport> dao =  DaoFactory.createDao(TrailReport.class);
        List<TrailReport> reports = dao.getAll();
        req.setAttribute("trailReports", reports);
        logger.debug("Sending back the trail reports...");



        RequestDispatcher dispatcher = req.getRequestDispatcher("/index" +
                ".jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
