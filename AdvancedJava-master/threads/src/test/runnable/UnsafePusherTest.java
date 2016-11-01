package test.runnable;

import org.junit.Test;

import com.softtek.java.academy.threads.synchronization.UnsafePusher;
import com.softtek.java.academy.threads.synchronization.UnsafeStack;

public class UnsafePusherTest {

    @Test
    public void shouldResultBeInconsistent() {

        UnsafeStack unsafeStack = new UnsafeStack();
        UnsafePusher unsafePusher1 = new UnsafePusher(unsafeStack);
        UnsafePusher unsafePusher2 = new UnsafePusher(unsafeStack);

        unsafePusher1.start();
        unsafePusher2.start();

        try {
            unsafePusher1.join();
            unsafePusher2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println(unsafeStack.toString());
    }

}
