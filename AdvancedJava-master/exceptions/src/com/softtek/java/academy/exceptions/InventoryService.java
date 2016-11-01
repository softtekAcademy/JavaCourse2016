package com.softtek.java.academy.exceptions;

import java.io.IOException;

public class InventoryService {

    public void makeReservation(ReservationRequest request) {

        if (request == null) {
            throw new IllegalArgumentException(
                "Invalid request, request cannot be null");
        }

        ReservationRequestClient reservationRequestClient =
            new ReservationRequestClient();

        try {

            reservationRequestClient.sendReservationRequest(request);

        } catch (ReservationNotPossibleException e) {
            
            PurchaseService purchaseService = new PurchaseService();
            purchaseService.verifyPurchase(request.getProductId());

        } catch (IOException e) {
            
            SystemMonitor monitor = new SystemMonitor();
            monitor.sendError(e);

        }

    }

}
