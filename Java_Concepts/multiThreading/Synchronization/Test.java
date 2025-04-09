public class Test{
    public static void main(String [] args){
        Counter count = new Counter();
        MyThread t1 = new MyThread(count);
        MyThread t2 = new MyThread(count);

        t1.start();
        t2.start();


          
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e){
            System.out.print(e.getMessage());
        }
        

        System.out.print(count.getCount());


    }
}
