package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.Trail;
import com.paulawaite.fbtr.entity.TrailReport;
import org.junit.Before;
import org.junit.Test;


import java.sql.Date;

import static org.junit.Assert.*;

/**
 * Created by paulawaite on 3/6/16.
 */
public class TrailReportsDaoTest {

    //TODO create a method to delete any created records
    private int insertedRecordToBeDeleted = 0;
    TrailReportsDao dao = new TrailReportsDao();

    @Before
    public void setUp() {
        int insertedTrailReportId = 0;
        //create trail report to add
        TrailReport trailReport = new TrailReport();
        trailReport.setComments("report comments");
        trailReport.setConditions("report conditions");

        java.util.Date date = new java.util.Date();
        trailReport.setDateRidden(new java.sql.Date(date.getTime()));

        insertedRecordToBeDeleted = dao.addTrailReport(trailReport);

    }

    @Test
    public void testGetAllTrailReports() throws Exception {
        assertTrue(dao.getAllTrailReports().size() > 0);
    }

    @Test
    public void testGetTrailReportById() throws Exception {
        TrailReport trailReport = dao.getTrailReportById
                (insertedRecordToBeDeleted);
        assertEquals(insertedRecordToBeDeleted, trailReport.getId());
        assertEquals("report comments", trailReport.getComments());
    }

    @Test
    public void testAddTrailReport() throws Exception {
        assertTrue(insertedRecordToBeDeleted > 0);
    }
}