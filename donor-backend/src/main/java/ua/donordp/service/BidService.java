package ua.donordp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.donordp.dao.BidDao;
import ua.donordp.model.Bid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alexander on 19.04.2017.
 */
@Service
public class BidService {
    private BidDao bidDao;

    @Autowired
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
    public List<Bid> listBids(int decimalCount) {
        List<Bid> bidList = bidDao.listBids();
        if (bidList.size() < decimalCount * 10)
            return new ArrayList<Bid>();
        else {
            if (bidList.size() < decimalCount * 10 + 10)
                return bidList.subList(decimalCount * 10, bidList.size());
            else return bidList.subList(decimalCount * 10, decimalCount * 10 + 10);
        }
    }
}
