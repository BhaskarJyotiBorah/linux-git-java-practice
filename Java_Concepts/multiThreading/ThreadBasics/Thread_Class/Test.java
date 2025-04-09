public class Test{
    public static void main(String [] args){

        HelloWorld t1 = new HelloWorld(); //New State
        t1.start();  //Runnable - waiting state
        //.start is used to initialize the multi-threading process here


        HelloWorld t2 = new HelloWorld();
        t2.start();
    }
}
