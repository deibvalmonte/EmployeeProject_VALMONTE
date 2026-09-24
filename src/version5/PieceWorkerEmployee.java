package version5;

import java.util.Locale;
import java.util.Objects;

public class PieceWorkerEmployee extends Employee implements Cloneable {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() { super(); this.totalPiecesFinished = 0; this.ratePerPiece = 0.0; }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int totalPiecesFinished) { if (totalPiecesFinished < 0) throw new IllegalArgumentException("Pieces cannot be negative"); this.totalPiecesFinished = totalPiecesFinished; }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double ratePerPiece) { if (ratePerPiece < 0) throw new IllegalArgumentException("Rate per piece cannot be negative"); this.ratePerPiece = ratePerPiece; }

    private double computeBasePay() {
        double base = totalPiecesFinished * ratePerPiece;
        double bonus = Math.floor(totalPiecesFinished / 100.0) * (10 * ratePerPiece);
        return base + bonus;
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = computeBasePay();
        if (getBirthDate() != null && currentMonth >= 1 && currentMonth <= 12 && getBirthDate().getMonth() == currentMonth) salary += 5000.0;
        return salary;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf(Locale.US, "PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, Rate: ₱%,.2f, Total Salary: ₱%,.2f]%n", getEmpID(), getEmpName(), totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public String toString() { return String.format(Locale.US, "PieceWorkerEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]", getEmpID(), getEmpName(), computeSalary()); }

    @Override
    public PieceWorkerEmployee clone() { return (PieceWorkerEmployee) super.clone(); }

    @Override
    public boolean equals(Object obj) { if (!super.equals(obj)) return false; if (!(obj instanceof PieceWorkerEmployee)) return false; PieceWorkerEmployee other = (PieceWorkerEmployee) obj; return this.totalPiecesFinished == other.totalPiecesFinished && Double.compare(this.ratePerPiece, other.ratePerPiece) == 0; }

    @Override
    public int hashCode() { return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece); }
}
