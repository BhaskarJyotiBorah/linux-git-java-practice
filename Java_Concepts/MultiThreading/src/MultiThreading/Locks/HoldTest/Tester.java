package MultiThreading.Locks.HoldTest;

import java.util.concurrent.locks.ReentrantLock;

public class Tester {
    private int count;
    private final ReentrantLock lock = new ReentrantLock();

    public Tester(){
        this.count = 0;
    }

    public void counter(){



        lock.lock();
        System.out.println("====================================================");
        System.out.println("In queue after entering the first lock: " +lock.getQueueLength());

        System.out.println(Thread.currentThread().getName() + " is entering 1st layer, Hold count: "+ lock.getHoldCount());

        lock.lock();
        System.out.println(Thread.currentThread().getName() + " is entering 2nd layer, Hold count: "+ lock.getHoldCount());

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " has been interrupted");
            Thread.currentThread().interrupt();
        }
        count++;
        System.out.println("INCREASED ACTUAL");
        System.out.print(Color.RED);
        System.out.println("COUNT: "+count);
        System.out.print(Color.RESET);

        lock.unlock();
        System.out.println(Thread.currentThread().getName() + " is exiting 1st layer, Hold count: "+ lock.getHoldCount());
        System.out.println(Thread.currentThread().getName() + " is exiting 2nd layer, Hold count: "+ lock.getHoldCount());

        System.out.println("In queue before exiting the last lock: " +lock.getQueueLength());
        lock.unlock();
//        lock.unlock();  IllegalMonitorStateException

    }


}
