package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.*;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Created by paulawaite on 3/3/16.
 */

@WebServlet(name = "AddTrailReport", urlPatterns = { "/addReport" } )


public class AddTrailReport extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        TrailReport trailReport = new TrailReport();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/yyyy");

        LocalDate newDate = LocalDate.parse(req.getParameter("date"), formatter);
        trailReport.setRideDate(newDate);

        trailReport.setConditions(req.getParameter("conditions"));
        trailReport.setComments(req.getParameter("comments"));

        GenericDao groomingDao = DaoFactory.createDao(GroomingType.class);
        GroomingType groomingType = (GroomingType) groomingDao.getById(Integer.parseInt(req.getParameter("grooming")));
        trailReport.setGrooming(groomingType);
        GenericDao trailDao = DaoFactory.createDao(Trail.class);
        trailReport.setTrail((Trail) trailDao.getById(Integer.parseInt(req.getParameter("trail"))));

        GenericDao userDao = DaoFactory.createDao(User.class);
        List<User> users = userDao.findByPropertyEqual("userName", req.getRemoteUser());
        trailReport.setUser(users.get(0));

        GenericDao dao = DaoFactory.createDao(TrailReport.class);
        int id = ((GenericDao) dao).insert(trailReport);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewReport");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("trails", getAllTrails());
        req.setAttribute("groomingTypes", getAllTypes());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addReport" +
                ".jsp");
        dispatcher.forward(req, resp);
    }

    private List<Trail> getAllTrails() {
        GenericDao dao =  DaoFactory.createDao(Trail.class);
        List<Trail> trails = dao.getAll();
        logger.debug("List of all trails: " + trails);
        return trails ;
    }

    private List<GroomingType> getAllTypes() {
        GenericDao dao =  DaoFactory.createDao(GroomingType.class);
        List<GroomingType> types = dao.getAll();
        logger.debug("List of all types: " + types);
        return types;
    }
}
