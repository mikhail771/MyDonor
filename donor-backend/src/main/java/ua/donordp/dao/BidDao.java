package ua.donordp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.donordp.model.Bid;

import java.util.List;

/**
 * Created by Alexander on 19.04.2017.
 */
@Repository
public class BidDao {
    private static final Logger logger = LoggerFactory.getLogger(BidDao.class);

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addBid(Bid bid) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(bid);
        logger.info("Bid successfully saved. Bid details: " + bid);
    }

    public void updateBid(Bid bid) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(bid);
        logger.info("Bid successfully update. Bid details: " + bid);
    }


    public void removeBid(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Bid bid = (Bid) session.load(Bid.class, new Integer(id));

        if(bid!=null){
            session.delete(bid);
        }
        logger.info("Bid successfully removed. Bid details: " + bid);
    }

    public Bid getBidById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Bid bid = (Bid) session.load(Bid.class, new Integer(id));
        logger.info("Bid successfully loaded. Bid details: " + bid);

        return bid;
    }

    @SuppressWarnings("unchecked")
    public List<Bid> listBids() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Bid> bidList = session.createQuery("from Bid").list();

        for(Bid bid: bidList){
            logger.info("Bid list: " + bid);
        }

        return bidList;
    }
}