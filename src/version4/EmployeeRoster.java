package version4;

import java.util.Locale;

public class EmployeeRoster {
    private final Employee[] empList;
    private final int max;
    private int count;

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
                    empList[j] = empList[j + 1];
                }
                empList[count - 1] = null;
                count--;
                return removed;
            }
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

    public void displayAllEmployees() {
        System.out.println();
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            System.out.printf(Locale.US, "%d. ID: %d | Name: %s | Type: %s%n", i + 1, e.getEmpID(), e.getEmpName(), e.getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        System.out.println();
        System.out.printf(Locale.US, "======================================================================%n");
        System.out.printf(Locale.US, "ROSTER PAYROLL REPORT (Target Month: %s)%n", monthName(currentMonth));
        System.out.printf(Locale.US, "======================================================================%n");
        for (int i = 0; i < count; i++) {
            Employee e = empList[i];
            double salary;
            String label;

            switch (e) {
                case BasePlusCommissionEmployee bp -> {
                    salary = bp.computeSalary(currentMonth);
                    label = "[Base Plus Commission]";
                }
                case CommissionEmployee ce -> {
                    salary = ce.computeSalary(currentMonth);
                    label = "[Commission]";
                }
                case PieceWorkerEmployee p -> {
                    salary = p.computeSalary(currentMonth);
                    label = "[Piece Worker]";
                }
                case HourlyEmployee h -> {
                    salary = h.computeSalary(currentMonth);
                    label = "[Hourly]";
                }
                default -> {
                    continue;
                }
            }

            boolean birthday = e.getBirthDate() != null && e.getBirthDate().getMonth() == currentMonth;
            System.out.printf(Locale.US, "%s ID: %d | Name: %s | Salary: ₱%,.2f%s%n",
                    label, e.getEmpID(), e.getEmpName(), salary, (birthday ? " (Birthday Bonus Applied)" : ""));
        }
    }

    private String monthName(int month) {
        String[] names = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        if (month < 1 || month > 12) return "Unknown";
        return names[month];
    }

    public int getMax() { return max; }
    public int getCount() { return count; }
}


