package com.softtek.java.academy.threads.thread;

public class CountThread extends Thread {

    private String message;

    public void setMessage(String message) {

        this.message = message;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {

            System.out.println(message + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
