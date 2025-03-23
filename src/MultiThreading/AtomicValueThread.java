package MultiThreading;

import java.security.PublicKey;
import java.util.concurrent.atomic.AtomicInteger;

class AtomicClass{
    public  AtomicInteger atomicInteger = new AtomicInteger(0);
    //atomicInteger get Value where we use single variable in two different threads
    // and we get the latest updated value we use AtomicInteger class -->AtomicInteger.png


    public void inrement(){
        atomicInteger.incrementAndGet();
    }

    public int getInrementalValue(){
        return atomicInteger.get();
    }
}

public class AtomicValueThread {


    public static void main(String[] args) {

        AtomicClass atomicValueThread = new AtomicClass();
        new Thread(() -> {
            System.out.println("Thread 1 Start");
            for(int i  = 0 ; i<5000 ; i++){
                atomicValueThread.inrement();
            }
            System.out.println("Thread 1 Completed");
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2 Start");
            for(int i  = 0 ; i<5000 ; i++){
                atomicValueThread.inrement();
            }
            System.out.println("Thread 2 Completed");
            System.out.println(atomicValueThread.getInrementalValue());
        }).start();
    }
}
