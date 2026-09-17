package version4;

import java.util.Objects;

public class HourlyEmployee extends Employee {
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
        if (totalHoursWorked >= 0.0f) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0.0) {
            this.ratePerHour = ratePerHour;
        }
    }

    public double computeSalary(int currentMonth) {
        double basePay = (totalHoursWorked <= 40.0f)
                ? totalHoursWorked * ratePerHour
                : (40.0 * ratePerHour) + ((totalHoursWorked - 40.0) * ratePerHour * 1.5);
        if (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) {
            basePay += 5000.00;
        }
        return basePay;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    public void displayHourlyEmployee() {
        displayEmployee();
        System.out.printf("Hours: %.2f | Rate: ₱%,.2f/hr%n", totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("%s, Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f",
                super.toString(), totalHoursWorked, ratePerHour, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        HourlyEmployee that = (HourlyEmployee) obj;
        return Float.compare(that.totalHoursWorked, totalHoursWorked) == 0 &&
                Double.compare(that.ratePerHour, ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public HourlyEmployee clone() {
        return (HourlyEmployee) super.clone();
    }
}
