package ua.donordp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.donordp.dao.BankDao;
import ua.donordp.model.Bank;

import java.util.List;

/**
 * Created by Alexander on 19.04.2017.
 */
@Service
public class BankService {
    private BankDao bankDao;

    public void setBankDao(BankDao bankDao) {
        this.bankDao = bankDao;
    }

    @Transactional
    public List<Bank> bankList() {
        return this.bankDao.bankList();
    }

    @Transactional
    public void addBank(Bank bank) {
        this.bankDao.addBank(bank);
    }

    @Transactional
    public void removeBank(int id) {
        this.bankDao.removeBank(id);
    }
}
