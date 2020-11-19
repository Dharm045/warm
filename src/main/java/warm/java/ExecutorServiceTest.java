package warm.java;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println(200/100);
        ExecutorServiceTest executorServiceTest = new ExecutorServiceTest();
        DTO d = new DTO();
        ExecutorService executorService1 = Executors.newSingleThreadScheduledExecutor();
        Future<?> fd = executorService1.submit(() -> {
            try {
               DTO dd = executorServiceTest.prepareDTO(d);
               System.out.println("Serveice finish "+dd.status);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService1.shutdown();
        System.out.println("Getting fd");
        //fd.get();
        System.out.println("Menu Sync Response to Petpooja " + d.status);

        // create thtead pool
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        // submit task for execution
        executorService.submit(new Task1());

        // submit task for execution and hold the futur results
        Future<Integer> future = executorService.submit(new Task2()); // future is placeholder in which executor will
                                                                      // set value once task complete
        System.out.println("Over!!");
        Integer result = future.get(); // Blocked here & wait for result. We can provide max wait time in get method.
        System.out.println("result " + result);
    }

    // This task do not returns a value
    static class Task1 implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Run. I am done!");
        }
    }

    // This task returns a value
    static class Task2 implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            Thread.sleep(7000);
            return new Random().nextInt();
        }
    }

    static class DTO {
        public int value;
        public String status = "N/A";
    }

    public DTO prepareDTO(DTO dto) throws InterruptedException {
        System.out.println("prepareDTO");
        Thread.sleep(3000);
        dto.status = "DONE";
        return dto;
    }
}
