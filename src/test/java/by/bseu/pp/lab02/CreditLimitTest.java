package by.bseu.pp.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditLimitTest {

    @Test void totalBelowLimitIsAccepted() {
        assertTrue(OrderCalculator.isWithinCreditLimit(399.99, 400.0));
    }
    @Test void totalEqualToLimitIsAccepted() {
        assertTrue(OrderCalculator.isWithinCreditLimit(400.0, 400.0));
    }
    @Test void totalAboveLimitIsRejected() {
        assertFalse(OrderCalculator.isWithinCreditLimit(400.01, 400.0));
    }
    @Test void negativeCreditLimitIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.isWithinCreditLimit(100.0, -1.0));
    }
}
