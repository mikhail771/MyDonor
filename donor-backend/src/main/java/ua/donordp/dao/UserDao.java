package ua.donordp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.donordp.model.User;

import java.util.List;

@Repository
public class UserDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved. User details: " + user);
    }

    @SuppressWarnings("unchecked")
    public List listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> listUsers = session.createQuery("from User").list();

        return listUsers;
    }

    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
    }

    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if (user != null) {
            session.delete(user);
        }
    }

    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User successfully loaded. User details: " + user);

        return user;
    }
}
