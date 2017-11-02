package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.Difficulty;
import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.TrailType;
import com.paulawaite.fbtr.entity.User;
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


        AbstractDao difficultyDao = DaoFactory.createDao(Difficulty.class);
        Difficulty difficulty = (Difficulty) difficultyDao.findByProperty("difficultyId", Integer.parseInt(req.getParameter("difficulty")));

        AbstractDao typeDao = DaoFactory.createDao(TrailType.class);
        trail.setType((TrailType) typeDao.findByProperty("trailTypeId", Integer.parseInt(req.getParameter("type"))));

        AbstractDao userDao = DaoFactory.createDao(User.class);
        trail.setUser((User) userDao.findByProperty("userName", req.getRemoteUser()));

        AbstractDao dao = DaoFactory.createDao(Trail.class);
        int id = dao.create(trail);

        req.setAttribute("trail", dao.get(id));
        log.debug("Getting the trail...");


        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewTrail" +
                ".jsp");
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
