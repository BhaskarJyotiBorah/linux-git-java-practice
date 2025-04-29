package MultiThreading.Locks.Fairness;

import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {


    public void accessResource(ReentrantLock lock){
        long startTime = System.currentTimeMillis(); //recording when thread started trying
        lock.lock();
        try{
            long acquiredTime = System.currentTimeMillis(); //recorded when thread actually acquired lock
            long waitedTime = acquiredTime-startTime; // calculated the waited time

            System.out.println(Thread.currentThread().getName() + " acquired the lock in "+waitedTime+" ms");
            Thread.sleep(1000);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }finally {
            System.out.println(Thread.currentThread().getName() + " released the lock");
            lock.unlock();
        }
    }
}
