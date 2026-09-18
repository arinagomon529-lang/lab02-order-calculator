package by.bseu.pp.lab02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BatchTest {

    @Test void allOrdersCanFitLimit() {
        assertEquals(3, OrderCalculator.countOrdersWithinLimit(
                new double[]{100.0, 200.0, 300.0}, 300.0));
    }
    @Test void onlySomeOrdersFitLimit() {
        assertEquals(2, OrderCalculator.countOrdersWithinLimit(
                new double[]{100.0, 500.0, 300.0}, 300.0));
    }
    @Test void emptyArrayProducesZero() {
        assertEquals(0, OrderCalculator.countOrdersWithinLimit(new double[]{}, 300.0));
    }
    @Test void nullArrayIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.countOrdersWithinLimit(null, 300.0));
    }
    @Test void negativeTotalIsRejected() {
        assertThrows(IllegalArgumentException.class,
                () -> OrderCalculator.countOrdersWithinLimit(new double[]{100.0, -1.0}, 300.0));
    }
}
