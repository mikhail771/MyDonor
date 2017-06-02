package ua.donordp.dao;


import ua.donordp.model.User;

import java.util.List;

/**
 * Created by user on 21.04.17.
 */
public interface UserDao {
    public void addUser(User user);
    public void updateUser(User user);
    public List<User> listUsers();
    public User getUserById(int id);
    public void removeUser(int id);



}
