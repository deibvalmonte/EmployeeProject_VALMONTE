package version4;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        if (baseSalary >= 0.0) {
            this.baseSalary = baseSalary;
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeSalary(-1);
    }

    public void displayBasePlusCommissionEmployee() {
        displayEmployee();
        System.out.printf("Total Sale: ₱%,.2f | Base Salary: ₱%,.2f%n", getTotalSale(), baseSalary);
    }

    @Override
    public String toString() {
        return String.format("%s, Total Sale: ₱%,.2f, Base Salary: ₱%,.2f, Total Salary: ₱%,.2f",
                super.toString(), getTotalSale(), baseSalary, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        BasePlusCommissionEmployee that = (BasePlusCommissionEmployee) obj;
        return Double.compare(that.baseSalary, baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public BasePlusCommissionEmployee clone() {
        return (BasePlusCommissionEmployee) super.clone();
    }
}
