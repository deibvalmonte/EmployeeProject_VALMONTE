package version2;

public class Main {
    public static void main(String[] args) {
        Name name1 = new Name("Dave", "L", "Valmonte", "ll");
        MyDate date1 = new MyDate(8, 9, 2026);

        HourlyEmployee hourly = new HourlyEmployee(101, name1, date1, 45, 200);
        System.out.println("Name: " + name1);
        System.out.println("Birth Date: " + date1);
        System.out.println(hourly);
        System.out.println();

        Name name2 = new Name("Mila", null, "Santos");
        MyDate date2 = new MyDate(15, 3, 1995);

        PieceWorkerEmployee piece = new PieceWorkerEmployee(202, name2, date2, 320, 12.5);
        System.out.println("Name: " + name2);
        System.out.println("Birth Date: " + date2);
        System.out.println(piece);
        System.out.println();

        Name name3 = new Name("Noel", null, "Tan");
        MyDate date3 = new MyDate(30, 12, 1987);

        CommissionEmployee commission = new CommissionEmployee(302, name3, date3, 75000);
        System.out.println("Name: " + name3);
        System.out.println("Birth Date: " + date3);
        System.out.println(commission);
        System.out.println();

        Name name4 = new Name("Fred", null, "Lim");
        MyDate date4 = new MyDate(20, 6, 1993);

        BasePlusCommissionEmployee basePlus = new BasePlusCommissionEmployee(402, name4, date4, 90000, 30000);
        System.out.println("Name: " + name4);
        System.out.println("Birth Date: " + date4);
        System.out.println(basePlus);
    }
}
