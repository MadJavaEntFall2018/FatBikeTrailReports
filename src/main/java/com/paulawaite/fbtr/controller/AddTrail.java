package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.*;
import com.paulawaite.fbtr.persistence.GenericDao;
import com.paulawaite.fbtr.util.DaoFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sun.misc.FloatingDecimal;
import sun.net.www.content.text.Generic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 3/3/16.
 */

@WebServlet(name = "AddTrail", urlPatterns = { "/addTrail" } )


public class AddTrail extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Trail trail = new Trail();
        trail.setName(req.getParameter("name"));
        trail.setLength(BigDecimal.valueOf(
                Double.parseDouble(req.getParameter("length"))));
        trail.setLengthUnits(req.getParameter("units"));
        trail.setDescription(req.getParameter("description"));
        trail.setTrailMap(req.getParameter("trailMap"));
        trail.setWebsite(req.getParameter("website"));

        Location location = new Location();
        location.setAddress1(req.getParameter("address"));
        location.setCity(req.getParameter("city"));
        location.setState(req.getParameter("state"));
        location.setPostalcode(req.getParameter("postalCode"));
        location.setLat(req.getParameter("latitude"));
        location.setLon(req.getParameter("longitude"));

        //AbstractDao locationDao = DaoFactory.createDao(Location.class);
        //locationDao.create(location);
        trail.setLocation(location);

        GenericDao typeDao = DaoFactory.createDao(TrailType.class);
        GenericDao difficultyDao = DaoFactory.createDao(Difficulty.class);
        Difficulty difficulty = (Difficulty) difficultyDao.getById(Integer.parseInt(req.getParameter("difficulty")));
        trail.setDifficulty(difficulty);

        TrailType type = (TrailType) typeDao.getById(Integer.parseInt(req.getParameter("type")));
        trail.setType(type);

        GenericDao userDao = DaoFactory.createDao(User.class);
        User user = (User) userDao.findByPropertyEqual("userName", req.getRemoteUser()).get(0);
        trail.setUser(user);

        GenericDao dao = DaoFactory.createDao(Trail.class);
        int id = dao.insert(trail);

        req.setAttribute("trail", dao.getById(id));
        logger.debug("Getting the trail...");


        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewTrails");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setAttribute("difficulties", getAllDifficulties());
        req.setAttribute("types", getAllTypes());

        RequestDispatcher dispatcher = req.getRequestDispatcher("/addTrail" +
                ".jsp");
        dispatcher.forward(req, resp);
    }

    private List<Difficulty> getAllDifficulties() {
        GenericDao dao =  DaoFactory.createDao(Difficulty.class);
        logger.debug("Difficulties" + dao.getAll());
        return dao.getAll();
    }

    private List<TrailType> getAllTypes() {
        GenericDao dao =  DaoFactory.createDao(TrailType.class);
        logger.debug("Types" + dao.getAll());
        return dao.getAll();
    }
}
