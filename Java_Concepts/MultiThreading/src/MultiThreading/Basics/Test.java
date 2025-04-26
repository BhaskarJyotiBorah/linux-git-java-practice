package MultiThreading.Basics;

public class Test {
    public static void main(String[] args) {
        //One thread that begins running immediately
        //This is called the main thread
        World world = new World(); //New State
        world.start(); //Runnable-waiting-(chal sakta hai, cpu e time pale run hoi jabo)

        /*
        we have to create the object of the World class and
        we will use .start() method to start the Multithreading here
         */


        WorldRunnable world2 = new WorldRunnable();
        Thread t1 = new Thread(world2);
        t1.start();

        /*
        1. If we use Runnable interface we would have to create object,
        2. Then create an object of Thread class name it as t1
        3. pass the reference variable world2 in the constructor of Thread class
        4. Use t1.start(); from Thread class
         */
        for(int i = 0; i<100000; i++){
            System.out.println("Hello");
        }
    }
}
