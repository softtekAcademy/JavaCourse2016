package com.softtek.java.academy.threads.thread;


public class CountYieldThread extends Thread {
    
    private String message;

    public void setMessage(String message) {

        this.message = message;
    }

    @Override
    public void run() {

        for (int i = 0; i < 50; i++) {

            System.out.println(message + i);
            Thread.yield();
        }
    }
}
