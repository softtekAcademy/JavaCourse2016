package com.softtek.java.academy.exceptions;

import java.io.IOException;

public class ReservationRequestClient {

    public String
        sendReservationRequest(ReservationRequest request) throws ReservationNotPossibleException,
            IOException {

        if (request.getNumberRequested() == 100) {
            throw new ReservationNotPossibleException(
                "Not enough products in the inventory");
        }

        if (request.getNumberRequested() == 66) {
            throw new IOException("Connection reset by peer");
        }

        return "Reservation Done";
    }

}
