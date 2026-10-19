
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    private VendingMachine machine;

    @BeforeEach
    void setUp() {
        machine = new VendingMachine();
    }

    @Test
    void newMachineHasZeroBalance() {
        assertEquals(0.0, machine.getBalance(), 0.001);
    }

    @Test
    void addingItemToEmptySlotSucceeds() {
        VendingMachineItem item =
                new VendingMachineItem("Chips", 2.00);

        machine.addItem(item, "A");

        assertSame(item, machine.getItem("A"));
    }

    @Test
    void addingItemToOccupiedSlotThrowsException() {
        machine.addItem(
                new VendingMachineItem("Chips", 2.00), "A");

        assertThrows(VendingMachineException.class, () ->
                machine.addItem(
                    new VendingMachineItem("Candy", 1.50), "A")
        );
    }

    @Test
    void invalidSlotCodeThrowsException() {
        VendingMachineItem item =
                new VendingMachineItem("Water", 1.00);

        assertThrows(VendingMachineException.class, () ->
                machine.addItem(item, "Z")
        );
    }

    @Test
    void removingExistingItemReturnsItem() {
        VendingMachineItem item =
                new VendingMachineItem("Soda", 2.50);

        machine.addItem(item, "B");

        assertSame(item, machine.removeItem("B"));
        assertNull(machine.getItem("B"));
    }

    @Test
    void removingEmptySlotThrowsException() {
        assertThrows(VendingMachineException.class, () ->
                machine.removeItem("A")
        );
    }

    @Test
    void insertingMoneyIncreasesBalance() {
        machine.insertMoney(5.00);

        assertEquals(5.00, machine.getBalance(), 0.001);
    }

    @Test
    void negativeMoneyThrowsException() {
        assertThrows(VendingMachineException.class, () ->
                machine.insertMoney(-2.00)
        );
    }

    @Test
    void purchaseWithEnoughMoneySucceeds() {
        machine.addItem(
                new VendingMachineItem("Soda", 2.00), "A");
        machine.insertMoney(5.00);

        assertTrue(machine.makePurchase("A"));
        assertEquals(3.00, machine.getBalance(), 0.001);
        assertNull(machine.getItem("A"));
    }

    @Test
    void purchaseWithInsufficientMoneyFails() {
        machine.addItem(
                new VendingMachineItem("Chips", 5.00), "A");
        machine.insertMoney(2.00);

        assertFalse(machine.makePurchase("A"));
        assertNotNull(machine.getItem("A"));
        assertEquals(2.00, machine.getBalance(), 0.001);
    }

    @Test
    void returningChangeResetsBalance() {
        machine.insertMoney(10.00);

        assertEquals(10.00, machine.returnChange(), 0.001);
        assertEquals(0.00, machine.getBalance(), 0.001);
    }
}
