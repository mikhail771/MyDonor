package ua.donordp.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.donordp.dao.UserDao;
import ua.donordp.model.User;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class UserService {
    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }

    @Transactional
    public List<User> userList() {
        return this.userDao.listUsers();
    }
    @Transactional
    public void updateUser(User user) {
        this.userDao.updateUser(user);
    }
    @Transactional
    public void removeUser(int id) {
        this.userDao.removeUser(id);
    }
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

}
