package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.*;
import com.paulawaite.fbtr.persistence.AbstractDao;
import com.paulawaite.fbtr.util.DaoFactory;
import org.apache.log4j.Logger;
import sun.misc.FloatingDecimal;

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

    private final Logger log = Logger.getLogger(this.getClass());

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

        AbstractDao difficultyDao = DaoFactory.createDao(Difficulty.class);
        Difficulty difficulty = (Difficulty) difficultyDao.get(Integer.parseInt(req.getParameter("difficulty")));
        trail.setDifficulty(difficulty);

        AbstractDao typeDao = DaoFactory.createDao(TrailType.class);
        TrailType type = (TrailType) typeDao.get(Integer.parseInt(req.getParameter("type")));
        trail.setType(type);

        AbstractDao userDao = DaoFactory.createDao(User.class);
        User user = (User) userDao.findByProperty("userName", req.getRemoteUser()).get(0);
        trail.setUser(user);

        AbstractDao dao = DaoFactory.createDao(Trail.class);
        int id = dao.create(trail);

        req.setAttribute("trail", dao.get(id));
        log.debug("Getting the trail...");


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
        AbstractDao dao =  DaoFactory.createDao(Difficulty.class);
        log.debug("Difficulties" + dao.getAll());
        return dao.getAll();
    }

    private List<TrailType> getAllTypes() {
        AbstractDao dao =  DaoFactory.createDao(TrailType.class);
        log.debug("Types" + dao.getAll());
        return dao.getAll();
    }
}
