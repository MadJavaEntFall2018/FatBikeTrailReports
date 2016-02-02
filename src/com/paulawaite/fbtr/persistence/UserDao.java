package com.paulawaite.fbtr.persistence;

import com.paulawaite.fbtr.entity.User;

import java.util.List;

/**
 * Created by paulawaite on 2/2/16.
 */
public interface UserDao {
    public List<User> getAllUsers();
    public void updateUser();
    public void deleteUser(User user);
    public void addUser(User user);
}
