package ua.donordp.service;


import org.springframework.stereotype.Service;
import ua.donordp.dao.UserDao;
import ua.donordp.model.User;

import javax.transaction.Transactional;


@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addUser(User user) {
        this.userDao.addUser(user);
    }


}


