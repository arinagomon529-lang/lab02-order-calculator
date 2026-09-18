package by.bseu.pp.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {
    private static final double EPS = 1e-9;

    @Test void zeroOrdersMeansNoDiscount() {
        assertEquals(0.0, OrderCalculator.determineDiscountRate(0), EPS);
    }
    @Test void nineteenOrdersMeansNoDiscount() {
        assertEquals(0.0, OrderCalculator.determineDiscountRate(19), EPS);
    }
    @Test void twentyOrdersMeansSevenPercent() {
        assertEquals(0.07, OrderCalculator.determineDiscountRate(20), EPS);
    }
    @Test void ninetyNineOrdersMeansSevenPercent() {
        assertEquals(0.07, OrderCalculator.determineDiscountRate(99), EPS);
    }
    @Test void oneHundredOrdersMeansFifteenPercent() {
        assertEquals(0.15, OrderCalculator.determineDiscountRate(100), EPS);
    }
    @Test void largeOrderCountKeepsFifteenPercent() {
        assertEquals(0.15, OrderCalculator.determineDiscountRate(250), EPS);
    }
    @Test void negativeOrderCountIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.determineDiscountRate(-1));
    }
}
