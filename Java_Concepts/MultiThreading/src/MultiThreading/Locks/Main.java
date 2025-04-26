package MultiThreading.Locks;

public class Main{
    public static void main(String[] args) {
        Counter counter = new Counter();

        //Thread 1
        Thread t1 = new Thread(()->
        {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread t2 = new Thread(()->
        {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Final count: " + counter.getCount());

    }
}
