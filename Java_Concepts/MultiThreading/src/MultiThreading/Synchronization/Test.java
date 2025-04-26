package MultiThreading.Synchronization;



public class Test {
    public static void main(String[] args) {
        Counter counter = new Counter();
        MyThread t1 = new MyThread(counter);
        MyThread t2 = new MyThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(counter.getCount());

    }
    /*
    Here we are sharing one object counter in multiple threads
    1. Few cases may Arise:
       **Since both are trying to increase the Count One count maybe behind or ahead of the other**
       BUT IN THIS PARTICULAR CASE:
       a) Total limit of Thread 1: 5
       b) Total limit of Thread 2: 5

       Thread 1 at 3rd iteration -> count = 4
       Thread 2 at 3rd iteration -> count = 4+1 = 5.
       It skipped one iteration.
       if they both meet at the same count

       if Thread 1 is ahead lets see:
      Thread :   iteration:   count:
          1         0             1
          1         1             2
          2         0             3
          1         2             4
          2         1             5
          2         2             6
          1         3             7
          1         4             8
          2         3             9
          2         4             10
       This is an example where Threads increase count but not simultaneously

       Thread :   iteration:   count:
          1         0             1
          1         1             2
          2         0             3
          2         1             4
        (1,2)       2             5
          1         3             6
        (2,1)       4             7

        This is an example Where Threads increase count simultaneously which leads to
        increment in count in wrong order.
        1. Here 1,2 occurred and hence it increased the iteration and count simultaneously.
        2. This skipped Thread 2's incomplete count.


        TO SOLVE THIS PROBLEM WE USE SYNCHRONISATION, Where when one Thread's method is executing
        The other thread must wait for it.
        If Thread1 is doing its work, Thread2 should wait for Thread1 to complete its action before Thread2 starts its action
        TO USE SYNCHRONISATION:
        1. Simply use Synchronized Keyword in the method that is shared by both the threads
        2. Now it will  


     */

}
