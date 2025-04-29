package MultiThreading.Locks.Bank;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BankAccount sbi = new BankAccount();
        Runnable task = new Runnable() { //Without creating separate class we directly use Runnable interface and it created an Anonymous inner class
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };
        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2" );
        Thread t3 = new Thread(task, "Thread 3");

        t1.start();
        t2.start();
        t3.start();





        /*
        Problem statement:
        1. Kiba kaam korisu (Thread.sleep()) in our case
        2. Then T1 takes too much time to complete its transaction
        3. T2 waits for T1 to complete.
        4. This delay is unfavorable. Therefore we are studying locks
        5. More Specifically explicit locks to give us manual control over Thread execution
        6. Synchronization is not the best option for this case. It causes delays
         */
    }
}
