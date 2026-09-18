# Laboratory Work 2 — Order Calculator

This is a starter Maven project for Laboratory Work 2 in the **Industrial Programming** course.

## Goal

Implement the methods in `OrderCalculator` so that all provided JUnit tests pass.

The task practices:
- primitive types and arrays;
- expressions and arithmetic operations;
- `if / else` conditions;
- loops;
- methods and return values;
- validation and boundary cases.

## Project structure

- `src/main/java/by/bseu/pp/lab02/OrderCalculator.java` — methods to implement;
- `src/main/java/by/bseu/pp/lab02/Application.java` — small manual run example;
- `src/test/java/by/bseu/pp/lab02/` — provided tests.

## Important

Do not rename the class, methods, parameters, or package used by the starter project.
Do not delete, disable, or modify the provided tests.

## Required behavior

### `calculateSubtotal(double[] prices, int[] quantities)`
Returns the sum of `prices[i] * quantities[i]` for all order items.

Invalid input:
- either array is `null`;
- arrays have different lengths;
- arrays are empty;
- any price is negative;
- any quantity is less than or equal to zero.

For invalid input throw `IllegalArgumentException`.
A zero price is allowed.

### `determineDiscountRate(int previousOrdersCount)`
Discount rules:
- 0–19 previous orders: `0.00`;
- 20–99 previous orders: `0.07`;
- 100 or more previous orders: `0.15`.

A negative number of previous orders is invalid and must cause `IllegalArgumentException`.

### `applyDiscount(double subtotal, double discountRate)`
Returns `subtotal * (1 - discountRate)`.

`subtotal` must be non-negative. `discountRate` must be in the inclusive range `[0.0, 1.0]`.
Invalid values must cause `IllegalArgumentException`.

### `addTax(double amount, double taxRate)`
Returns `amount * (1 + taxRate)`.

`amount` must be non-negative. `taxRate` must be in the inclusive range `[0.0, 1.0]`.
Invalid values must cause `IllegalArgumentException`.

### `calculateTotal(double[] prices, int[] quantities, int previousOrdersCount, double taxRate)`
Must use the other methods in this class and perform the operations in this order:
1. validate / calculate subtotal;
2. determine the discount rate;
3. apply discount;
4. add tax;
5. return the result.

### `isWithinCreditLimit(double total, double creditLimit)`
Returns `true` when `total <= creditLimit`.
Both arguments must be non-negative; otherwise throw `IllegalArgumentException`.

### `countOrdersWithinLimit(double[] totals, double creditLimit)`
Counts how many order totals satisfy the credit limit.

Rules:
- `totals == null` is invalid;
- an empty array is valid and returns `0`;
- every total must be non-negative;
- `creditLimit` must be non-negative.

Invalid input must cause `IllegalArgumentException`.

## Run tests

In IntelliJ IDEA, run all tests from `src/test/java`, or use Maven:

```bash
mvn test
```

The provided test suite contains **38 test scenarios**.
