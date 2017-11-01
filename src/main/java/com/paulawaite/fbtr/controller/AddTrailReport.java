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
//TODO
        //trailReport.setTrailByTrail(Integer.parseInt(req.getParameter("trail")));
      //  trailReport.setDateRidden(req.getParameter("dateRidden"));
//        trailReport.setGroomingType(Integer.parseInt(req.getParameter
//               ("grooming")));
        trailReport.setConditions(req.getParameter("conditions"));
        trailReport.setComments(req.getParameter("comments"));
        //trailReport.setUserById(Integer.parseInt(req.getRemoteUser()));
        log.debug("The user is: " + req.getRemoteUser());

        AbstractDao dao = DaoFactory.createDao(TrailReport.class);
        int id = dao.create(trailReport);

        req.setAttribute("trail report", dao.get(id));
        log.debug("Sending back the trail ...");


        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewTrail" +
                ".jsp");
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
