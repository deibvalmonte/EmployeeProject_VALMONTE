package version3;

import java.util.Locale;
import java.util.Objects;

public class PieceWorkerEmployee extends Employee implements Cloneable {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired,
                               int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished < 0) throw new IllegalArgumentException("Pieces cannot be negative");
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece < 0) throw new IllegalArgumentException("Rate per piece cannot be negative");
        this.ratePerPiece = ratePerPiece;
    }

    private double computeBasePay() {
        double base = totalPiecesFinished * ratePerPiece;
        double bonus = Math.floor(totalPiecesFinished / 100.0) * (10 * ratePerPiece);
        return base + bonus;
    }

    @Override
    public double computeSalary(int currentMonth) {
        return computeBasePay() + super.computeSalary(currentMonth);
    }

    @Override
    public double computeSalary() {
        return computeBasePay() + super.computeSalary();
    }

    public void displayPieceWorkerEmployee() {
        super.displayEmployee();
        System.out.printf(Locale.US, "   Pieces: %d | Rate/Piece: ₱%,.2f%n", totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format(Locale.US,
                "PieceWorkerEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s] Pieces: %d, Rate: ₱%,.2f, Total Salary: ₱%,.2f",
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof PieceWorkerEmployee)) return false;
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return this.totalPiecesFinished == other.totalPiecesFinished
                && Double.compare(this.ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public PieceWorkerEmployee clone() {
        return (PieceWorkerEmployee) super.clone();
    }
}

