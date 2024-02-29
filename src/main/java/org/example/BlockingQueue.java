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
        blockingQueue.add(element);
        notifyAll();
        return element;
    }

    public synchronized void dequeue() throws InterruptedException {
        while (blockingQueue.isEmpty()) {
            wait();
        }
        blockingQueue.poll();
        notifyAll();
    }

    public synchronized int size() {
        return blockingQueue.size();
    }
}
