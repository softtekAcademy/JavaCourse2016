package com.softtek.java.academy.jdbc.entity;

import java.util.Date;

public class SalesOrder {

    private String id;

    private OrderStatus orderStatus;

    private SalesChannel salesChannel;

    private Date creationDate;

    public SalesOrder() {

    }

    public String getId() {

        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public OrderStatus getOrderStatus() {

        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {

        this.orderStatus = orderStatus;
    }

    public SalesChannel getSalesChannel() {

        return salesChannel;
    }

    public void setSalesChannel(SalesChannel salesChannel) {

        this.salesChannel = salesChannel;
    }

    public Date getCreationDate() {

        return creationDate;
    }

    public void setCreationDate(Date creationDate) {

        this.creationDate = creationDate;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result =
            prime * result
                + ((creationDate == null) ? 0 : creationDate.hashCode());
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result =
            prime * result
                + ((orderStatus == null) ? 0 : orderStatus.hashCode());
        result =
            prime * result
                + ((salesChannel == null) ? 0 : salesChannel.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof SalesOrder)) {
            return false;
        }
        SalesOrder other = (SalesOrder) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        if (orderStatus == null) {
            if (other.orderStatus != null) {
                return false;
            }
        } else if (!orderStatus.equals(other.orderStatus)) {
            return false;
        }
        if (salesChannel == null) {
            if (other.salesChannel != null) {
                return false;
            }
        } else if (!salesChannel.equals(other.salesChannel)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "SalesOrder [id=" + id + ", orderStatus=" + orderStatus
            + ", salesChannel=" + salesChannel + ", creationDate="
            + creationDate + "]";
    }

}
