package ua.donordp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.donordp.model.Bank;
import ua.donordp.service.BankService;

import java.net.URI;
import java.util.List;

/**
 * Created by Alexander on 19.04.2017.
 */
@RestController
@RequestMapping("/banks")
public class BankController {
    private BankService bankService;

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Bank> bankList() {
        return this.bankService.bankList();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity addOrDeleteBank(@RequestBody Bank bank) {
            bankService.addBank(bank);
            return ResponseEntity.created(URI.create("/banks")).build();
    }


    //TODO
    public void deleteBank(Integer id){
        bankService.removeBank(id);
    }
}
