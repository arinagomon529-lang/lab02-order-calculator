package by.bseu.pp.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateTotalTest {
    private static final double EPS = 1e-9;

    @Test void noDiscountAndNoTax() {
        assertEquals(50.0, OrderCalculator.calculateTotal(
                new double[]{10.0, 20.0}, new int[]{1, 2}, 0, 0.0), EPS);
    }
    @Test void sevenPercentDiscountAndTax() {
        assertEquals(334.8, OrderCalculator.calculateTotal(
                new double[]{100.0, 50.0}, new int[]{2, 2}, 25, 0.20), EPS);
    }
    @Test void fifteenPercentDiscountAndTax() {
        assertEquals(408.0, OrderCalculator.calculateTotal(
                new double[]{200.0}, new int[]{2}, 100, 0.20), EPS);
    }
    @Test void severalItemsAreCalculatedTogether() {
        assertEquals(209.0, OrderCalculator.calculateTotal(
                new double[]{12.5, 4.0, 100.0}, new int[]{4, 10, 1}, 0, 0.10), EPS);
    }
}
