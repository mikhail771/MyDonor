package ua.donordp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.donordp.model.Bid;
import ua.donordp.service.BidService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bids")
public class BidController {
    private BidService bidService;

    @Autowired
    public void setBidService(BidService bidService) {
        this.bidService = bidService;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Bid> listBids(){
        List<Bid> bidList = this.bidService.listBids();
        return bidList;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity addBid(@RequestBody Bid bid) {
        this.bidService.addBid(bid);
        return ResponseEntity.created(URI.create("/bids")).build();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public @ResponseBody
    ResponseEntity deleteBid(@PathVariable String id){
        bidService.removeBid(Integer.parseInt(id));
        return ResponseEntity.created(URI.create("/bids")).build();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value="{id}")
    public @ResponseBody
    ResponseEntity updateBid(@RequestBody Bid bid, @PathVariable String id){
        bidService.updateBid(bid);
        return ResponseEntity.created(URI.create("/bids")).build();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public @ResponseBody
    Bid getBidById(@PathVariable String id){
        Bid bidId = bidService.getBidById(Integer.parseInt(id));
        return bidId;
    }
}
