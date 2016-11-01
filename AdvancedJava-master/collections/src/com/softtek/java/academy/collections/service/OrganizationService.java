package com.softtek.java.academy.collections.service;

import java.util.ArrayList;
import java.util.List;

import com.softtek.java.academy.collections.domain.Organization;

public class OrganizationService {

    private List<Organization> organizationRepository;

    public OrganizationService() {

        this.organizationRepository = new ArrayList<Organization>();
    }

    public List<Organization> getParties() {

        return this.organizationRepository;
    }

    public void removeOrganization(Organization organization) {

        this.organizationRepository.remove(organization);
    }

    public void removeOrganization(int index) {

        this.organizationRepository.remove(index);
    }

    public void addOrganization(int index, Organization organization) {

        this.organizationRepository.add(index, organization);
    }
    
    public void addOrganization(Organization organization) {

        this.organizationRepository.add(organization);
    }


    public Organization getOrganization(int index) {

        return this.organizationRepository.get(index);
    }

    public int getOrganizationIndex(Organization organization) {

        return this.organizationRepository.indexOf(organization);
    }

    public boolean isPartyActive(Organization organization) {

        return this.organizationRepository.contains(organization);
    }

}
