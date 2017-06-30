package ua.donordp.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.donordp.model.Bank;
import ua.donordp.model.Role;
import ua.donordp.service.BankService;
import ua.donordp.service.SecurityService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/banks")
public class BankController {
    private BankService bankService;
    private SecurityService securityService;

    @Autowired
    public void setSecurityService(SecurityService securityService){this.securityService = securityService;};

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

    @CrossOrigin
    @RequestMapping(method = RequestMethod.DELETE, value="{id}")
    public @ResponseBody
    ResponseEntity deleteBank(@PathVariable String id){
        return securityService.operateWithRole(Role.ADMIN, new SecurityService.SecuredOperation<Void>() {

            @Override
            public ResponseEntity<Void> operate() {
                bankService.removeBank(Integer.parseInt(id));
                return ResponseEntity.created(URI.create("/banks")).build();
            }
        });
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, value="{id}")
    public @ResponseBody
    ResponseEntity updateBank(@RequestBody Bank bank, @PathVariable String id){
        bankService.updateBank(bank);
        return ResponseEntity.created(URI.create("/banks")).build();
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET, value="{id}")
    public @ResponseBody
    Bank getBankById(@PathVariable String id){
        Bank bankId = bankService.getBankById(Integer.parseInt(id));
        return bankId;
    }
}
