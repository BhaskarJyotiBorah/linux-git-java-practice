package MultiThreading.ThreadMethods;

public class MyThread4 extends Thread{
    public void run(){
        while(true){
            System.out.println("Hello world!");
        }
    }

    public static void main(String[] args) {
         MyThread4 myThread = new MyThread4(); //User Thread (Jo hamara kaam kar raha)
         myThread.setDaemon(true);
         myThread.start();
        System.out.println("Main done");

        /*
        1. myThread.start(); -> put the thread in RUNNABLE state
        2. main Thread started and printed "Main done"
        3. myThread started and started printing "Hello World"
        4. At some point it sees myThread.setDaemon(true). That means it is a daemon Thread, Toh isko maro goli, Main Thread ended so TERMINATE
         */

    }
}
