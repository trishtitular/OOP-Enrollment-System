package org.example.service;

import org.example.model.*;

public interface TuitionFeeReg {
    double calculateTuitionFee(int courseUnits, double courseDiscounts);
    void processPayment(Student student, double amount);
    double checkBalance(Student student);
    boolean isPaymentComplete (Student student);
}
