package ua.donordp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.donordp.model.Bid;
import ua.donordp.service.BidService;

import java.util.List;

@Controller
public class BidController {
    private BidService bidService;

    @Autowired
    @Qualifier(value = "bidService")
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

    @CrossOrigin
    @RequestMapping(value = "/bids", method = RequestMethod.GET)
    public @ResponseBody List<Bid> listBids(){
        List<Bid> bidList = this.bidService.listBids();
        return bidList;
    }

}
