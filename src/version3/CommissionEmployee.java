package version3;

import java.util.Locale;
import java.util.Objects;

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

    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double totalSale) {
        if (totalSale < 0) throw new IllegalArgumentException("Total sale cannot be negative");
        this.totalSale = totalSale;
    }

    protected double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        if (totalSale < 100000) return 0.10;
        if (totalSale < 500000) return 0.15;
        return 0.20;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return (totalSale * getCommissionRate()) + super.computeSalary(currentMonth);
    }

    @Override
    public double computeSalary() {
        return (totalSale * getCommissionRate()) + super.computeSalary();
    }

    public void displayCommissionEmployee() {
        super.displayEmployee();
        System.out.printf(Locale.US, "   Total Sales: ₱%,.2f%n", totalSale);
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s] Total Sales: ₱%,.2f, Total Salary: ₱%,.2f",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalSale, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof CommissionEmployee)) return false;
        CommissionEmployee other = (CommissionEmployee) obj;
        return Double.compare(this.totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public CommissionEmployee clone() {
        return (CommissionEmployee) super.clone();
    }
}

