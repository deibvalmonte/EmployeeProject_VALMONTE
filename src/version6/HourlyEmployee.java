package version6;

import java.util.Locale;

public class HourlyEmployee extends Employee implements Cloneable {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked < 0) {
            throw new IllegalArgumentException("Hours worked cannot be negative");
        }
        this.totalHoursWorked = totalHoursWorked;
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour < 0) {
            throw new IllegalArgumentException("Rate per hour cannot be negative");
        }
        this.ratePerHour = ratePerHour;
    }

    private double computeBasePay() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }
        double regularPay = 40 * ratePerHour;
        double overtimePay = (totalHoursWorked - 40) * ratePerHour * 1.5;
        return regularPay + overtimePay;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return computeBasePay() + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeSalary(0);
    }

    @Override
    public void displayEmployee() {
        System.out.printf(Locale.US, "HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f]%n",
                getEmpID(), getEmpName(), totalHoursWorked, ratePerHour, computeSalary());
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "HourlyEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}
