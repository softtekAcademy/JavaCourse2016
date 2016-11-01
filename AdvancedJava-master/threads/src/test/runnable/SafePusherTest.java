package test.runnable;

import org.junit.Test;

import com.softtek.java.academy.threads.synchronization.SafePusher;
import com.softtek.java.academy.threads.synchronization.SafeStack;

public class SafePusherTest {

    @Test
    public void shouldResultBeConsistent() {

        SafeStack safeStack = new SafeStack();
        SafePusher safePusher1 = new SafePusher(safeStack);
        SafePusher safePusher2 = new SafePusher(safeStack);

        safePusher1.start();
        safePusher2.start();

        try {
            safePusher1.join();
            safePusher2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(safeStack.toString());
    }

}
