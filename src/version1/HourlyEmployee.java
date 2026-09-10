package version1;

import java.util.Locale;

public class HourlyEmployee {
    private int empID;
    private String empName;
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int empID, String empName, float totalHoursWorked, double ratePerHour) {
        this.empID = empID;
        this.empName = empName;
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        if (totalHoursWorked >= 0) {
            this.totalHoursWorked = totalHoursWorked;
        }
    }

    public double getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(double ratePerHour) {
        if (ratePerHour >= 0) {
            this.ratePerHour = ratePerHour;
        }
    }

    public double computeSalary() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        }

        double regularPay = 40 * ratePerHour;
        double overtimePay = (totalHoursWorked - 40) * ratePerHour * 1.5;
        return regularPay + overtimePay;
    }

    public void displayHourlyEmployee() {
        System.out.printf(Locale.US, "ID: %d | Name: %s | Hours: %.2f | Rate: ₱%,.2f/hr%n",
                empID, empName, totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "HourlyEmployee [ID: %d, Name: %s, Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
                empID, empName, totalHoursWorked, ratePerHour, computeSalary());
    }
}
