package models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "managers")
public class Manager extends Employee {

    private int budget;
    private String department;
    private List<Administrator> admins;

    public Manager(){

    }

    public Manager(String name, String NINumber, int salary, int budget, String department) {
        super(name, NINumber, salary);
        this.budget = budget;
        this.department = department;
        this.admins = new ArrayList<Administrator>();
    }

    public int getBudget() {
        return budget;
    }

    public String getDepartment() {
        return department;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
    public List<Administrator> getAdmins() {
        return admins;
    }

    public void setAdmins(List<Administrator> admins) {
        this.admins = admins;
    }
}
