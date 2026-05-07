package org.example.service;

import org.example.model.Student;
import org.example.model.TuitionFeePayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeeRegistrationTest {

    private TuitionFeeRegistration service;
    private Student student;

    @BeforeEach
    void setUp() {
        service = new TuitionFeeRegistration();
        TuitionFeePayment payment = new TuitionFeePayment(5000.0);
        student = new Student("S103", "Aubrey Lacson", "IT");
    }

    @Test
    void testCalculateTuitionFee() {
        double result = service.calculateTuitionFee(3, 0);
        assertEquals(4050.0, result);
    }

    @Test
    void testCalculateTuitionWithDiscount() {
        double result = service.calculateTuitionFee(2, 0.10);
        assertEquals(2430.0, result);
    }

    @Test
    void testProcessPaymentUpdatesBalance() {
        service.processPayment(student, 2000.0);
        assertEquals(3000.0, service.checkBalance(student));
    }

    @Test
    void testFullPaymentCreditsUnits() {
        student.getTuitionDeets().setUnitsCompleted(0);

        service.processPayment(student, 5000.0);

        assertTrue(service.isPaymentComplete(student));
        assertEquals(3, student.getTuitionDeets().getUnitsCompleted());
    }

    @Test
    void testIsPaymentComplete() {
        assertFalse(service.isPaymentComplete(student));

        student.getTuitionDeets().setBalance(0);
        assertTrue(service.isPaymentComplete(student));
    }
}