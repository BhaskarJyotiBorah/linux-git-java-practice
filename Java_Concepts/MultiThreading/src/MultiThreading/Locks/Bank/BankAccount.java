package MultiThreading.Locks.Bank;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//Shared Resource
public class BankAccount {
    private  int balance = 100;
    private final ReentrantLock lock = new ReentrantLock();

    public void withdraw(int amount){
        lock.lock();
        try{
            System.out.println("Threads waiting to acquire the lock (before lock): " + lock.getQueueLength());
            System.out.println("Threads waiting to acquire the lock (after lock): " + lock.getQueueLength());
            System.out.println(Thread.currentThread().getName() + " Hold Count after locking: " + lock.getHoldCount());
            System.out.println(Thread.currentThread().getName()+ " attempting to withdraw "+ amount);

            if(balance>=amount){
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " was interrupted during sleep.");
                    return; // exit the method gracefully
                }

                System.out.println(Thread.currentThread().getName() + " has completed the waiting time and now ready to withdraw "+amount);
                balance-=amount;
                System.out.println(Thread.currentThread().getName()+ " has withdrawn "+amount+" and remaining bal is "+balance);
            }else{
                System.out.println(Thread.currentThread().getName()+ " could not borrow "+amount+ " remaining bal: "+balance);
            }
        }finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " Hold Count after unlocking: " + lock.getHoldCount());

        }
    }
}
