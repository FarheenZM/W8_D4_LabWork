package db;

import com.sun.xml.internal.ws.handler.HandlerException;
import models.Administrator;
import models.Employee;
import models.Manager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class DBManager {

    private static Session session;
    private static Transaction transaction;

    public static List<Administrator> allEmployeesForTheManager(Manager manager) {
        session = HibernateUtil.getSessionFactory().openSession();
        List<Administrator> results = null;

        try {
            Criteria cr = session.createCriteria(Administrator.class);
            cr.add(Restrictions.eq("manager", manager));
            results = cr.list();
        } catch (HandlerException e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }

        return results;
    }

}
