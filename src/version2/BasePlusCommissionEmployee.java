package version2;

import java.util.Locale;

public class BasePlusCommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        this(0, new Name(), new MyDate(), new MyDate(), 0, 0);
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                                     double totalSale, double baseSalary) {
        setEmpID(empID);
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
        setTotalSale(totalSale);
        setBaseSalary(baseSalary);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public Name getName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName != null ? empName : new Name();
    }

    public void setName(Name empName) {
        setEmpName(empName);
    }

    public void setEmpName(String empNameText) {
        setEmpName(Name.fromFullName(empNameText));
    }

    public String getEmpNameString() {
        return empName == null ? new Name().toString() : empName.toString();
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate != null ? birthDate : new MyDate();
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired != null ? dateHired : new MyDate();
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale < 0) {
            throw new IllegalArgumentException("Total sales cannot be negative.");
        }
        this.totalSale = totalSale;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative.");
        }
        this.baseSalary = baseSalary;
    }

    public double computeSalary() {
        return computeBaseSalary();
    }

    public double computeSalary(int currentMonth) {
        double salary = computeBaseSalary();
        if (birthDate != null && birthDate.getMonth() == currentMonth) {
            salary += 5000.00;
        }
        return salary;
    }

    private double computeBaseSalary() {
        double commissionRate;

        if (totalSale < 50000) {
            commissionRate = 0.05;
        } else if (totalSale < 100000) {
            commissionRate = 0.10;
        } else if (totalSale < 500000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        return baseSalary + (totalSale * commissionRate);
    }

    public void displayBasePlusCommissionEmployee() {
        System.out.printf(Locale.US,
                "ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sales: ₱%,.2f | Base Salary: ₱%,.2f%n",
                empID, empName, birthDate, dateHired, totalSale, baseSalary);
    }

    @Override
    public String toString() {
        double commissionRate;

        if (totalSale < 50000) {
            commissionRate = 0.05;
        } else if (totalSale < 100000) {
            commissionRate = 0.10;
        } else if (totalSale < 500000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        return String.format(Locale.US,
                "BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Total Sales: ₱%,.2f, Base Salary: ₱%,.2f, Commission Rate: %.2f%%, Total Salary: ₱%,.2f]",
                empID, empName, birthDate, dateHired, totalSale, baseSalary, commissionRate * 100, computeSalary());
    }
}
