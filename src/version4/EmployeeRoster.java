package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this(10);
    }

    public EmployeeRoster(int max) {
        this.max = (max > 0) ? max : 10;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public Employee[] getEmpList() {
        return empList;
    }

    public int getMax() {
        return max;
    }

    public int getCount() {
        return count;
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }
        empList[count] = emp;
        count++;
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

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }
        return null;
    }

    public int countHE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countPWE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                total++;
            }
        }
        return total;
    }

    public int countCE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)) {
                total++;
            }
        }
        return total;
    }

    public int countBPCE() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                total++;
            }
        }
        return total;
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
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) empList[i];
                pwe.displayPieceWorkerEmployee();
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
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) empList[i];
                bpce.displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.printf("%d. ID: %d | Name: %-15s | Type: %s%n",
                    i + 1, empList[i].getEmpID(), empList[i].getEmpName(), empList[i].getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee emp = empList[i];
            double salary = 0.0;
            String type = "";

            if (emp instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) emp;
                salary = he.computeSalary(currentMonth);
                type = "Hourly";
            } else if (emp instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) emp;
                salary = pwe.computeSalary(currentMonth);
                type = "Piece Worker";
            } else if (emp instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) emp;
                salary = bpce.computeSalary(currentMonth);
                type = "Base Plus Commission";
            } else if (emp instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) emp;
                salary = ce.computeSalary(currentMonth);
                type = "Commission";
            }

            boolean bonusApplied = (emp.getBirthDate() != null && emp.getBirthDate().getMonth() == currentMonth);
            String bonusText = bonusApplied ? " (Birthday Bonus Applied)" : "";

            System.out.printf("[%s] ID: %d | Name: %s | Salary: ₱%,.2f%s%n",
                    type, emp.getEmpID(), emp.getEmpName(), salary, bonusText);
        }
    }
}
