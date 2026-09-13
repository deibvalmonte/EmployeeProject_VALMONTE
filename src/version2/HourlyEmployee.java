package version2;

import java.util.Locale;

public class HourlyEmployee {
    private version1.HourlyEmployee employee;
    private Name name;
    private MyDate birthDate;

    public HourlyEmployee() {
        this.employee = new version1.HourlyEmployee();
        this.name = new Name();
        this.birthDate = new MyDate();
    }

    public HourlyEmployee(int empID, Name name, MyDate birthDate, float totalHoursWorked, double ratePerHour) {
        this.employee = new version1.HourlyEmployee(empID, name.toString());
        this.name = name;
        this.birthDate = birthDate;
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public int getEmpID() {
        return employee.getEmpID();
    }

    public void setEmpID(int empID) {
        employee.setEmpID(empID);
    }

    public String getEmpName() {
        return employee.getEmpName();
    }

    public void setEmpName(String empName) {
        employee.setEmpName(empName);
        this.name = Name.fromFullName(empName);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
        employee.setEmpName(name.toString());
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public float getTotalHoursWorked() {
        return employee.getTotalHoursWorked();
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        employee.setTotalHoursWorked(totalHoursWorked);
    }

    public double getRatePerHour() {
        return employee.getRatePerHour();
    }

    public void setRatePerHour(double ratePerHour) {
        employee.setRatePerHour(ratePerHour);
    }

    public double computeSalary() {
        return employee.computeSalary();
    }

    public void displayHourlyEmployee() {
        System.out.printf(Locale.US, "ID: %d | Name: %s | BirthDate: %s | Hours: %.2f | Rate: ₱%,.2f/hr%n",
                employee.getEmpID(), name, birthDate, employee.getTotalHoursWorked(), employee.getRatePerHour());
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "HourlyEmployee [ID: %d, Name: %s, BirthDate: %s, Hours: %.2f, Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
                employee.getEmpID(), name, birthDate, employee.getTotalHoursWorked(), employee.getRatePerHour(), computeSalary());
    }
}
