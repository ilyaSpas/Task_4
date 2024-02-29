package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {

    private final Queue<Object> blockingQueue;

    private final int capacity;

    public BlockingQueue(int capacity) {
        this.blockingQueue = new LinkedList<>();
        this.capacity = capacity;
    }

    public synchronized Object enqueue(Object element) throws InterruptedException {
        while (blockingQueue.size() == capacity) {
            wait();
        }
        if (blockingQueue.isEmpty()) {
            notify();
        }
        blockingQueue.add(element);
        return element;
    }

    public synchronized Object dequeue() throws InterruptedException {
        while (blockingQueue.isEmpty()) {
            wait();
        }
        if (blockingQueue.size() == capacity) {
            notify();
        }
        return blockingQueue.poll();
    }

    public synchronized int size() {
        return blockingQueue.size();
    }
}
