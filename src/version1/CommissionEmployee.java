package version1;

import java.util.Locale;

public class CommissionEmployee {
    private int empID;
    private String empName;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalSale = 0;
    }

    public CommissionEmployee(int empID, String empName, double totalSale) {
        this.empID = empID;
        this.empName = empName;
        setTotalSale(totalSale);
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

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        if (totalSale >= 0) {
            this.totalSale = totalSale;
        }
    }

    public double computeSalary() {
        double commissionRate;

        if (totalSale < 50000) {
            commissionRate = 0.05;
        } else if (totalSale < 100000) {
            commissionRate = 0.10;
        } else if (totalSale < 500000) {
            commissionRate = 0.15;
        } else {
            commissionRate = 0.20;
        }

        return totalSale * commissionRate;
    }

    public void displayCommissionEmployee() {
        System.out.printf(Locale.US, "ID: %d | Name: %s | Total Sales: ₱%,.2f%n",
                empID, empName, totalSale);
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "CommissionEmployee [ID: %d, Name: %s, Total Sales: ₱%,.2f, Total Salary: ₱%,.2f]",
                empID, empName, totalSale, computeSalary());
    }
}
