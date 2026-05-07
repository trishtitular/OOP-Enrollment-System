package org.example.model;

public class TuitionFeePayment {
    private double balance;
    private double totalTuitionFee;
    private int unitsCompleted;

    public TuitionFeePayment(double balance){
        this.balance = balance;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance (double balance){
        this.balance = balance;
    }

    public double getTotalTuitionFee() {
        return totalTuitionFee;
    }

    public void setTotalTuitionFee(double totalTuitionFee) {
        this.totalTuitionFee = totalTuitionFee;
    }

    public int getUnitsCompleted() {
        return unitsCompleted;
    }

    public void setUnitsCompleted(int unitsCompleted) {
        this.unitsCompleted = unitsCompleted;
    }
    @Override
    public String toString(){
        return String.format("Peso %.2f", balance);
    }
}
