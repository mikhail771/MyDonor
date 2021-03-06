package ua.donordp.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.donordp.model.Role;
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
        Role role = (Role) session.load(Role.class, new Integer(1));
        user.getRoles().add(role);

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

    public User userByName(String userName){
        Session session = this.sessionFactory.getCurrentSession();
        Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq("username", userName));
        Object result = criteria.uniqueResult();
        return (User) result;
    }

    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User successfully loaded. User details: " + user);

        return user;
    }
}
