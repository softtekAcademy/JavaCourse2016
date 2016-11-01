package com.softtek.java.academy.collections.domain;

import java.util.List;

public class Address {

    private String zipCode;

    private Integer number;

    private String street;

    private List<Party> parties;

    public String getZipCode() {

        return zipCode;
    }

    public void setZipCode(String zipCode) {

        this.zipCode = zipCode;
    }

    public Integer getNumber() {

        return number;
    }

    public void setNumber(Integer number) {

        this.number = number;
    }

    public String getStreet() {

        return street;
    }

    public void setStreet(String street) {

        this.street = street;
    }

    public List<Party> getParties() {

        return parties;
    }

    public void setParties(List<Party> parties) {

        this.parties = parties;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        result = prime * result + ((parties == null) ? 0 : parties.hashCode());
        result = prime * result + ((street == null) ? 0 : street.hashCode());
        result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
        if (!(obj instanceof Address)) {
            return false;
        }
        Address other = (Address) obj;
        if (number == null) {
            if (other.number != null) {
                return false;
            }
        } else if (!number.equals(other.number)) {
            return false;
        }
        if (parties == null) {
            if (other.parties != null) {
                return false;
            }
        } else if (!parties.equals(other.parties)) {
            return false;
        }
        if (street == null) {
            if (other.street != null) {
                return false;
            }
        } else if (!street.equals(other.street)) {
            return false;
        }
        if (zipCode == null) {
            if (other.zipCode != null) {
                return false;
            }
        } else if (!zipCode.equals(other.zipCode)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "Address [zipCode=" + zipCode + ", number=" + number
            + ", street=" + street + ", parties=" + parties + "]";
    }

    
}
