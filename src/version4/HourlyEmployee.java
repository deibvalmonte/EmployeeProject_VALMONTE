package version4;

import java.util.Locale;
import java.util.Objects;

public class HourlyEmployee extends Employee implements Cloneable {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() { super(); this.totalHoursWorked = 0f; this.ratePerHour = 0.0; }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                          float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float totalHoursWorked) { if (totalHoursWorked < 0) throw new IllegalArgumentException("Hours cannot be negative"); this.totalHoursWorked = totalHoursWorked; }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double ratePerHour) { if (ratePerHour < 0) throw new IllegalArgumentException("Rate cannot be negative"); this.ratePerHour = ratePerHour; }

    private double computeBasePay() {
        if (totalHoursWorked <= 40) return totalHoursWorked * ratePerHour;
        double regular = 40 * ratePerHour;
        double overtime = (totalHoursWorked - 40) * ratePerHour * 1.5;
        return regular + overtime;
    }

    @Override
    public double computeSalary(int currentMonth) { return computeBasePay() + super.computeSalary(currentMonth); }

    @Override
    public double computeSalary() { return computeBasePay() + super.computeSalary(); }

    public void displayHourlyEmployee() {
        super.displayEmployee();
        System.out.printf(Locale.US, "   Hours: %.2f | Rate: ₱%,.2f/hr%n", totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "HourlyEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s] Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalHoursWorked, ratePerHour, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof HourlyEmployee)) return false;
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0
                && Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour); }

    @Override
    public HourlyEmployee clone() { HourlyEmployee copy = (HourlyEmployee) super.clone(); return copy; }
}

