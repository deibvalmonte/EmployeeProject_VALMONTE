package version3;

import java.util.Locale;
import java.util.Objects;

public class Employee implements Cloneable {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this(0, new Name(), new MyDate(), new MyDate());
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        setEmpID(empID);
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public Name getEmpName() { return empName; }
    public void setEmpName(Name empName) { this.empName = empName == null ? new Name() : empName; }

    public MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(MyDate birthDate) { this.birthDate = birthDate == null ? new MyDate() : birthDate; }

    public MyDate getDateHired() { return dateHired; }
    public void setDateHired(MyDate dateHired) { this.dateHired = dateHired == null ? new MyDate() : dateHired; }

    /**
     * Base computeSalary returns only birthday bonus; subclasses must add their own base pay and call super to include bonus.
     */
    public double computeSalary(int currentMonth) {
        double bonus = 0.0;
        if (birthDate != null && birthDate.getMonth() == currentMonth) {
            bonus = 5000.00;
        }
        return bonus;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    public void displayEmployee() {
        System.out.printf(Locale.US, "[ID: %d, Name: %s, DOB: %s, Hired: %s]", empID, empName, birthDate, dateHired);
        System.out.println();
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Employee [ID: %d, Name: %s, DOB: %s, Hired: %s]", empID, empName, birthDate, dateHired);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Employee)) return false;
        Employee other = (Employee) obj;
        return this.empID == other.empID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID);
    }

    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.empName = this.empName == null ? null : this.empName.clone();
            copy.birthDate = this.birthDate == null ? null : this.birthDate.clone();
            copy.dateHired = this.dateHired == null ? null : this.dateHired.clone();
            return copy;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
