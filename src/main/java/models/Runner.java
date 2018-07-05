package models;

import db.DBHelper;
import db.DBManager;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Manager manager1 = new Manager("Aryan", "AB 12 34 56 C", 24000, 50000, "deptA");
        DBHelper.save(manager1);

        Administrator admin1 = new Administrator("Tina","BD 02 14 40 D", 18000, manager1 );
        DBHelper.save(admin1);
        Administrator admin2 = new Administrator("Riya","AC 02 11 31 A", 16000, manager1 );
        DBHelper.save(admin2);

        List<Administrator> employees = DBManager.allEmployeesForTheManager(manager1);

    }
}
