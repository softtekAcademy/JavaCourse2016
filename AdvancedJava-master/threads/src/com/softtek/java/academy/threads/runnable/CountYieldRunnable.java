package com.softtek.java.academy.threads.runnable;

public class CountYieldRunnable implements Runnable {

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
