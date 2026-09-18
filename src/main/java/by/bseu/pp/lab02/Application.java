package by.bseu.pp.lab02;

public class Application {
    public static void main(String[] args) {
        double[] prices = {100.0, 50.0};
        int[] quantities = {2, 2};
        int previousOrdersCount = 25;
        double taxRate = 0.20;
        double creditLimit = 400.0;

        double total = OrderCalculator.calculateTotal(
                prices,
                quantities,
                previousOrdersCount,
                taxRate);

        System.out.println("Order total: " + total);
        System.out.println("Within credit limit: "
                + OrderCalculator.isWithinCreditLimit(total, creditLimit));
    }
}
