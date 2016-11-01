package test;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;

import com.softtek.java.academy.exceptions.InventoryService;
import com.softtek.java.academy.exceptions.ReservationRequest;

public class InventoryServiceCheckedExceptionTest {

    @Test
    public void shouldThrowAndHandleReservationNotPossibleException() {

        InventoryService inventoryService = new InventoryService();
        ReservationRequest request = new ReservationRequest();
        request.setProductId(UUID.randomUUID());
        //set request number to 100 to throw ReservationNotPossibleException
        request.setNumberRequested(100);
        request.setDateReceived(new Date());
        
        inventoryService.makeReservation(request);
    }
    
    @Test
    public void shouldThrowAndHandleIOException() {

        InventoryService inventoryService = new InventoryService();
        ReservationRequest request = new ReservationRequest();
        request.setProductId(UUID.randomUUID());
        // set request number to 66 to throw IO exception
        request.setNumberRequested(66);
        request.setDateReceived(new Date());
        
        inventoryService.makeReservation(request);
    }

}
