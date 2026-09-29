package version6;

import java.util.Locale;

public class CommissionEmployee extends Employee implements Cloneable {
    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale < 0) {
            throw new IllegalArgumentException("Total sale cannot be negative");
        }
        this.totalSale = totalSale;
    }

    protected double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        }
        if (totalSale < 100000) {
            return 0.10;
        }
        if (totalSale < 500000) {
            return 0.15;
        }
        return 0.20;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return totalSale * getCommissionRate() + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeSalary(0);
    }

    @Override
    public void displayEmployee() {
        System.out.printf(Locale.US, "CommissionEmployee [ID: %d, Name: %s, Total Sales: ₱%,.2f, Total Salary: ₱%,.2f]%n",
                getEmpID(), getEmpName(), totalSale, computeSalary());
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "CommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}
