package ua.donordp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.donordp.model.Bank;
import ua.donordp.service.BankService;

import java.util.List;

/**
 * Created by Alexander on 19.04.2017.
 */
@RestController
public class BankController {
    private BankService bankService;

    @Autowired(required = true)
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @CrossOrigin
    @RequestMapping(value = "/banks", method = RequestMethod.GET)
    @ResponseBody
    public List<Bank> bankList() {
        return this.bankService.bankList();
    }

//    @CrossOrigin
//    @RequestMapping(value = "/banks", method = RequestMethod.POST,
//            consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void addBank(@RequestBody String json) {}

}
