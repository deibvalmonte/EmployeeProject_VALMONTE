package version4;

import java.util.Locale;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {
        this.max = Math.max(1, max);
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) return false;
        if (count >= max) return false;
        empList[count++] = emp;
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                Employee removed = empList[i];

                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j+1];
                }
                empList[count-1] = null;
                count--;
                return removed;
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) return empList[i];
        }
        return null;
    }

    public int countHE() {
        int c = 0;
        for (int i = 0; i < count; i++) if (empList[i] instanceof HourlyEmployee) c++;
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (int i = 0; i < count; i++) if (empList[i] instanceof PieceWorkerEmployee) c++;
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (int i = 0; i < count; i++) if (empList[i] instanceof BasePlusCommissionEmployee) c++;
        return c;
    }

    public int countCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {

            if (empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)) c++;
        }
        return c;
    }

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) empList[i];
                he.displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee p = (PieceWorkerEmployee) empList[i];
                p.displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)) {
                CommissionEmployee ce = (CommissionEmployee) empList[i];
                ce.displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bp = (BasePlusCommissionEmployee) empList[i];
                bp.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        System.out.println();
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            System.out.printf(Locale.US, "%d. ID: %d | Name: %s | Type: %s%n", i+1, e.getEmpID(), e.getEmpName(), e.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        System.out.println();
        System.out.printf(Locale.US, "======================================================================%n");
        System.out.printf(Locale.US, "ROSTER PAYROLL REPORT (Target Month: %s)%n", monthName(currentMonth));
        System.out.printf(Locale.US, "======================================================================%n");
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            double salary = 0.0;
            String label = "";
            if (e instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bp = (BasePlusCommissionEmployee) e;
                salary = bp.computeSalary(currentMonth);
                label = "[Base Plus Commission]";
            } else if (e instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) e;
                salary = ce.computeSalary(currentMonth);
                label = "[Commission]";
            } else if (e instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee p = (PieceWorkerEmployee) e;
                salary = p.computeSalary(currentMonth);
                label = "[Piece Worker]";
            } else if (e instanceof HourlyEmployee) {
                HourlyEmployee h = (HourlyEmployee) e;
                salary = h.computeSalary(currentMonth);
                label = "[Hourly]";
            } else {

                continue;
            }
            boolean birthday = e.getBirthDate() != null && e.getBirthDate().getMonth() == currentMonth && e.computeSalary(currentMonth) - e.computeSalary() >= 5000.0;
            System.out.printf(Locale.US, "%s ID: %d | Name: %s | Salary: ₱%,.2f%s%n",
                    label, e.getEmpID(), e.getEmpName(), salary, (birthday ? " (Birthday Bonus Applied)" : ""));
        }
    }

    private String monthName(int month) {
        String[] names = {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        if (month < 1 || month > 12) return "Unknown";
        return names[month];
    }

    public int getMax() { return max; }
    public int getCount() { return count; }
}


