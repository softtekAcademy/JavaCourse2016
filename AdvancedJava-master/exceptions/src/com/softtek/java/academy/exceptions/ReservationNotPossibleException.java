package com.softtek.java.academy.exceptions;

public class ReservationNotPossibleException extends Exception {

    private static final long serialVersionUID = 6950037535236834048L;

    public ReservationNotPossibleException() {

    }

    public ReservationNotPossibleException(String message) {

        super(message);
    }

    public ReservationNotPossibleException(Throwable cause) {

        super(cause);
    }

    public ReservationNotPossibleException(String message, Throwable cause) {

        super(message, cause);
    }

}
