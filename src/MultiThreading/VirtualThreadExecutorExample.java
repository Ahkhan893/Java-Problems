package MultiThreading;

import java.util.concurrent.*;

public class VirtualThreadExecutorExample {
    public static void main(String[] args) throws InterruptedException {
        // Create an ExecutorService that uses virtual threads
        ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();

        // Submit tasks to the executor
        for (int i = 0; i < 10; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                try {
                    // Simulate some work
                    System.out.println("Task " + taskId + " is running on " + Thread.currentThread().getName());
                    Thread.sleep(500);  // Simulate work (e.g., I/O operation)
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
       });
        }

        // Shutdown the executor
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);
    }
}
