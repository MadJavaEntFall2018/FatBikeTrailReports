package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.User;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by paulawaite on 2/2/16.
 */
public class UserDaoWithSql implements UserDao {

    private final Logger log = Logger.getLogger(this.getClass());

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();

        Database database = Database.getInstance();

        Connection connection = database.getConnection();

        String sql = "select * from users order by id";
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            database.connect();
            Statement selectStatement = connection.createStatement();
            ResultSet results = selectStatement.executeQuery(sql);

            // iterate over the resultset, adding each user to the list
            while (results.next()) {
                User user = createUserFromResults(results);
                users.add(user);
            }
        } catch (SQLException e) {
            log.error("SQL Exception: ", e);
        } catch (Exception e) {
            log.error(e);
        }


        return users;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public int addUser(User user) {
        return 0;
    }

    private User createUserFromResults(ResultSet results) throws SQLException {
        User user = new User();
        user.setId(results.getInt("id"));
        user.setFirstName(results.getString("first_name"));
        user.setLastName(results.getString("last_name"));
        user.setPassword(results.getString("password"));
        return user;
    }
}
