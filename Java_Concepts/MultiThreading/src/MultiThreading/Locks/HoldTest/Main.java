package MultiThreading.Locks.HoldTest;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Tester test = new Tester();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                test.counter();
            }
        };

        Thread t1 = new Thread(task, "Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task,  "Thread 3");
        Thread t4 = new Thread(task, "Thread 4");

        t1.start();
        Thread.sleep(100); // 100 ms delay

        t2.start();
        Thread.sleep(100); // 100 ms delay

        t3.start();
        Thread.sleep(100); // 100 ms delay

        t4.start();

    }
}
