package version6;

import java.util.Locale;

public final class BasePlusCommissionEmployee extends CommissionEmployee implements Cloneable {
    private double baseSalary;

    @SuppressWarnings("this-escape")

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }

    @SuppressWarnings("this-escape")

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) {
            throw new IllegalArgumentException("Base salary cannot be negative");
        }
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeSalary(0);
    }

    @Override
    public void displayEmployee() {
        System.out.printf(Locale.US, "BasePlusCommissionEmployee [ID: %d, Name: %s, Total Sales: ₱%,.2f, Base Salary: ₱%,.2f, Total Salary: ₱%,.2f]%n",
                getEmpID(), getEmpName(), getTotalSale(), baseSalary, computeSalary());
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "BasePlusCommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}
