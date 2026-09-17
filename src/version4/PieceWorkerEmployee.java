package version4;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        if (totalPiecesFinished >= 0) {
            this.totalPiecesFinished = totalPiecesFinished;
        }
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        if (ratePerPiece >= 0.0) {
            this.ratePerPiece = ratePerPiece;
        }
    }

    public double computeSalary(int currentMonth) {
        double basePay = (totalPiecesFinished * ratePerPiece) + ((totalPiecesFinished / 100) * 10 * ratePerPiece);
        if (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) {
            basePay += 5000.00;
        }
        return basePay;
    }

    public double computeSalary() {
        return computeSalary(-1);
    }

    public void displayPieceWorkerEmployee() {
        displayEmployee();
        System.out.printf("Pieces: %d | Rate: ₱%,.2f/piece%n", totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("%s, Pieces: %d, Rate: ₱%,.2f, Total Salary: ₱%,.2f",
                super.toString(), totalPiecesFinished, ratePerPiece, computeSalary());
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        PieceWorkerEmployee that = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == that.totalPiecesFinished &&
                Double.compare(that.ratePerPiece, ratePerPiece) == 0;
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
