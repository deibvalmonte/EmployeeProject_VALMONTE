package version2;

import java.util.Locale;

public class BasePlusCommissionEmployee {
    private version1.BasePlusCommissionEmployee employee;
    private Name name;
    private MyDate birthDate;

    public BasePlusCommissionEmployee() {
        this.employee = new version1.BasePlusCommissionEmployee();
        this.name = new Name();
        this.birthDate = new MyDate();
    }

    public BasePlusCommissionEmployee(int empID, Name name, MyDate birthDate, double totalSale, double baseSalary) {
        this.employee = new version1.BasePlusCommissionEmployee(empID, name.toString());
        this.name = name;
        this.birthDate = birthDate;
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
    }

    public int getEmpID() {
        return employee.getEmpID();
    }

    public void setEmpID(int empID) {
        employee.setEmpID(empID);
    }

    public String getEmpName() {
        return employee.getEmpName();
    }

    public void setEmpName(String empName) {
        employee.setEmpName(empName);
        this.name = Name.fromFullName(empName);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
        employee.setEmpName(name.toString());
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public double getTotalSale() {
        return employee.getTotalSale();
    }

    public void setTotalSale(double totalSale) {
        employee.setTotalSale(totalSale);
    }

    public double getBaseSalary() {
        return employee.getBaseSalary();
    }

    public void setBaseSalary(double baseSalary) {
        employee.setBaseSalary(baseSalary);
    }

    public double computeSalary() {
        return employee.computeSalary();
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf(Locale.US, "ID: %d | Name: %s | BirthDate: %s | Total Sales: ₱%,.2f | Base Salary: ₱%,.2f%n",
                employee.getEmpID(), name, birthDate, employee.getTotalSale(), employee.getBaseSalary());
    }

    @Override
    public String toString() {
        double commissionRate;

        if (employee.getTotalSale() < 50000) {
            commissionRate = 0.05;
        } else if (employee.getTotalSale() < 100000) {
            commissionRate = 0.10;
        } else if (employee.getTotalSale() < 500000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        return String.format(Locale.US,
                "BasePlusCommissionEmployee [ID: %d, Name: %s, BirthDate: %s, Total Sales: ₱%,.2f, Base Salary: ₱%,.2f, Commission Rate: %.2f%%, Total Salary: ₱%,.2f]",
                employee.getEmpID(), name, birthDate, employee.getTotalSale(), employee.getBaseSalary(), commissionRate * 100, computeSalary());
    }
}
