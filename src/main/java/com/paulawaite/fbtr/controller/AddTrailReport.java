package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.*;
import com.paulawaite.fbtr.persistence.AbstractDao;
import com.paulawaite.fbtr.util.DaoFactory;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 3/3/16.
 */

@WebServlet(name = "AddTrailReport", urlPatterns = { "/addReport" } )


public class AddTrailReport extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        TrailReport trailReport = new TrailReport();

        LocalDateTime newDate = LocalDateTime.parse(req.getParameter("date"));

        trailReport.setRideDate(newDate);

        trailReport.setConditions(req.getParameter("conditions"));
        trailReport.setComments(req.getParameter("comments"));

        AbstractDao groomingDao = DaoFactory.createDao(GroomingType.class);
        List<GroomingType> groomingType = groomingDao.findByProperty("groomingTypeId", Integer.parseInt(req.getParameter("grooming")));
        trailReport.setGrooming(groomingType.get(0));

        AbstractDao trailDao = DaoFactory.createDao(Trail.class);
        trailReport.setTrail((Trail) trailDao.get(Integer.parseInt(req.getParameter("trail"))));

        AbstractDao userDao = DaoFactory.createDao(User.class);
        List<User> users = userDao.findByProperty("userName", req.getRemoteUser());
        trailReport.setUser(users.get(0));

        AbstractDao dao = DaoFactory.createDao(TrailReport.class);
        int id = dao.create(trailReport);

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
        AbstractDao dao =  DaoFactory.createDao(Trail.class);
        List<Trail> trails = dao.getAll();
        log.debug("List of all trails: " + trails);
        return trails ;
    }

    private List<GroomingType> getAllTypes() {
        AbstractDao dao =  DaoFactory.createDao(GroomingType.class);
        List<GroomingType> types = dao.getAll();
        log.debug("List of all types: " + types);
        return types;
    }
}
