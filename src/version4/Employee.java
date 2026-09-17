package version4;

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

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        if (empID > 0) {
            this.empID = empID;
        }
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = (empName != null) ? empName : new Name();
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = (birthDate != null) ? birthDate : new MyDate();
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = (dateHired != null) ? dateHired : new MyDate();
    }

    public void displayEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s%n",
                empID, empName, birthDate, dateHired);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Name: %s, DOB: %s, Hired: %s",
                empID, empName, birthDate, dateHired);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return empID == employee.empID &&
                Objects.equals(empName, employee.empName) &&
                Objects.equals(birthDate, employee.birthDate) &&
                Objects.equals(dateHired, employee.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    @Override
    public Employee clone() {
        try {
            Employee copy = (Employee) super.clone();
            copy.empName = (this.empName != null) ? this.empName.clone() : null;
            copy.birthDate = (this.birthDate != null) ? this.birthDate.clone() : null;
            copy.dateHired = (this.dateHired != null) ? this.dateHired.clone() : null;
            return copy;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
