package org.example.service;

import org.example.model.*;
import java.util.*;

public class TuitionFeeRegistration implements TuitionFeeReg{

    private final double PRICE_PER_UNIT = 1350.0;

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
    public void payNow(Student student, double amount) {
        double remainingBalance =student.getTuitionDeets().getBalance();
        student.getTuitionDeets().setBalance(remainingBalance - amount);

        System.out.println("==================================================");
        System.out.println("Transaction completed for: " + student.getPersonName());
        System.out.println("Remaining Balance: " + student.getTuitionDeets() + " Pesos");
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
