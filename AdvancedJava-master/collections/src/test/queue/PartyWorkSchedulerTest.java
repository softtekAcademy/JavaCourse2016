package test.queue;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;

import com.softtek.java.academy.collections.domain.Person;
import com.softtek.java.academy.collections.service.PartyWorkScheduler;
import com.softtek.java.academy.collections.service.WorkNotification;

public class PartyWorkSchedulerTest {

    @Test
    public void shouldAddWorkNotification() {

        Person p1 = new Person();
        p1.setId(UUID.randomUUID());
        p1.setName("name1");

        WorkNotification workNotification = new WorkNotification();
        workNotification.setTodo("create purchase order");
        workNotification.setUser(p1);

        PartyWorkScheduler partyWorkScheduler = new PartyWorkScheduler();
        partyWorkScheduler.addWorkNotification(workNotification);

        assertNotNull(partyWorkScheduler.previewNextWorkNotification());
        assertEquals(workNotification,
            partyWorkScheduler.previewNextWorkNotification());
        assertTrue(partyWorkScheduler.notifications() == 1);

    }

    @Test
    public void shouldProcessWorkNotifications() {

        Person p1 = new Person();
        p1.setId(UUID.randomUUID());
        p1.setName("name1");

        WorkNotification wn1 = new WorkNotification();
        wn1.setTodo("notify company hub");
        wn1.setUser(p1);

        Person p2 = new Person();
        p2.setId(UUID.randomUUID());
        p2.setName("name2");

        WorkNotification wn2 = new WorkNotification();
        wn2.setTodo("review inventory capacity");
        wn2.setUser(p2);

        PartyWorkScheduler partyWorkScheduler = new PartyWorkScheduler();
        partyWorkScheduler.addWorkNotification(wn1);
        partyWorkScheduler.addWorkNotification(wn2);

        WorkNotification current1 =
            partyWorkScheduler.getNextWorkNotification();
        assertNotNull(current1);
        assertEquals(wn1, current1);
        assertTrue(partyWorkScheduler.notifications() == 1);
        
        WorkNotification current2 =
            partyWorkScheduler.getNextWorkNotification();
        assertNotNull(current2);
        assertEquals(wn2, current2);
        assertTrue(partyWorkScheduler.notifications() == 0);

    }

}
