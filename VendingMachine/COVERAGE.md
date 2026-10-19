# VendingMachine Code Coverage — Task 1

## Initial and Final Coverage

| Source File | Initial Line Coverage | Initial Branch Coverage | Final Line Coverage | Final Branch Coverage |
|---|---|---|---|---|
| VendingMachine.java | 100% | 100% | 100% | 100% |
| VendingMachineItem.java | 100% | 100% | 100% | 100% |

My original Project 2 tests already achieved 100% line and branch coverage for both classes, so no additional tests were added.

## Condition-Coverage Analysis

For condition coverage, I looked at the `makePurchase()` method, which checks whether an item exists and if the customer has enough money to buy it. The `purchaseEmptyFails()` test covers when no item is available, while `purchaseInsufficientFails()` covers when there isn't enough money. Both `purchaseExactSucceeds()` and `purchaseExtraSucceeds()` test when these conditions are true. Since Java uses short-circuit evaluation, the balance isn't checked if the item doesn't exist. These tests cover both true and false outcomes for each condition.

## Test-Sensitivity Experiment

I introduced a temporary fault in `makePurchase()` by changing `>=` to `>` in the balance comparison. This prevented purchases when the balance was exactly equal to the item's price.

After running all 30 tests, 29 passed and one failed. The failing test was `purchaseExactSucceeds()`, which expected `true` but received `false`. This showed that the tests could detect the boundary condition fault even though the original implementation already had 100% coverage.

After committing the faulty version, I restored the original comparison and reran the tests to confirm they all passed.