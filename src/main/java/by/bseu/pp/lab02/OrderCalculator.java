package by.bseu.pp.lab02;

/**
 * Utility methods for calculating and validating simple order data.
 *
 * <p>Implement every TODO method without changing its signature.</p>
 */
public class OrderCalculator {

    public static double calculateSubtotal(double[] prices, int[] quantities) {
        // 1. Проверка на null, разную длину и пустые массивы
        if (prices == null || quantities == null || prices.length != quantities.length || prices.length == 0) {
            throw new IllegalArgumentException("Массивы не должны быть null, должны иметь одинаковую длину и не быть пустыми");
        }

        double subtotal = 0.0;

        // 2. Обход массивов и валидация элементов
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < 0 || quantities[i] <= 0) {
                throw new IllegalArgumentException("Цена не может быть отрицательной, а количество должно быть > 0");
            }
            subtotal += prices[i] * quantities[i];
        }

        return subtotal;
    }

    public static double determineDiscountRate(int previousOrdersCount) {
        if (previousOrdersCount < 0) {
            throw new IllegalArgumentException("Количество предыдущих заказов не может быть отрицательным");
        }

        if (previousOrdersCount >= 100) {
            return 0.15;
        } else if (previousOrdersCount >= 20) {
            return 0.07;
        } else {
            return 0.00;
        }
    }

    public static double applyDiscount(double subtotal, double discountRate) {
        if (subtotal < 0 || discountRate < 0.0 || discountRate > 1.0) {
            throw new IllegalArgumentException("Некорректная сумма заказа или ставка скидки");
        }
        return subtotal * (1.0 - discountRate);
    }

    public static double addTax(double amount, double taxRate) {
        if (amount < 0 || taxRate < 0.0 || taxRate > 1.0) {
            throw new IllegalArgumentException("Некорректная сумма или ставка налога");
        }
        return amount * (1.0 + taxRate);
    }

    public static double calculateTotal(double[] prices, int[] quantities, int previousOrdersCount, double taxRate) {
        double subtotal = calculateSubtotal(prices, quantities);
        double discountRate = determineDiscountRate(previousOrdersCount);
        double discountedAmount = applyDiscount(subtotal, discountRate);
        return addTax(discountedAmount, taxRate);
    }

    public static boolean isWithinCreditLimit(double total, double creditLimit) {
        if (total < 0 || creditLimit < 0) {
            throw new IllegalArgumentException("Сумма заказа и кредитный лимит не могут быть отрицательными");
        }
        return total <= creditLimit;
    }

    public static int countOrdersWithinLimit(double[] totals, double creditLimit) {
        if (totals == null || creditLimit < 0) {
            throw new IllegalArgumentException("Массив totals не может быть null, а creditLimit не может быть отрицательным");
        }

        int count = 0;

        for (double total : totals) {
            if (total < 0) {
                throw new IllegalArgumentException("Элемент массива totals не может быть отрицательным");
            }
            if (isWithinCreditLimit(total, creditLimit)) {
                count++;
            }
        }

        return count;
    }
}
