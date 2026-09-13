package version2;

import java.util.Locale;

public class CommissionEmployee {
    private version1.CommissionEmployee employee;
    private Name name;
    private MyDate birthDate;

    public CommissionEmployee() {
        this.employee = new version1.CommissionEmployee();
        this.name = new Name();
        this.birthDate = new MyDate();
    }

    public CommissionEmployee(int empID, Name name, MyDate birthDate, double totalSale) {
        this.employee = new version1.CommissionEmployee(empID, name.toString());
        this.name = name;
        this.birthDate = birthDate;
        setTotalSale(totalSale);
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

    public double computeSalary() {
        return employee.computeSalary();
    }

    public void displayCommissionEmployee() {
        System.out.printf(Locale.US, "ID: %d | Name: %s | BirthDate: %s | Total Sales: ₱%,.2f%n",
                employee.getEmpID(), name, birthDate, employee.getTotalSale());
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "CommissionEmployee [ID: %d, Name: %s, BirthDate: %s, Total Sales: ₱%,.2f, Total Salary: ₱%,.2f]",
                employee.getEmpID(), name, birthDate, employee.getTotalSale(), computeSalary());
    }
}
