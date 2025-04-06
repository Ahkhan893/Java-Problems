package MultiThreading;

import java.util.concurrent.*;

public class SingleThreadExecutorExample {
    public static void main(String[] args) {
        // Create a single thread executor
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        // Submit some tasks
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": Task 1 is running");
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": Task 2 is running");
        });

        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + ": Task 3 is running");
        });

        // Shutdown the executor service
        executorService.shutdown();
    }
}
// Single Thread Executor
//The SingleThreadExecutor ensures that tasks are executed sequentially,
//using a single worker thread. This is useful when you need to guarantee that tasks are executed in a specific order and that only one task runs at a time.
//
//Key Characteristics:
//
//It always uses a single worker thread.
//
//If the thread is busy, the tasks are queued up until the thread is free.
//
//The tasks are executed in the order they were submitted.
//
//Use Case: Suitable for situations where tasks must be executed sequentially,
//and you don’t need parallel execution. For example, logging, database transactions, etc.