package version4;

import java.util.Locale;
import java.util.Objects;

public class Employee implements Cloneable {
    private int empID;
    private version4.Name empName;
    private version4.MyDate birthDate;
    private version4.MyDate dateHired;

    public Employee() {
        this(0, new version4.Name(), new version4.MyDate(), new version4.MyDate());
    }

    public Employee(int empID, version4.Name empName, version4.MyDate birthDate, version4.MyDate dateHired) {
        setEmpID(empID);
        setEmpName(empName);
        setBirthDate(birthDate);
        setDateHired(dateHired);
    }

    public int getEmpID() { return empID; }
    public void setEmpID(int empID) { this.empID = empID; }

    public version4.Name getEmpName() { return empName; }
    public void setEmpName(version4.Name empName) { this.empName = empName == null ? new version4.Name() : empName; }

    public version4.MyDate getBirthDate() { return birthDate; }
    public void setBirthDate(version4.MyDate birthDate) { this.birthDate = birthDate == null ? new version4.MyDate() : birthDate; }

    public version4.MyDate getDateHired() { return dateHired; }
    public void setDateHired(version4.MyDate dateHired) { this.dateHired = dateHired == null ? new version4.MyDate() : dateHired; }

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

