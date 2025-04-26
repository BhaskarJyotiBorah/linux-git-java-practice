package MultiThreading.Basics;

public class World extends Thread {
    /*
    1. Our objective here was to print a Hello world simultaneously using multiThreading
    2. For that we will create a main class "Hello or Test"
    3. In an another class we will extend Thread and override run method
     */
    @Override
    public void run() {
        for(int i = 0; i<100000; i++){
            System.out.println("World");
        }
    }
}
