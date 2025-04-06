package MultiThreading;

import java.util.concurrent.*;

public class CachedThreadPoolExample {
    public static void main(String[] args) {
        // Create a cached thread pool
        ExecutorService executorService = Executors.newCachedThreadPool();

        // Submit tasks for execution
        for (int i = 0; i < 5; i++) {
            final int taskId = i;
            executorService.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ": Task " + taskId + " is running");
                try { Thread.sleep(1000); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
            });
        }

        // Shutdown the executor service
        executorService.shutdown();
    }
}
//Cached Thread Pool
//A Cached Thread Pool creates new threads as needed but reuses previously constructed threads when they are available.
//If a thread is idle for a certain period, it is terminated and removed from the pool. This type of pool is typically
//        used for handling a large number of short-lived asynchronous tasks.
//
//Key Characteristics:
//
//Threads are created as needed and reused if idle threads are available.
//
//If threads are idle for 60 seconds, they are terminated.
//
//        Ideal for handling many tasks that are short-lived.
//
//        Dynamic: The number of threads can grow and shrink based on demand.
//
//Use Case:
//Best for executing a large number of short tasks where you don’t need to limit the number of threads.
