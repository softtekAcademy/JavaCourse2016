package test.runnable;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.softtek.java.academy.threads.runnable.CountRunnable;
import com.softtek.java.academy.threads.runnable.CountYieldRunnable;

public class CountRunnableTest {

    @Test
    public void shouldThreadStateBeNew() {

        CountRunnable count = new CountRunnable();
        count.setMessage("Count: ");

        Thread thread = new Thread(count);
        assertTrue(thread.getState().toString() == "NEW");

    }

    @Test
    public void shouldThreadStateBeRunning() {

        CountRunnable count = new CountRunnable();
        count.setMessage("Count: ");
        
        Thread thread = new Thread(count);
        thread.start();

        try {
            assertTrue(thread.getState().toString() == "RUNNABLE");
            Thread.currentThread().join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldNotBeLikelyEven() {

        CountYieldRunnable count = new CountYieldRunnable();
        count.setMessage("Count Not even: ");
        Thread thread = new Thread(count);
        thread.start();
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

        CountYieldRunnable count = new CountYieldRunnable();
        count.setMessage("Count likely even: ");
        Thread thread = new Thread(count);
        thread.start();
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
