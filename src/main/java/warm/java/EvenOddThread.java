package warm.java;

public class EvenOddThread {

    int number = 0;

    public static void main(String[] args) {
        final EvenOddThread evenOddThread = new EvenOddThread();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    evenOddThread.printEven();
                }

            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    evenOddThread.printOdd();
                }

            }
        });
        t1.start();
        t2.start();
    }

    private void printEven() {

        while (number % 2 == 1) {
            synchronized (this) {
                System.out.println("waiting for even");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("even " + number);
        synchronized (this) {
            number++;
            notify();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private void printOdd() {
        while (number % 2 == 0) {
            System.out.println("waiting for odd");
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("odd " + number);
        synchronized (this) {
            number++;
            notify();
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
