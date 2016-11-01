package test.runnable;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.softtek.java.academy.threads.thread.CountThread;
import com.softtek.java.academy.threads.thread.CountYieldThread;


public class CountThreadTest {
    
    @Test
    public void shouldThreadStateBeNew() {

        CountThread count = new CountThread();
        count.setMessage("Count: ");
        assertTrue(count.getState().toString() == "NEW");

    }

    @Test
    public void shouldThreadStateBeRunning() {

        CountThread count = new CountThread();
        count.setMessage("Count: ");
        count.start();

        try {
            assertTrue(count.getState().toString() == "RUNNABLE");
            Thread.currentThread().join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldNotBeLikelyEven() {

        CountYieldThread count = new CountYieldThread();
        count.setMessage("Count Not even: ");
        count.start();
        for (int i = 0; i < 50; i++) {
            System.out.println("Main thread turn " + i);
        }
        
        try {
            Thread.currentThread().join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("End of Main thread");
        
    }
    
    @Test
    public void shouldBeLikelyEven() {

        CountYieldThread count = new CountYieldThread();
        count.setMessage("Count likely even: ");
        count.start();
        for (int i = 0; i < 50; i++) {
            System.out.println("Even Main thread turn " + i);
            Thread.yield();
        }
        System.out.println("Even End of Main thread");
        try {
            Thread.currentThread().join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
  

}
