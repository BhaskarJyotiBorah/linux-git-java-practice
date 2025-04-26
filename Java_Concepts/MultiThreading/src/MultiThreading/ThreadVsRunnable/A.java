package MultiThreading.ThreadVsRunnable;

/*
1. When to use Runnable Interface?
Ans: Suppose we have two classes A and B, And A extends B. And we want to Use multiThreading on it
So we will have to extend Thread class or implement Runnable interface. Since here class A already extends B. We will not be
able to extend again. Because Java does not support Multiple inheritance. That's why we implement Runnable interface
 */


public class A extends B implements Runnable{
    @Override
    public void run() {

    }
}
