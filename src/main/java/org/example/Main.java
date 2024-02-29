package org.example;

public class Main {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new BlockingQueue(10);
        MyDequeueThread myDequeueThread = new MyDequeueThread(blockingQueue);
        MyEnqueueingTread myEnqueueingTread = new MyEnqueueingTread(blockingQueue);

        Thread thread1 = new Thread(myEnqueueingTread);
        Thread thread2 = new Thread(myDequeueThread);

        thread1.start();
        thread2.start();
    }
}