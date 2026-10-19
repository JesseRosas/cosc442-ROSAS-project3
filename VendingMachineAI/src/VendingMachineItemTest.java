
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class VendingMachineItemTest {

    @Test
    void constructorStoresNameAndPrice() {
        VendingMachineItem item =
                new VendingMachineItem("Chips", 2.50);

        assertEquals("Chips", item.getName());
        assertEquals(2.50, item.getPrice(), 0.001);
    }

    @Test
    void zeroPriceIsAllowed() {
        VendingMachineItem item =
                new VendingMachineItem("Free Sample", 0.0);

        assertEquals(0.0, item.getPrice(), 0.001);
    }

    @Test
    void negativePriceThrowsException() {
        assertThrows(VendingMachineException.class, () -> {
            new VendingMachineItem("Candy", -1.00);
        });
    }

    @Test
    void itemRetainsItsOriginalValues() {
        VendingMachineItem item =
                new VendingMachineItem("Water", 1.75);

        assertEquals("Water", item.getName());
        assertEquals(1.75, item.getPrice(), 0.001);
    }
}
