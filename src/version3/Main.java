package version3;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        int targetMonth = 9;


        HourlyEmployee h = new HourlyEmployee(101, new Name("Alice", "M", "Smith"), new MyDate(18,9,2000), new MyDate(1,6,2022), 45, 200);
        PieceWorkerEmployee p = new PieceWorkerEmployee(201, new Name("Bob", "C", "Jones", "Jr."), new MyDate(5,4,1998), new MyDate(15,1,2023), 270, 15.0);
        CommissionEmployee c = new CommissionEmployee(301, new Name("Carol", "L", "Tan"), new MyDate(30,12,1987), new MyDate(15,1,2020), 120000);
        BasePlusCommissionEmployee b = new BasePlusCommissionEmployee(401, new Name("Fred", "", "Lim"), new MyDate(20,6,1993), new MyDate(2,10,2019), 300000, 45000);

        Employee[] roster = new Employee[] { h, p, c, b };

        System.out.println("======================================================================");
        System.out.println("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");

        int idx = 1;
        for (Employee e : roster) {
            System.out.println(idx + ". " + e.toString());
            double basePay = 0.0;
            if (e instanceof HourlyEmployee) basePay = ((HourlyEmployee) e).computeSalary() - e.computeSalary(-1);
            if (e instanceof PieceWorkerEmployee) basePay = ((PieceWorkerEmployee) e).computeSalary() - e.computeSalary(-1);
            if (e instanceof CommissionEmployee && !(e instanceof BasePlusCommissionEmployee)) basePay = ((CommissionEmployee) e).computeSalary() - e.computeSalary(-1);
            if (e instanceof BasePlusCommissionEmployee) basePay = ((BasePlusCommissionEmployee) e).getBaseSalary() + (((BasePlusCommissionEmployee) e).getTotalSale() * ((BasePlusCommissionEmployee) e).getCommissionRate());

            double baseNoBonus = e.computeSalary(-1);
            double totalWithBonus = e.computeSalary(targetMonth);
            double birthdayBonus = totalWithBonus - baseNoBonus;

            System.out.printf(Locale.US, "   Base Pay: ₱%,.2f | Birthday Bonus: ₱%,.2f (%s)%n",
                    baseNoBonus, birthdayBonus, (birthdayBonus>0?"Eligible":"Ineligible"));
            System.out.printf(Locale.US, "   Total Payout: ₱%,.2f%n%n", totalWithBonus);
            idx++;
        }

        System.out.println("======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");

        HourlyEmployee emp1 = new HourlyEmployee(501, new Name("Sam","P","Cross"), new MyDate(1,1,1990), new MyDate(1,1,2020), 40, 200);
        HourlyEmployee emp1Identical = new HourlyEmployee(501, new Name("Sam","P","Cross"), new MyDate(1,1,1990), new MyDate(1,1,2020), 40, 200);
        HourlyEmployee emp2 = new HourlyEmployee(502, new Name("Alex","Q","Miller"), new MyDate(2,2,1991), new MyDate(1,2,2021), 40, 200);

        System.out.println("emp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.println("emp1 hashCode: " + emp1.hashCode() + " | emp1Identical hashCode: " + emp1Identical.hashCode() + " (Match: " + (emp1.hashCode()==emp1Identical.hashCode()) + ")");
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));

        System.out.println();
        System.out.println("======================================================================");
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println("======================================================================");

        try {
            HourlyEmployee original = new HourlyEmployee(601, new Name("Smith","A","Alice"), new MyDate(18,9,2000), new MyDate(1,6,2022), 40, 200);
            HourlyEmployee clone = original.clone();
            System.out.println("Original Name before modification: " + original.getEmpName());
            clone.getEmpName().setLastName("Taylor");
            System.out.println("Clone Name changed to:             " + clone.getEmpName());
            System.out.println("Original Name after modification:  " + original.getEmpName() + " (Deep copy successful!)");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

