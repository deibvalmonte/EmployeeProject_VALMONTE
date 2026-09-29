package version6;

public abstract class Employee implements Cloneable {
    private final int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    protected Employee() {
        this(0, new Name("N/A", "N/A"), new MyDate(1, 1, 2000), new MyDate(1, 1, 2000));
    }

    protected Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        if (empName == null) {
            throw new NullPointerException("Employee name cannot be null");
        }
        if (birthDate == null) {
            throw new NullPointerException("Employee birth date cannot be null");
        }
        if (dateHired == null) {
            throw new NullPointerException("Employee hire date cannot be null");
        }

        this.empID = empID;
        this.empName = empName.clone();
        this.birthDate = birthDate.clone();
        this.dateHired = dateHired.clone();
    }

    public final int getEmpID() {
        return empID;
    }

    public Name getEmpName() {
        return empName.clone();
    }

    public void setEmpName(Name empName) {
        if (empName == null) {
            throw new NullPointerException("Employee name cannot be null");
        }
        this.empName = empName.clone();
    }

    public MyDate getBirthDate() {
        return birthDate.clone();
    }

    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) {
            throw new NullPointerException("Employee birth date cannot be null");
        }
        this.birthDate = birthDate.clone();
    }

    public MyDate getDateHired() {
        return dateHired.clone();
    }

    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) {
            throw new NullPointerException("Employee hire date cannot be null");
        }
        this.dateHired = dateHired.clone();
    }

    public final double getBirthdayBonus(int currentMonth) {
        if (birthDate != null && birthDate.getMonth() == currentMonth) {
            return 5000.0;
        }
        return 0.0;
    }

    public abstract double computeSalary(int currentMonth);

    public abstract double computeSalary();

    public abstract void displayEmployee();

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
