package org.example;

public class MyEnqueueingTread implements Runnable{

    private BlockingQueue blockingQueue;

    public MyEnqueueingTread(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 15; i++) {
            try {
                Thread.sleep(700);
                System.out.println("Enqueued new " + blockingQueue.enqueue(new Task("Task " + i)));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
