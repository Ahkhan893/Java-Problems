package MultiThreading;

public class MultiThreadMain {


    public static Object sharedObject = new Object();

    public static void main(String[] args) {

        SharedResources sharedResources = new SharedResources();

        System.out.println("Main Thread Started");

//        Thread newThread = new Thread(() -> {
//            System.out.println("Thread 1 is Running");
//        });
//        newThread.start();

        Runnable runnable = () -> {
            System.out.println("Thread 1 is Running");
            System.out.println(sharedObject.hashCode());
            sharedResources.setFlag(true);
            System.out.println(Thread.currentThread().getName()); //Name of Thread
            System.out.println(Thread.currentThread().getState()); //State Like RUNNABLE
            try {
                Thread.sleep(300);
                System.out.println("Thread 1 Completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };
        Thread Runnablethread1 = new Thread(runnable,"Runnable Thread1");
        Runnablethread1.setDaemon(true);
        // Concept Of Deamon set true it's running in the
        // backgroung we set true and MAIN THREAD does not wait for it.
        Runnablethread1.start();


        Runnable Thread2 = () -> {
            System.out.println("Thread 2 is Running");
            System.out.println(sharedObject.hashCode());
            System.out.println(Thread.currentThread().getName()); //Name of Thread
            System.out.println(Thread.currentThread().getState()); //State Like RUNNABLE
            try {
                Thread.sleep(300);
                while (!sharedResources.getFlag()){
                    System.out.println("Thread 1 Flag Change");
                }
                System.out.println("Thread 2 Completed");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        Thread runnableThread2 = new Thread(Thread2,"Runnable Thread 2");
        runnableThread2.start();

        System.out.println("Main Thread Completed");
    }
}
