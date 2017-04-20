package ua.donordp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.donordp.dao.BidDao;
import ua.donordp.model.Bid;

import java.util.List;

/**
 * Created by Alexander on 19.04.2017.
 */
@Service
public class BidService {
    private BidDao bidDao;

    public void setBidDao(BidDao bidDao) {
        this.bidDao = bidDao;
    }

    @Transactional
    public void addBid(Bid bid) {
        this.bidDao.addBid(bid);
    }

    @Transactional
    public void updateBid(Bid bid) {
        this.bidDao.updateBid(bid);
    }

    @Transactional
    public void removeBid(int id) {
        this.bidDao.removeBid(id);
    }

    @Transactional
    public Bid getBidById(int id) {
        return this.bidDao.getBidById(id);
    }

    @Transactional
    public List<Bid> listBids() {
        return this.bidDao.listBids();
    }
}
