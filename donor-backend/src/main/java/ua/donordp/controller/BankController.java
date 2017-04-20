package ua.donordp.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.donordp.model.Bank;
import ua.donordp.service.BankService;

import java.io.IOException;
import java.util.List;

/**
 * Created by Alexander on 19.04.2017.
 */
@RestController
public class BankController {
    private BankService bankService;

    @Autowired
    public void setBankService(BankService bankService) {
        this.bankService = bankService;
    }

    @CrossOrigin
    @RequestMapping(value = "/banks", method = RequestMethod.GET)
    @ResponseBody
    public List<Bank> bankList() {
        return this.bankService.bankList();
    }

    @CrossOrigin
    @RequestMapping(value = "/banks", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<Bank> addOrDeleteBank(@RequestBody String text) {
        Bank bank = null;
        try {
            bank = new ObjectMapper().readValue(text, Bank.class);
            bankService.addBank(bank);
        } catch (IOException e) {
            try {
                int id = Integer.parseInt(text);
                bankService.removeBank(id);
            } catch (NumberFormatException e1) {
                return bankService.bankList();
            }
        }
        return bankService.bankList();
    }
}
