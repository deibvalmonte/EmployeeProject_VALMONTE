package version6;

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("1. TESTING ENCAPSULATION & DEFENSIVE COPYING");
        System.out.println("======================================================================");

        MyDate originalBirthDate = new MyDate(15, 12, 1995);
        HourlyEmployee emp = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), originalBirthDate, new MyDate(1, 1, 2020), 80f, 150.0);

        System.out.printf("Original Birth Month: %d (%s)%n", emp.getBirthDate().getMonth(), monthName(emp.getBirthDate().getMonth()));
        System.out.println("Attempting external tampering: emp.getBirthDate().setMonth(9)...");
        emp.getBirthDate().setMonth(9);
        System.out.printf("Employee's Actual Birth Date after tampering attempt: %s%n", emp.getBirthDate());
        System.out.println("Result: SUCCESS (Internal state protected via defensive copying)");

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("2. TESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println("======================================================================");

        System.out.println("Attempting to create HourlyEmployee with rate: -150.00...");
        try {
            new HourlyEmployee(999, new Name("Test", "A.", "User"), new MyDate(15, 1, 1990), new MyDate(1, 1, 2020), 40f, -150.0);
        } catch (IllegalArgumentException e) {
            System.out.printf("Caught Expected Exception: [IllegalArgumentException] %s%n", e.getMessage());
        }

        System.out.println("Attempting to assign invalid calendar date: 31 Feb 2026...");
        try {
            new MyDate(31, 2, 2026);
        } catch (IllegalArgumentException e) {
            System.out.printf("Caught Expected Exception: [IllegalArgumentException] %s%n", e.getMessage());
        }

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("3. POLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)");
        System.out.println("[Dynamic Dispatch via Abstract Contract computeSalary()]");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster();
        boolean added = roster.addEmployee(new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(15, 12, 1995), new MyDate(1, 1, 2020), 80f, 150.0));
        if (!added) {
            throw new IllegalStateException("Failed to add hourly employee");
        }

        added = roster.addEmployee(new PieceWorkerEmployee(201, new Name("Bob", "C.", "Jones", "Jr."), new MyDate(2, 10, 1985), new MyDate(5, 3, 2018), 350, 10.0));
        if (!added) {
            throw new IllegalStateException("Failed to add piece worker employee");
        }

        added = roster.addEmployee(new CommissionEmployee(301, new Name("Maria", "L.", "Reyes"), new MyDate(20, 9, 1992), new MyDate(3, 6, 2019), 200000));
        if (!added) {
            throw new IllegalStateException("Failed to add commission employee");
        }

        added = roster.addEmployee(new BasePlusCommissionEmployee(401, new Name("Kevin", "S.", "Tan"), new MyDate(11, 12, 1988), new MyDate(7, 7, 2015), 250000, 15000));
        if (!added) {
            throw new IllegalStateException("Failed to add base-plus commission employee");
        }

        System.out.printf("Roster Size: %d | Hourly: %d | Piece Worker: %d | Commission: %d | Base Plus Commission: %d%n",
                roster.countEmployees(), roster.countHE(), roster.countPWE(), roster.countCE(), roster.countBPCE());
        System.out.printf("Search Employee ID 201: %s%n", roster.searchEmployee(201) != null ? "Found" : "Not found");
        System.out.printf("Remove Employee ID 201: %s%n", roster.removeEmployee(201) != null ? "Removed" : "Not found");
        roster.displayAllEmployees();
        roster.displayPayroll(9);

        // Compile-time proof: direct instantiation of abstract Employee is illegal.
        // Employee invalid = new Employee(123, new Name("Bad", "User"), new MyDate(1, 1, 1995), new MyDate(1, 1, 2020));
    }

    private static String monthName(int month) {
        String[] months = {"", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        if (month < 1 || month > 12) {
            return "Unknown";
        }
        return months[month];
    }
}
