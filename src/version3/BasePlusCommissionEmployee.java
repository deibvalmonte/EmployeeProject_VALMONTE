package version3;

import java.util.Locale;
import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee implements Cloneable {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) {
        if (baseSalary < 0) throw new IllegalArgumentException("Base salary cannot be negative");
        this.baseSalary = baseSalary;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return baseSalary + super.computeSalary(currentMonth);
    }

    @Override
    public double computeSalary() {
        return baseSalary + super.computeSalary();
    }

    public void displayBasePlusCommissionEmployee() {
        super.displayCommissionEmployee();
        System.out.printf(Locale.US, "   Base Salary: ₱%,.2f%n", baseSalary);
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s] Total Sales: ₱%,.2f, Base Salary: ₱%,.2f, Total Salary: ₱%,.2f",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), getTotalSale(), baseSalary, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof BasePlusCommissionEmployee)) return false;
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(this.baseSalary, other.baseSalary) == 0;
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
