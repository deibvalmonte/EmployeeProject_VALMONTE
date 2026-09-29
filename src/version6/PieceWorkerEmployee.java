package version6;

import java.util.Locale;

public class PieceWorkerEmployee extends Employee implements Cloneable {
    private int totalPiecesFinished;
    private double ratePerPiece;

    @SuppressWarnings("this-escape")

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    @SuppressWarnings("this-escape")

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) {
            throw new IllegalArgumentException("Pieces finished cannot be negative");
        }
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) {
            throw new IllegalArgumentException("Rate per piece cannot be negative");
        }
        this.ratePerPiece = ratePerPiece;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double basePay = totalPiecesFinished * ratePerPiece;
        double bonusUnits = Math.floor(totalPiecesFinished / 100.0) * 10 * ratePerPiece;
        return basePay + bonusUnits + getBirthdayBonus(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeSalary(0);
    }

    @Override
    public void displayEmployee() {
        System.out.printf(Locale.US, "PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, Rate: ₱%,.2f, Total Salary: ₱%,.2f]%n",
                getEmpID(), getEmpName(), totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "PieceWorkerEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]",
                getEmpID(), getEmpName(), computeSalary());
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}
