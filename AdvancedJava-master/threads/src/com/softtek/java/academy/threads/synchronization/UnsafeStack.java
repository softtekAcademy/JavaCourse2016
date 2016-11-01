package com.softtek.java.academy.threads.synchronization;

public class UnsafeStack {

    private int[] values = new int[100];

    private int index = 0;

    public void push(int x) {

        if (index <= 99) {

            values[index] = x;
            Thread.yield();
            index++;
        }
    }

    public int pop() {

        if (index > 0) {
            index--;
            return values[index];
        } else {
            return -1;
        }
    }

    public String toString() {

        String reply = "";
        for (int i = 0; i < values.length; i++) {
            reply += values[i] + " ";
        }
        return reply;
    }
}
