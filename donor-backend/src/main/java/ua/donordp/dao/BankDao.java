package ua.donordp.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.donordp.model.Bank;

import java.util.List;

@Repository
public class BankDao {
    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public List<Bank> bankList() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Bank> bankList = session.createQuery("from Bank").list();

        return bankList;
    }

    public void addBank(Bank bank) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(bank);
    }

    public void removeBank(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Bank bank = (Bank) session.load(Bank.class, id);

        if (bank != null)
            session.delete(bank);
    }

    public void updateBank(Bank bank) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(bank);
    }

    public Bank getBankById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Bank bank = (Bank) session.load(Bank.class, new Integer(id));
        Hibernate.initialize(bank);
        return bank;
    }
}