package MultiThreading.Basics;

public class WorldRunnable implements Runnable {

    @Override
    public void run( ) {
        for(int i = 0; i<10000; i++){
            System.out.println("Runnable");
        }
    }
}
