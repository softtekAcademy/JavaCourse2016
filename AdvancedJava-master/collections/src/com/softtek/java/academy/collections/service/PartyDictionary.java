package com.softtek.java.academy.collections.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.softtek.java.academy.collections.domain.Party;

public class PartyDictionary<E extends Party> {

    private Map<String, E> dictionary;

    public PartyDictionary() {

        this.dictionary = new HashMap<String, E>();
    }

    public E lookupParty(String uuid) {

        return this.dictionary.get(uuid);
    }

    public boolean isPartyRegistered(String uuid) {

        return this.dictionary.containsValue(uuid);
    }

    public void putParty(String uuid, E party) {

        this.dictionary.put(uuid, party);
    }

    public void deleteParty(String uuid) {

        this.dictionary.remove(uuid);

    }

    public Set<String> getOrganizationList() {

        return this.dictionary.keySet();
    }

    public int total() {

        return this.dictionary.size();
    }

}
