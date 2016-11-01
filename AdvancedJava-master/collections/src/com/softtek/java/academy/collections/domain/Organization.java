package com.softtek.java.academy.collections.domain;

import java.util.UUID;

public class Organization extends Party implements Comparable<Organization> {

    private String name;

    private String company;

    public Organization() {

        super();
    }

    public Organization(UUID uuid, String name, String company) {

        super.setId(uuid);
        this.name = name;
        this.company = company;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getCompany() {

        return company;
    }

    public void setCompany(String company) {

        this.company = company;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((company == null) ? 0 : company.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (!super.equals(obj)) {
            return false;
        }
        if (!(obj instanceof Organization)) {
            return false;
        }
        Organization other = (Organization) obj;
        if (company == null) {
            if (other.company != null) {
                return false;
            }
        } else if (!company.equals(other.company)) {
            return false;
        }
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        } else if (!name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {

        return "Organization [name=" + name + ", company=" + company + "]";
    }

    @Override
    public int compareTo(Organization o) {

        int result = 0;

        if (this == o) {
            return result;
        }

        if (this.name.compareToIgnoreCase(o.name) == 0) {
            return result;
        }

        if (this.name.compareToIgnoreCase(o.name) < 0) {
            result = -1;
        }

        if (this.name.compareToIgnoreCase(o.name) > 0) {
            result = 1;
        }

        return result;
    }

}
