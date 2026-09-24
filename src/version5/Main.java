package version5;

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");

        EmployeeRoster roster = new EmployeeRoster();

        HourlyEmployee h1 = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(15,9,1990), new MyDate(1,1,2020), 80f, 100.0);
        PieceWorkerEmployee p1 = new PieceWorkerEmployee(201, new Name("Bob", "C.", "Jones", "Jr."), new MyDate(2,10,1985), new MyDate(5,3,2018), 350, 10.0);
        CommissionEmployee c1 = new CommissionEmployee(301, new Name("Maria", "L.", "Reyes"), new MyDate(20,9,1992), new MyDate(3,6,2019), 200000);
        BasePlusCommissionEmployee b1 = new BasePlusCommissionEmployee(401, new Name("Kevin", "S.", "Tan"), new MyDate(11,12,1988), new MyDate(7,7,2015), 250000, 15000);

        System.out.printf("Enrolled: %s (Hourly)%n", h1.getEmpName()); roster.addEmployee(h1);
        System.out.printf("Enrolled: %s (Piece Worker)%n", p1.getEmpName()); roster.addEmployee(p1);
        System.out.printf("Enrolled: %s (Commission)%n", c1.getEmpName()); roster.addEmployee(c1);
        System.out.printf("Enrolled: %s (Base Plus Commission)%n", b1.getEmpName()); roster.addEmployee(b1);

        System.out.println();
        System.out.printf("Total Roster Size: %d employees%n", roster.countEmployees());

        roster.displayPayroll(9);

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");
        System.out.printf("Removing Employee ID 201... ");
        Employee removed = roster.removeEmployee(201);
        System.out.printf("%s%n", removed != null ? "Successfully removed." : "Not found.");
        System.out.printf("Updated Roster Size: %d%n", roster.countEmployees());

        System.out.println();
        System.out.println("Current Active Employees:");
        roster.displayAllEmployees();
    }
}
