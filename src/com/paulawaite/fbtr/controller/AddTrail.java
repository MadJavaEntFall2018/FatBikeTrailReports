package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.Difficulty;
import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.TrailType;
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

@WebServlet(name = "AddTrail", urlPatterns = { "/addTrail" } )


public class AddTrail extends HttpServlet {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Trail trail = new Trail();
        trail.setName(req.getParameter("name"));
        trail.setState(req.getParameter("state"));
        trail.setAddress(req.getParameter("address"));
        trail.setCity(req.getParameter("city"));
        trail.setZip(req.getParameter("zip"));
        trail.setLength(Integer.parseInt(req.getParameter("length")));
        trail.setDifficulty(Integer.parseInt(req.getParameter
                ("difficulty")));
        trail.setType(Integer.parseInt(req.getParameter("type")));
        trail.setLengthUnits(req.getParameter("units"));
        trail.setDescription(req.getParameter("description"));
        trail.setTrailMap(req.getParameter("trailMap"));
        trail.setWebsite(req.getParameter("website"));

        // TODO get user by id trail.setUser(req.getRemoteUser());
        AbstractDao dao = DaoFactory.createDao(Trail.class);
        int id = dao.create(trail);

        req.setAttribute("trail", dao.get(id));
        log.debug("Sending back the trail...");


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
