package com.paulawaite.fbtr.controller;

import com.paulawaite.fbtr.entity.Trail;
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

@WebServlet(name = "ViewTrails", urlPatterns = { "/viewTrails" } )


public class ViewTrails extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        GenericDao<Trail> dao = DaoFactory.createDao(Trail.class);
        List<Trail> trails = dao.getAll();
        req.setAttribute("trails", trails);
        logger.debug("Sending back the trail/s..." + trails);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/viewTrails" +
                ".jsp");
        dispatcher.forward(req, resp);
    }
}
