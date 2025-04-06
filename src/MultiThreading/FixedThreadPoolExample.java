package MultiThreading;

import java.util.concurrent.*;

public class FixedThreadPoolExample {
    public static void main(String[] args) {
        // Create a fixed thread pool with 3 threads
        ExecutorService executorService = Executors.newFixedThreadPool(3);

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

//Fixed Thread Pool
//A Fixed Thread Pool creates a pool of a fixed number of threads to execute tasks. When you submit a task,
//it will either:
//
//Be executed by one of the threads in the pool if one is available.
//
//Wait in the queue if all threads are busy.
//
//Key Characteristics:
//
//A fixed number of threads are maintained.
//
//Tasks are executed concurrently by multiple threads (up to the maximum number of threads).
//
//If the queue of tasks becomes too long, tasks might get delayed.
//
//Use Case:
//Useful when you know how many threads you want to use to handle tasks concurrently
//        (e.g., handling HTTP requests in a web server).
