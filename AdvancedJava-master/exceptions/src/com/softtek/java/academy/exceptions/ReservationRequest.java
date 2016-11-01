package com.softtek.java.academy.exceptions;

import java.util.Date;
import java.util.UUID;

public class ReservationRequest {

    private UUID productId;

    private Integer numberRequested;

    private Date dateReceived;

    public UUID getProductId() {

        return productId;
    }

    public void setProductId(UUID productId) {

        this.productId = productId;
    }

    public Integer getNumberRequested() {

        return numberRequested;
    }

    public void setNumberRequested(Integer numberRequested) {

        this.numberRequested = numberRequested;
    }

    public Date getDateReceived() {

        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {

        this.dateReceived = dateReceived;
    }

}
