package test.list;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import com.softtek.java.academy.collections.domain.Organization;
import com.softtek.java.academy.collections.service.OrganizationService;

public class OrganizationServiceTest {

    @Test
    public void shouldAddOrganizationWithIndex() {

        Organization org1 = new Organization();
        org1.setId(UUID.randomUUID());
        org1.setName("marketing");
        org1.setCompany("Retail Inc.");

        Organization org2 = new Organization();
        org2.setId(UUID.randomUUID());
        org2.setName("supply chain");
        org2.setCompany("Retail Inc.");

        Organization org3 = new Organization();
        org3.setId(UUID.randomUUID());
        org3.setName("sales");
        org3.setCompany("Retail Inc.");

        OrganizationService organizationService = new OrganizationService();
        organizationService.addOrganization(0, org1);
        organizationService.addOrganization(1, org2);
        organizationService.addOrganization(2, org3);

        Organization lo1 = organizationService.getOrganization(0);
        Organization lo2 = organizationService.getOrganization(1);
        Organization lo3 = organizationService.getOrganization(2);

        assertEquals(lo1, org1);
        assertEquals(lo2, org2);
        assertEquals(lo3, org3);

    }

    @Test
    public void shouldAddOrganization() {

        Organization org1 = new Organization();
        org1.setId(UUID.randomUUID());
        org1.setName("marketing");
        org1.setCompany("Retail Inc.");

        Organization org2 = new Organization();
        org2.setId(UUID.randomUUID());
        org2.setName("supply chain");
        org2.setCompany("Retail Inc.");

        Organization org3 = new Organization();
        org3.setId(UUID.randomUUID());
        org3.setName("sales");
        org3.setCompany("Retail Inc.");

        OrganizationService organizationService = new OrganizationService();
        organizationService.addOrganization(org1);
        organizationService.addOrganization(org2);
        organizationService.addOrganization(org3);

        Organization lo1 = organizationService.getOrganization(0);
        Organization lo2 = organizationService.getOrganization(1);
        Organization lo3 = organizationService.getOrganization(2);

        assertEquals(lo1, org1);
        assertEquals(lo2, org2);
        assertEquals(lo3, org3);

    }

    @Test
    public void shouldRemoveOrganizationByIndex() {

        Organization org1 = new Organization();
        org1.setId(UUID.randomUUID());
        org1.setName("marketing");
        org1.setCompany("Retail Inc.");

        Organization org2 = new Organization();
        org2.setId(UUID.randomUUID());
        org2.setName("supply chain");
        org2.setCompany("Retail Inc.");

        Organization org3 = new Organization();
        org3.setId(UUID.randomUUID());
        org3.setName("sales");
        org3.setCompany("Retail Inc.");

        OrganizationService organizationService = new OrganizationService();
        organizationService.addOrganization(org1);
        organizationService.addOrganization(org2);
        organizationService.addOrganization(org3);

        assertTrue(organizationService.isPartyActive(org2));

        organizationService.removeOrganization(1);

        assertFalse(organizationService.isPartyActive(org2));

        Organization lo1 = organizationService.getOrganization(0);
        Organization lo2 = organizationService.getOrganization(1);

        assertEquals(lo1, org1);
        assertEquals(lo2, org3);
    }

    @Test
    public void shouldRemoveOrganization() {

        Organization org1 = new Organization();
        org1.setId(UUID.randomUUID());
        org1.setName("marketing");
        org1.setCompany("Retail Inc.");

        Organization org2 = new Organization();
        org2.setId(UUID.randomUUID());
        org2.setName("supply chain");
        org2.setCompany("Retail Inc.");

        Organization org3 = new Organization();
        org3.setId(UUID.randomUUID());
        org3.setName("sales");
        org3.setCompany("Retail Inc.");

        OrganizationService organizationService = new OrganizationService();
        organizationService.addOrganization(org1);
        organizationService.addOrganization(org2);
        organizationService.addOrganization(org3);

        assertTrue(organizationService.isPartyActive(org1));

        organizationService.removeOrganization(org1);

        assertFalse(organizationService.isPartyActive(org1));

        Organization lo1 = organizationService.getOrganization(0);
        Organization lo2 = organizationService.getOrganization(1);

        assertEquals(lo1, org2);
        assertEquals(lo2, org3);
    }

    @Test
    public void shouldGetOrganizationIndex() {

        Organization org1 = new Organization();
        org1.setId(UUID.randomUUID());
        org1.setName("marketing");
        org1.setCompany("Retail Inc.");

        Organization org2 = new Organization();
        org2.setId(UUID.randomUUID());
        org2.setName("supply chain");
        org2.setCompany("Retail Inc.");

        Organization org3 = new Organization();
        org3.setId(UUID.randomUUID());
        org3.setName("sales");
        org3.setCompany("Retail Inc.");

        OrganizationService organizationService = new OrganizationService();
        organizationService.addOrganization(org1);
        organizationService.addOrganization(org2);
        organizationService.addOrganization(org3);

        assertTrue(organizationService.getOrganizationIndex(org1) == 0);
        assertTrue(organizationService.getOrganizationIndex(org2) == 1);
        assertTrue(organizationService.getOrganizationIndex(org3) == 2);
       
    }

}
