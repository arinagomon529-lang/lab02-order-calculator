package by.bseu.pp.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {
    private static final double EPS = 1e-9;

    @Test void zeroDiscountDoesNotChangeSubtotal() {
        assertEquals(100.0, OrderCalculator.applyDiscount(100.0, 0.0), EPS);
    }
    @Test void tenPercentDiscountIsApplied() {
        assertEquals(90.0, OrderCalculator.applyDiscount(100.0, 0.10), EPS);
    }
    @Test void negativeDiscountRateIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.applyDiscount(100.0, -0.01));
    }
    @Test void discountRateAboveOneIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.applyDiscount(100.0, 1.01));
    }
    @Test void zeroTaxDoesNotChangeAmount() {
        assertEquals(100.0, OrderCalculator.addTax(100.0, 0.0), EPS);
    }
    @Test void twentyPercentTaxIsAdded() {
        assertEquals(120.0, OrderCalculator.addTax(100.0, 0.20), EPS);
    }
    @Test void negativeTaxRateIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.addTax(100.0, -0.01));
    }
    @Test void taxRateAboveOneIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.addTax(100.0, 1.01));
    }
}
