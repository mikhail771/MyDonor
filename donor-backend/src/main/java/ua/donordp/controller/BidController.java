package ua.donordp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.donordp.model.Bid;
import ua.donordp.service.BidService;

import java.io.IOException;
import java.util.List;

@Controller(value = "/bids")
public class BidController {
    private BidService bidService;

    @Autowired
    @Qualifier(value = "bidService")
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Bid> listBids(){
        List<Bid> bidList = this.bidService.listBids();
        return bidList;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String addBid(@RequestBody String json) {
        try {
            Bid bid = new ObjectMapper().readValue(json, Bid.class);
            this.bidService.addBid(bid);

            return "Data successfully added!";

        } catch (IOException e) {
            return "ERROR JSON!";
        }
    }
}
