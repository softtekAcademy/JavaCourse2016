package test.set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.softtek.java.academy.collections.domain.Organization;
import com.softtek.java.academy.collections.service.PartyFilter;

public class PartyFilterTest {

    @Test
    public void shouldRemoveDuplicates() {

        UUID id = UUID.randomUUID();

        Organization[] values =
            {
                new Organization(UUID.randomUUID(), "supply chain",
                    "Demo Company"),
                new Organization(UUID.randomUUID(), "marketing", "Demo Company"),
                new Organization(UUID.randomUUID(), "finance", "Demo Company"),
                new Organization(id, "sales", "Demo Company"),
                new Organization(id, "sales", "Demo Company")};

        List<Organization> organizations = Arrays.asList(values);

        Organization org3 = organizations.get(3);
        Organization org4 = organizations.get(4);

        assertEquals(org3, org4);
        assertTrue(organizations.size() == 5);

        PartyFilter filter = new PartyFilter();
        List<Organization> filteredList =
            filter.removeDuplicates(organizations);

        assertTrue(filteredList.size() == 4);
        assertTrue(filteredList.indexOf(new Organization(id, "sales",
            "Demo Company")) == 3);
        assertTrue(filteredList.contains(new Organization(id, "sales",
            "Demo Company")));
    }

    @Test
    public void shouldFindDuplicates() {

        UUID id = UUID.randomUUID();

        Organization[] values =
            {
                new Organization(UUID.randomUUID(), "supply chain",
                    "Demo Company"),
                new Organization(UUID.randomUUID(), "marketing", "Demo Company"),
                new Organization(UUID.randomUUID(), "finance", "Demo Company"),
                new Organization(id, "sales", "Demo Company"),
                new Organization(id, "sales", "Demo Company")};

        List<Organization> organizations = Arrays.asList(values);

        Organization org3 = organizations.get(3);
        Organization org4 = organizations.get(4);

        assertEquals(org3, org4);
        assertTrue(organizations.size() == 5);

        PartyFilter filter = new PartyFilter();
        List<Organization> filteredList = filter.findDuplicates(organizations);

        assertTrue(filteredList.size() == 1);
        assertEquals(org3, filteredList.get(0));

    }

}
