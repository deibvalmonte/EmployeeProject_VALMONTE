package version2;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Name & Date Output Verification ---");
        Name sampleName = new Name("Alice", "M", "Smith");
        MyDate sampleDate = new MyDate(18, 9, 2026);

        System.out.print("Name: ");
        sampleName.displayName();
        System.out.print("Date: ");
        sampleDate.displayDate();
        System.out.println();

        System.out.println("--- Hourly Employee Payroll Test ---");
        HourlyEmployee hourly1 = new HourlyEmployee(101, new Name("Alice", "M", "Smith"),
                new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45, 200);
        HourlyEmployee hourly2 = new HourlyEmployee();
        hourly2.setEmpID(102);
        hourly2.setEmpName(new Name("Bob", "C", "Jones", "Jr."));
        hourly2.setBirthDate(new MyDate(14, 10, 1998));
        hourly2.setDateHired(new MyDate(20, 3, 2020));
        hourly2.setTotalHoursWorked(38);
        hourly2.setRatePerHour(180);

        System.out.println("[displayHourlyEmployee()]");
        hourly1.displayHourlyEmployee();
        System.out.println();
        System.out.println("[toString()]");
        System.out.println(hourly1);
        System.out.println();
        System.out.println("[Birthday Incentive Check]");
        System.out.printf(Locale.US, "Regular Month (Oct) Salary: ₱%,.2f%n", hourly1.computeSalary(10));
        System.out.printf(Locale.US, "Birth Month (Sep) Salary (+₱5,000.00): ₱%,.2f%n%n", hourly1.computeSalary(9));

        System.out.println("--- Piece Worker Payroll Test ---");
        PieceWorkerEmployee piece1 = new PieceWorkerEmployee(201, new Name("Mila", "Santos"),
                new MyDate(15, 3, 1995), new MyDate(5, 8, 2021), 320, 12.50);
        PieceWorkerEmployee piece2 = new PieceWorkerEmployee();
        piece2.setEmpID(202);
        piece2.setEmpName(new Name("Rene", "A", "Dela Cruz"));
        piece2.setBirthDate(new MyDate(22, 11, 1990));
        piece2.setDateHired(new MyDate(12, 2, 2023));
        piece2.setTotalPiecesFinished(250);
        piece2.setRatePerPiece(15.00);

        piece1.displayPieceWorkerEmployee();
        System.out.println(piece1);
        System.out.printf(Locale.US, "Regular Month (May) Salary: ₱%,.2f%n", piece1.computeSalary(5));
        System.out.printf(Locale.US, "Birth Month (Mar) Salary (+₱5,000.00): ₱%,.2f%n%n", piece1.computeSalary(3));

        System.out.println("--- Commission Employee Payroll Test ---");
        CommissionEmployee commission1 = new CommissionEmployee(301, new Name("Noel", "Tan"),
                new MyDate(30, 12, 1987), new MyDate(15, 1, 2020), 120000);
        CommissionEmployee commission2 = new CommissionEmployee();
        commission2.setEmpID(302);
        commission2.setEmpName(new Name("Ava", "L", "Garcia"));
        commission2.setBirthDate(new MyDate(8, 4, 1992));
        commission2.setDateHired(new MyDate(9, 7, 2021));
        commission2.setTotalSale(85000);

        commission1.displayCommissionEmployee();
        System.out.println(commission1);
        System.out.printf(Locale.US, "Regular Month (Jun) Salary: ₱%,.2f%n", commission1.computeSalary(6));
        System.out.printf(Locale.US, "Birth Month (Dec) Salary (+₱5,000.00): ₱%,.2f%n%n", commission1.computeSalary(12));

        System.out.println("--- Base Plus Commission Employee Payroll Test ---");
        BasePlusCommissionEmployee base1 = new BasePlusCommissionEmployee(401, new Name("Fred", "Lim"),
                new MyDate(20, 6, 1993), new MyDate(2, 10, 2019), 300000, 45000);
        BasePlusCommissionEmployee base2 = new BasePlusCommissionEmployee();
        base2.setEmpID(402);
        base2.setEmpName(new Name("Yara", "M", "Lopez"));
        base2.setBirthDate(new MyDate(5, 2, 1996));
        base2.setDateHired(new MyDate(11, 12, 2022));
        base2.setTotalSale(125000);
        base2.setBaseSalary(30000);

        base1.displayBasePlusCommissionEmployee();
        System.out.println(base1);
        System.out.printf(Locale.US, "Regular Month (May) Salary: ₱%,.2f%n", base1.computeSalary(5));
        System.out.printf(Locale.US, "Birth Month (Jun) Salary (+₱5,000.00): ₱%,.2f%n%n", base1.computeSalary(6));

        System.out.println("--- Additional Constructor/Setter Verification ---");
        System.out.println(hourly2);
        System.out.println(piece2);
        System.out.println(commission2);
        System.out.println(base2);
    }
}
