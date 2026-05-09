package org.example.service;

import org.example.model.TuitionFeePayment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TuitionFeePaymentTest {

    private TuitionFeePayment payment;

    @BeforeEach
    void setUp() {

        payment = new TuitionFeePayment(10000.00);
    }

    @Test
    @DisplayName("Should correctly initialize balance via constructor")
    void testConstructorAndGetBalance() {
        assertNotNull(payment, "Payment object should not be null");
        assertEquals(10000.00, payment.getBalance(), "Initial balance should match 10000.00");
    }

    @Test

    void testSetBalance() {
        payment.setBalance(5500.50);
        assertEquals(5500.50, payment.getBalance());
    }

    @Test

    void testUnitsCompletedLogic() {
        payment.setUnitsCompleted(15);
        assertEquals(15, payment.getUnitsCompleted());

        int current = payment.getUnitsCompleted();
        payment.setUnitsCompleted(current + 3);
        assertEquals(18, payment.getUnitsCompleted());
    }

    @Test

    void testToStringFormatting() {
        payment.setBalance(1234.56);
        String result = payment.toString();

        assertEquals("Peso 1234.56", result, "toString formatting should match 'Peso 1234.56'");
    }

    @Test

    void testTotalTuitionFee() {
        payment.setTotalTuitionFee(50000.00);
        assertEquals(50000.00, payment.getTotalTuitionFee());
    }
}