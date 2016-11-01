package com.softtek.java.academy.collections.domain;

import java.util.List;
import java.util.UUID;

public class Party {

    private UUID id;

    private String description;

    private List<Address> addresses;

    private List<PartyRole> partyRoles;

    public UUID getId() {

        return id;
    }

    public void setId(UUID id) {

        this.id = id;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public List<Address> getAddresses() {

        return addresses;
    }

    public void setAddresses(List<Address> addresses) {

        this.addresses = addresses;
    }

    public List<PartyRole> getPartyRoles() {

        return partyRoles;
    }

    public void setPartyRoles(List<PartyRole> partyRoles) {

        this.partyRoles = partyRoles;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        if (!(obj instanceof Party)) {
            return false;
        }
        Party other = (Party) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
       
        return true;
    }

    @Override
    public String toString() {

        return "Party [id=" + id + "]";
    }
    
    

}
