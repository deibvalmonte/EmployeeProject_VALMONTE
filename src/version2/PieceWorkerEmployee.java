package version2;

import java.util.Locale;

public class PieceWorkerEmployee {
    private version1.PieceWorkerEmployee employee;
    private Name name;
    private MyDate birthDate;

    public PieceWorkerEmployee() {
        this.employee = new version1.PieceWorkerEmployee();
        this.name = new Name();
        this.birthDate = new MyDate();
    }

    public PieceWorkerEmployee(int empID, Name name, MyDate birthDate, int totalPiecesFinished, double ratePerPiece) {
        this.employee = new version1.PieceWorkerEmployee(empID, name.toString());
        this.name = name;
        this.birthDate = birthDate;
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getEmpID() {
        return employee.getEmpID();
    }

    public void setEmpID(int empID) {
        employee.setEmpID(empID);
    }

    public String getEmpName() {
        return employee.getEmpName();
    }

    public void setEmpName(String empName) {
        employee.setEmpName(empName);
        this.name = Name.fromFullName(empName);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
        employee.setEmpName(name.toString());
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getTotalPiecesFinished() {
        return employee.getTotalPiecesFinished();
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        employee.setTotalPiecesFinished(totalPiecesFinished);
    }

    public double getRatePerPiece() {
        return employee.getRatePerPiece();
    }

    public void setRatePerPiece(double ratePerPiece) {
        employee.setRatePerPiece(ratePerPiece);
    }

    public double computeSalary() {
        return employee.computeSalary();
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf(Locale.US, "ID: %d | Name: %s | BirthDate: %s | Pieces Finished: %d | Rate/Piece: ₱%,.2f%n",
                employee.getEmpID(), name, birthDate, employee.getTotalPiecesFinished(), employee.getRatePerPiece());
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "PieceWorkerEmployee [ID: %d, Name: %s, BirthDate: %s, Pieces: %d, Rate: ₱%,.2f, Total Salary: ₱%,.2f]",
                employee.getEmpID(), name, birthDate, employee.getTotalPiecesFinished(), employee.getRatePerPiece(), computeSalary());
    }
}
