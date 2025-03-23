package MultiThreading;

public class ThreadLocal {

    public static void main(String[] args) {

        java.lang.ThreadLocal<Long> threadLocal = new java.lang.ThreadLocal<>();

        Long userIdThread1 = 232323L;
        Long userIdThread2 = 232300L;

        new Thread(()-> {
            threadLocal.set(userIdThread1);
            System.out.println("Thread 1 is Running");
            System.out.println(threadLocal.get());
            System.out.println("Thread 1 is Stopped");
            threadLocal.remove();

        }).start();


        new Thread(()-> {
            threadLocal.set(userIdThread2);
            System.out.println("Thread 2 is Running");
            System.out.println(threadLocal.get());
            System.out.println("Thread 2 is Stopped");
            threadLocal.remove();
        }).start();


        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();
        new Thread(()-> {
            inheritableThreadLocal.set("Instagram");
            System.out.println("Thread 3 is Running");
            System.out.println(inheritableThreadLocal.get());
            System.out.println("Thread 3 is Stopped");
            threadLocal.remove();

            new Thread(()->{
                System.out.println("Thread 4 is Running");
                System.out.println((inheritableThreadLocal.get()));
                System.out.println("Thread 4 is Stopped");
            }).start();
        }).start();
    }
}
