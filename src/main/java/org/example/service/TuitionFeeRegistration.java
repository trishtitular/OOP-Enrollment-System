package org.example.service;

import org.example.model.*;
import java.util.*;

public class TuitionFeeRegistration implements TuitionFeeReg{

    public static final double PRICE_PER_UNIT = 1350.0;

    public double getPRICE_PER_UNIT(){
        return PRICE_PER_UNIT;
    }

    @Override
    public double calculateTuitionFee(int courseUnits, double courseDiscounts){
        double total = courseUnits * PRICE_PER_UNIT;
        if (courseDiscounts != 0){
            total = total - (total * courseDiscounts);
        }
        return total;
    }

    @Override
    public void processPayment(Student student, double amount) {
        double remainingBalance =student.getTuitionDeets().getBalance();
        student.getTuitionDeets().setBalance(remainingBalance - amount);

        System.out.println("==================================================");
        System.out.println("Transaction completed for: " + student.getPersonName());
        System.out.println("Remaining Balance: " + student.getTuitionDeets() + " Pesos");

        if (student.getTuitionDeets().getBalance() <= 0){
            int currentUnits = student.getTuitionDeets().getUnitsCompleted();
            student.getTuitionDeets().setUnitsCompleted(currentUnits + 3);

            System.out.println("STATUS: Payment Accredited. 3 units credited to record");
        }
        System.out.println("==================================================");
    }

    @Override
    public double checkBalance(Student student) {
        return student.getTuitionDeets().getBalance();
    }

    @Override
    public boolean isPaymentComplete(Student student) {
        double balance = student.getTuitionDeets().getBalance();
        return (balance <= 0) ? true : false;
    }
}
