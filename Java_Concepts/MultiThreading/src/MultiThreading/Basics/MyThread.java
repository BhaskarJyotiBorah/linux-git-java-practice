package MultiThreading.Basics;

public class MyThread extends Thread {
    //Main aru other threads are from the same class

    @Override
    public void run() {
        System.out.println("RUNNING");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread(); //New
        System.out.println(t1.getState());
        //RUNNABLE -> Either it is running or is ready to run
        //Hekarne Running nedekhai because get state enum 't running nai
        t1.start();
        System.out.println(t1.getState());
        Thread.sleep(100);
        /*
        Thread. buli call korile ami main thread'k manipulate koribo paru
         */
        System.out.println(Thread.currentThread().getState());
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());




    }
}
