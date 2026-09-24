package version5;

import java.util.Locale;
import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee implements Cloneable {
    private double baseSalary;

    public BasePlusCommissionEmployee() { super(); this.baseSalary = 0.0; }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { if (baseSalary < 0) throw new IllegalArgumentException("Base salary cannot be negative"); this.baseSalary = baseSalary; }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = baseSalary + super.computeSalary(currentMonth);
        return salary;
    }

    public void displayBasePlusCommissionEmployee() { System.out.printf(Locale.US, "BasePlusCommissionEmployee [ID: %d, Name: %s, Total Sales: ₱%,.2f, Base Salary: ₱%,.2f, Total Salary: ₱%,.2f]%n", getEmpID(), getEmpName(), getTotalSale(), baseSalary, computeSalary()); }

    @Override
    public String toString() { return String.format(Locale.US, "BasePlusCommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]", getEmpID(), getEmpName(), computeSalary()); }

    @Override
    public BasePlusCommissionEmployee clone() { return (BasePlusCommissionEmployee) super.clone(); }

    @Override
    public boolean equals(Object obj) { if (!super.equals(obj)) return false; if (!(obj instanceof BasePlusCommissionEmployee)) return false; BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj; return Double.compare(this.baseSalary, other.baseSalary) == 0; }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), baseSalary); }
}
