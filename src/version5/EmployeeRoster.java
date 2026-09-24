package version5;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmployeeRoster {
    private List<Employee> empList;

    public EmployeeRoster() { this.empList = new ArrayList<>(); }

    public EmployeeRoster(int initialCapacity) { this.empList = new ArrayList<>(Math.max(1, initialCapacity)); }

    public boolean addEmployee(Employee emp) {
        if (emp == null) return false;
        empList.add(emp);
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) return empList.remove(i);
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee e : empList) if (e.getEmpID() == empID) return e;
        return null;
    }

    public int countEmployees() { return empList.size(); }

    public int countHE() { int c = 0; for (Employee e : empList) if (e instanceof HourlyEmployee) c++; return c; }
    public int countPWE() { int c = 0; for (Employee e : empList) if (e instanceof PieceWorkerEmployee) c++; return c; }
    public int countBPCE() { int c = 0; for (Employee e : empList) if (e instanceof BasePlusCommissionEmployee) c++; return c; }
    public int countCE() { int c = 0; for (Employee e : empList) if (e instanceof CommissionEmployee && !(e instanceof BasePlusCommissionEmployee)) c++; return c; }

    public void displayAllEmployees() {
        int idx = 1;
        for (Employee e : empList) {
            System.out.printf(Locale.US, "%d. %s%n", idx++, e.toString());
        }
    }

    public void displayPayroll(int currentMonth) {
        System.out.println();
        System.out.printf(Locale.US, "======================================================================%n");
        System.out.printf(Locale.US, "PURE POLYMORPHIC PAYROLL REPORT (Target Month: %s)%n", monthName(currentMonth));
        System.out.printf(Locale.US, "======================================================================%n");
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            boolean birthday = emp.getBirthDate() != null && emp.getBirthDate().getMonth() == currentMonth;
            System.out.printf(Locale.US, "ID: %d | Name: %s | Payout: ₱%,.2f%s%n", emp.getEmpID(), emp.getEmpName(), salary, (birthday ? " (Birthday Bonus Applied)" : ""));
        }
    }

    private String monthName(int month) { String[] names = {"","Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"}; if (month < 1 || month > 12) return "Unknown"; return names[month]; }
}
