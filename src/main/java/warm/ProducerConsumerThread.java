package warm;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerThread {

    Queue<Integer> Q = new LinkedList<Integer>();
    int maxSize = 10;

    public static void main(String[] args) {

        final ProducerConsumerThread producerConsumerThread = new ProducerConsumerThread();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 1; i < 50; i++) {
                    producerConsumerThread.produce(i);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    producerConsumerThread.consume();
                }
            }
        });
        t1.start();
        t2.start();

    }

    private void produce(int e) {
        while (Q.size() == maxSize) {
            try {
                System.out.println("Q is full");
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("producing " + e);
        synchronized (this) {
            Q.add(e);
            notify();
        }
        try {

            Thread.sleep(2000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
    }

    private void consume() {

        while (Q.isEmpty()) {
            try {
                System.out.println("Queue is empty");
                synchronized (this) {
                    wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int consumed;
        synchronized (this) {
            consumed = Q.poll();
            notify();
        }
        System.out.println("consuing " + consumed);
        try {

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
