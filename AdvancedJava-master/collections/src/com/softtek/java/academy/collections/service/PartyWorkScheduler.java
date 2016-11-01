package com.softtek.java.academy.collections.service;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class PartyWorkScheduler {

    private Queue<WorkNotification> queue;

    public PartyWorkScheduler() {

        this.queue = new ArrayBlockingQueue<WorkNotification>(10);
    }

    public boolean addWorkNotification(WorkNotification workNotification) {

        return this.queue.offer(workNotification);
    }

    public WorkNotification getNextWorkNotification() {

        return this.queue.poll();
    }

    public WorkNotification previewNextWorkNotification() {

        return this.queue.peek();
    }

    public int notifications() {

        return this.queue.size();
    }
    

}
