public class TestingThreads{
    public static void main(String [] args){

        HelloWorldRunnable hello = new HelloWorldRunnable(); //Cannot directly use .start() method We have to create an Object of Thread class and pass the reference 
        
        Thread t1 = new Thread(hello);
        HelloWorldThread t2 = new HelloWorldThread(); //we are able to use .start() method directly here because we extend the thread class directly

        t1.start();
        t2.start();
    }
}
