package com.softtek.java.academy.threads.synchronization;


public class UnsafePusher extends Thread {
    
    private UnsafeStack stack;
    
    public UnsafePusher(UnsafeStack stack) {
        this.stack = stack;
    }
    
    public void run() {
        
        for(int i =0; i <= 100; i++) {
            this.stack.push(i);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
