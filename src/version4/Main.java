package version4;

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster(6);

        HourlyEmployee h1 = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(15,9,1990), new MyDate(1,1,2020), 80f, 100.0);
        PieceWorkerEmployee p1 = new PieceWorkerEmployee(201, new Name("Bob", "C.", "Jones", "Jr."), new MyDate(2,10,1985), new MyDate(5,3,2018), 350, 10.0);
        CommissionEmployee c1 = new CommissionEmployee(301, new Name("Maria", "L.", "Reyes"), new MyDate(20,9,1992), new MyDate(3,6,2019), 200000);
        BasePlusCommissionEmployee b1 = new BasePlusCommissionEmployee(401, new Name("Kevin", "S.", "Tan"), new MyDate(11,12,1988), new MyDate(7,7,2015), 250000, 15000);
        HourlyEmployee h2 = new HourlyEmployee(102, new Name("David", "A.", "White"), new MyDate(1,1,1995), new MyDate(2,2,2021), 40f, 200.0);
        HourlyEmployee extra = new HourlyEmployee(103, new Name("Overflow", "X", "User"), new MyDate(1,1,1980), new MyDate(1,1,2010), 10f, 50.0);

        System.out.printf("Added: %s -> %s\n", h1.getEmpName(), roster.addEmployee(h1) ? "Success" : "Failed");
        System.out.printf("Added: %s -> %s\n", p1.getEmpName(), roster.addEmployee(p1) ? "Success" : "Failed");
        System.out.printf("Added: %s -> %s\n", c1.getEmpName(), roster.addEmployee(c1) ? "Success" : "Failed");
        System.out.printf("Added: %s -> %s\n", b1.getEmpName(), roster.addEmployee(b1) ? "Success" : "Failed");
        System.out.printf("Added: %s -> %s\n", h2.getEmpName(), roster.addEmployee(h2) ? "Success" : "Failed");

        System.out.println();
        System.out.printf("Attempting to add beyond capacity (1 slot left): %s\n", roster.addEmployee(extra) ? "Success" : "Failed");

        System.out.println();
        System.out.println("--- ROSTER COMPOSITION COUNTS ---");
        System.out.printf("Total Employees: %d / %d%n", roster.getCount(), roster.getMax());
        System.out.printf("Hourly Employees: %d%n", roster.countHE());
        System.out.printf("Piece Worker Employees: %d%n", roster.countPWE());
        System.out.printf("Commission Employees (Pure): %d%n", roster.countCE());
        System.out.printf("Base Plus Commission Employees: %d%n", roster.countBPCE());

        roster.displayPayroll(9);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");

        System.out.printf("Removing Employee ID 201 (Jones, Bob C. Jr.)... ");
        Employee removed = roster.removeEmployee(201);
        System.out.printf("%s\n", removed != null ? "Successfully removed." : "Not found.");
        System.out.printf("Current Employee Count: %d\n", roster.getCount());

        System.out.println();
        System.out.println("Remaining Employees in Roster:");
        roster.displayAllEmployees();
    }
}

