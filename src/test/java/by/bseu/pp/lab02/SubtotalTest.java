package by.bseu.pp.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtotalTest {
    private static final double EPS = 1e-9;

    @Test void singleItem() {
        assertEquals(200.0, OrderCalculator.calculateSubtotal(new double[]{100.0}, new int[]{2}), EPS);
    }
    @Test void multipleItems() {
        assertEquals(325.0, OrderCalculator.calculateSubtotal(
                new double[]{100.0, 25.0, 10.0}, new int[]{2, 3, 5}), EPS);
    }
    @Test void zeroPriceIsAllowed() {
        assertEquals(0.0, OrderCalculator.calculateSubtotal(new double[]{0.0}, new int[]{5}), EPS);
    }
    @Test void nullPricesAreRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.calculateSubtotal(null, new int[]{1}));
    }
    @Test void nullQuantitiesAreRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.calculateSubtotal(new double[]{1.0}, null));
    }
    @Test void arraysWithDifferentLengthsAreRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.calculateSubtotal(new double[]{1.0, 2.0}, new int[]{1}));
    }
    @Test void emptyArraysAreRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.calculateSubtotal(new double[]{}, new int[]{}));
    }
    @Test void negativePriceIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.calculateSubtotal(new double[]{-1.0}, new int[]{1}));
    }
    @Test void zeroQuantityIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.calculateSubtotal(new double[]{10.0}, new int[]{0}));
    }
    @Test void negativeQuantityIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.calculateSubtotal(new double[]{10.0}, new int[]{-1}));
    }
}
