package com.paulawaite.fbtr.persistence;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class to run sql statements as part of set up or tear down in the unit tests.
 */
public class DatabaseUtility {

    private final Logger log = Logger.getLogger(this.getClass());

    //TODO add hard-coded values to props file
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost/FBTRTest";

    static final String USER = "root";

    static final String PASS = "student";


    /**
     * Run the sql.
     *
     * @param sqlFile the sql file to be read and executed line by line
     */
    public void runSQL(String sqlFile) {
        Connection conn = null;
        Statement stmt = null;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classloader.getResourceAsStream(sqlFile);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            stmt = conn.createStatement();

            while (true) {
                String sql = br.readLine();
                if (sql == null) {
                    break;
                }
                stmt.executeUpdate(sql);

            }

        } catch (SQLException se) {
            log.error(se);
        } catch (Exception e) {
            log.error(e);
        } finally {
            try {
                if (stmt != null)
                    conn.close();
            } catch (SQLException se) {
                log.error(se);
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                log.error(se);
            }
        }

    }
}
