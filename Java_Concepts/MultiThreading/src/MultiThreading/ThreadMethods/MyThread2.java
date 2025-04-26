package MultiThreading.ThreadMethods;

public class MyThread2 extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(10000 );
            System.out.println("Thread is running......");
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: "+e);
        }
    }

    public static void main(String[] args) {
        MyThread2 t1 = new MyThread2();
        t1.start();
        t1.interrupt();
    }
}
