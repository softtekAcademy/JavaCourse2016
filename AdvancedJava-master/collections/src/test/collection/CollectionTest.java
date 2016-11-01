package test.collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.junit.Test;

import com.softtek.java.academy.collections.domain.Organization;

public class CollectionTest {

    @Test
    public void shouldTransformIntoUnion() {

        Organization[] values1 =
            {
                new Organization(UUID.randomUUID(), "supply chain",
                    "Demo Company"),
                new Organization(UUID.randomUUID(), "marketing", "Demo Company"),
                new Organization(UUID.randomUUID(), "finance", "Demo Company"),
                new Organization(UUID.randomUUID(), "sales", "Demo Company")};

        Organization[] values2 =
            {
                new Organization(UUID.randomUUID(), "supply chain",
                    "Big O Company"),
                new Organization(UUID.randomUUID(), "marketing",
                    "Big O Company"),
                new Organization(UUID.randomUUID(), "finance", "Big O Company"),
                new Organization(UUID.randomUUID(), "sales", "Big O Company")};

        List<Organization> buyingCompany =
            new ArrayList<Organization>(Arrays.asList(values1));

        assertFalse(buyingCompany.isEmpty());

        List<Organization> purchaseCompany =
            new ArrayList<Organization>(Arrays.asList(values2));

        assertFalse(purchaseCompany.isEmpty());

        buyingCompany.addAll(purchaseCompany);

        assertTrue(buyingCompany.containsAll(purchaseCompany));

    }

    @Test
    public void shouldTransformIntoIntersection() {

        UUID id = UUID.randomUUID();

        Organization[] values1 =
            {
                new Organization(UUID.randomUUID(), "supply chain",
                    "Demo Company"),
                new Organization(UUID.randomUUID(), "marketing", "Demo Company"),
                new Organization(UUID.randomUUID(), "finance", "Demo Company"),
                new Organization(id, "sales", "Demo Company")};

        Organization[] values2 =
            {
                new Organization(UUID.randomUUID(), "supply chain",
                    "Big O Company"),
                new Organization(UUID.randomUUID(), "marketing",
                    "Big O Company"),
                new Organization(UUID.randomUUID(), "finance", "Big O Company"),
                new Organization(id, "sales", "Demo Company")};

        List<Organization> buyingCompany =
            new ArrayList<Organization>(Arrays.asList(values1));

        List<Organization> purchaseCompany =
            new ArrayList<Organization>(Arrays.asList(values2));

        List<Organization> intersection =
            new ArrayList<Organization>(buyingCompany);
        intersection.retainAll(purchaseCompany);

        assertTrue(intersection.size() == 1);

    }

    @Test
    public void shouldTransformIntoDifference() {

        UUID id = UUID.randomUUID();

        Organization[] values1 =
            {
                new Organization(UUID.randomUUID(), "supply chain",
                    "Demo Company"),
                new Organization(UUID.randomUUID(), "marketing", "Demo Company"),
                new Organization(UUID.randomUUID(), "finance", "Demo Company"),
                new Organization(id, "sales", "Demo Company")};

        Organization[] values2 =
            {
                new Organization(UUID.randomUUID(), "supply chain",
                    "Big O Company"),
                new Organization(UUID.randomUUID(), "marketing",
                    "Big O Company"),
                new Organization(UUID.randomUUID(), "finance", "Big O Company"),
                new Organization(id, "sales", "Demo Company")};

        List<Organization> buyingCompany =
            new ArrayList<Organization>(Arrays.asList(values1));

        List<Organization> purchaseCompany =
            new ArrayList<Organization>(Arrays.asList(values2));

        List<Organization> difference =
            new ArrayList<Organization>(buyingCompany);
        difference.removeAll(purchaseCompany);

        assertTrue(difference.size() == 3);

    }

    @Test
    public void shouldSortByNameASC() {

        Organization[] values1 =
            {
                new Organization(UUID.randomUUID(), "supply chain",
                    "Demo Company"),
                new Organization(UUID.randomUUID(), "marketing", "Demo Company"),
                new Organization(UUID.randomUUID(), "finance", "Demo Company"),
                new Organization(UUID.randomUUID(), "sales", "Demo Company")};

        List<Organization> buyingCompany =
            new ArrayList<Organization>(Arrays.asList(values1));
        
        Organization o1 = buyingCompany.get(0);
        assertEquals(o1.getName(), "supply chain");
        
        Collections.sort(buyingCompany);
        
        Organization o2 = buyingCompany.get(0);
        assertEquals(o2.getName(), "finance");

    }

    @Test
    public void shouldSortByNameDESC() {

        Organization[] values1 =
            {
                new Organization(UUID.randomUUID(), "finance", "Demo Company"),
                new Organization(UUID.randomUUID(), "marketing", "Demo Company"),
                new Organization(UUID.randomUUID(), "sales", "Demo Company"),
                new Organization(UUID.randomUUID(), "supply chain",
                    "Demo Company")};

        List<Organization> buyingCompany =
            new ArrayList<Organization>(Arrays.asList(values1));
        
        Organization o1 = buyingCompany.get(0);
        assertEquals(o1.getName(), "finance");

        Collections.sort(buyingCompany);
        Collections.reverse(buyingCompany);
        
        Organization o2 = buyingCompany.get(0);
        assertEquals(o2.getName(), "supply chain");

    }
}
