package com.softtek.java.academy.collections.service;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import com.softtek.java.academy.collections.domain.Organization;

public class PartyFilter {

    public List<Organization> findDuplicates(List<Organization> organizations) {

        Set<Organization> repository = new LinkedHashSet<Organization>();
        Set<Organization> duplicates = new LinkedHashSet<Organization>();

        for (Organization organization : organizations) {

            if (!repository.add(organization)) {
                duplicates.add(organization);
            }
        }

        return Arrays.asList(duplicates.toArray(new Organization[0]));
    }

    public List<Organization>
        removeDuplicates(List<Organization> organizations) {

        Set<Organization> repository = new LinkedHashSet<Organization>();
        repository.addAll(organizations);

        return Arrays.asList(repository.toArray(new Organization[0]));
    }

}
