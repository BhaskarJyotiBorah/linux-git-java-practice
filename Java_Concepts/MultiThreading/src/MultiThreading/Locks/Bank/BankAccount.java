package MultiThreading.Locks.Bank;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

//Shared Resource
public class BankAccount {
    private  int balance = 100;
    private final ReentrantLock lock = new ReentrantLock();

    public void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+ " is going to acquire lock");
        try{

            if(lock.tryLock(1, TimeUnit.SECONDS)){
                if (lock.isLocked()) {
                    System.out.println("Lock is already held before trying to acquire it.");
                } else {
                    System.out.println("Lock is free, trying to acquire it now...");
                }


                try{
                    if(lock.isHeldByCurrentThread()){
                        System.out.println("Lock is currently held by " + Thread.currentThread().getName());
                    }
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
                }

            }else{
                System.out.println(Thread.currentThread().getName()+" SKIPPED AND ENDED");
            }

        }catch (Exception e){
            Thread.currentThread().interrupt();
        }

    }
}
