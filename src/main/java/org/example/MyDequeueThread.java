package org.example;

public class MyDequeueThread implements Runnable{

    private BlockingQueue blockingQueue;

    public MyDequeueThread(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(500);
                blockingQueue.dequeue();
                System.out.println("Dequeued task.");
                System.out.println("BlockedQueue size is " + blockingQueue.size());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
