package test.map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import com.softtek.java.academy.collections.domain.Organization;
import com.softtek.java.academy.collections.domain.Person;
import com.softtek.java.academy.collections.service.PartyDictionary;

public class PartyDictionaryTest {

    @Test
    public void shouldAddEntries() {

        Person p1 = new Person();
        p1.setId(UUID.randomUUID());
        p1.setName("name1");

        Person p2 = new Person();
        p2.setId(UUID.randomUUID());
        p2.setName("name2");

        PartyDictionary<Person> partyDictionary = new PartyDictionary<Person>();
        partyDictionary.putParty(p1.getId().toString(), p1);
        partyDictionary.putParty(p2.getId().toString(), p2);

        assertTrue(partyDictionary.total() == 2);

    }

    @Test
    public void shouldAddLastEntry() {

        UUID id = UUID.randomUUID();
        Person p1 = new Person();
        p1.setId(id);
        p1.setName("name1");

        Person p2 = new Person();
        p2.setId(id);
        p2.setName("name2");

        PartyDictionary<Person> partyDictionary = new PartyDictionary<Person>();
        partyDictionary.putParty(p1.getId().toString(), p1);
        partyDictionary.putParty(p2.getId().toString(), p2);

        assertTrue(partyDictionary.total() == 1);
    }

    @Test
    public void shouldRemoveEntry() {

        UUID id = UUID.randomUUID();
        Person p1 = new Person();
        p1.setId(id);
        p1.setName("name1");

        Person p2 = new Person();
        p2.setId(UUID.randomUUID());
        p2.setName("name2");

        PartyDictionary<Person> partyDictionary = new PartyDictionary<Person>();
        partyDictionary.putParty(p1.getId().toString(), p1);
        partyDictionary.putParty(p2.getId().toString(), p2);

        partyDictionary.deleteParty(id.toString());

        assertTrue(partyDictionary.total() == 1);
    }

    @Test
    public void shouldLookupParty() {

        UUID id = UUID.randomUUID();
        Organization org1 = new Organization();
        org1.setId(id);
        org1.setName("name1");

        Organization org2 = new Organization();
        org2.setId(UUID.randomUUID());
        org2.setName("name2");

        PartyDictionary<Organization> partyDictionary =
            new PartyDictionary<Organization>();
        partyDictionary.putParty(org1.getId().toString(), org1);
        partyDictionary.putParty(org2.getId().toString(), org2);

        Organization o = partyDictionary.lookupParty(id.toString());

        assertEquals(org1, o);
    }
    
    @Test
    public void shouldRemoveParty() {
        UUID id = UUID.randomUUID();
        Organization org1 = new Organization();
        org1.setId(id);
        org1.setName("name1");

        Organization org2 = new Organization();
        org2.setId(UUID.randomUUID());
        org2.setName("name2");

        PartyDictionary<Organization> partyDictionary =
            new PartyDictionary<Organization>();
        partyDictionary.putParty(org1.getId().toString(), org1);
        partyDictionary.putParty(org2.getId().toString(), org2);
        
        assertTrue(partyDictionary.total() == 2);

        partyDictionary.deleteParty(id.toString());
        
        assertTrue(partyDictionary.total() == 1);
        
    }

}
