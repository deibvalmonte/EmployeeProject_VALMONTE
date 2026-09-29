package version6;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class EmployeeRoster {
    private final List<Employee> empList;

    @SuppressWarnings("this-escape")

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            throw new NullPointerException("Employee cannot be null");
        }
        return empList.add(emp);
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return empList.remove(i);
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (Employee employee : empList) {
            if (employee.getEmpID() == empID) {
                return employee;
            }
        }
        return null;
    }

    public int countEmployees() {
        return empList.size();
    }

    public int countHE() {
        int count = 0;
        for (Employee employee : empList) {
            if (employee instanceof HourlyEmployee) {
                count++;
            }
        }
        return count;
    }

    public int countPWE() {
        int count = 0;
        for (Employee employee : empList) {
            if (employee instanceof PieceWorkerEmployee) {
                count++;
            }
        }
        return count;
    }

    public int countCE() {
        int count = 0;
        for (Employee employee : empList) {
            if (employee instanceof CommissionEmployee && !(employee instanceof BasePlusCommissionEmployee)) {
                count++;
            }
        }
        return count;
    }

    public int countBPCE() {
        int count = 0;
        for (Employee employee : empList) {
            if (employee instanceof BasePlusCommissionEmployee) {
                count++;
            }
        }
        return count;
    }

    public void displayAllEmployees() {
        int index = 1;
        for (Employee employee : empList) {
            System.out.printf(Locale.US, "%d. %s%n", index++, employee);
        }
    }

    public void displayPayroll(int currentMonth) {
        for (Employee employee : empList) {
            double salary = employee.computeSalary(currentMonth);
            String bonusLabel = employee.getBirthDate().getMonth() == currentMonth ? " (Bonus Applied)" : "";
            System.out.printf(Locale.US, "ID: %d | Name: %s | Payout: ₱%,.2f%s%n",
                    employee.getEmpID(), employee.getEmpName(), salary, bonusLabel);
        }
    }

    private String monthName(int month) {
        String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        if (month < 1 || month > 12) {
            return "Unknown";
        }
        return months[month];
    }
}
