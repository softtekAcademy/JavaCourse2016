package test;

import org.junit.Test;

import com.softtek.java.academy.exceptions.InventoryService;
import com.softtek.java.academy.exceptions.ReservationRequest;

public class InventoryServiceRuntimeExceptionTest {

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowAndIllegalArgumentException() {

        InventoryService inventoryService = new InventoryService();
        ReservationRequest request = null;

        inventoryService.makeReservation(request);
    }

}
