package MultiThreading.Locks.Fairness;

import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        UnfairLockExample example = new UnfairLockExample();
        ReentrantLock fairLock = new ReentrantLock(true);
        ReentrantLock unfairLock = new ReentrantLock(false);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource(fairLock);
            }
        };


        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task,"Thread 2");
        Thread t3 = new Thread(task,"Thread 3");

        t1.start();
        t2.start();
        t3.start();


    }
}
