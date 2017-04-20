package ua.donordp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ua.donordp.model.Bank;

import java.util.List;

/**
 * Created by Alexander on 19.04.2017.
 */
@Repository
public class BankDao {
    private SessionFactory sessionFactory;

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
        Bank bank = (Bank) session.load(Bank.class, new Integer(id));

        if (bank != null)
            session.delete(bank);
    }
}
