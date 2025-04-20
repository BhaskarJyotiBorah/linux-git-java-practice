public class Main{
    public static void main(String [] args) throws InterruptedException{
        BankAccount sbi = new BankAccount();
        Runnable task = new Runnable(){ //Anonymous inner class
            @Override
            public void run(){
                sbi.withdrawal(50);
            }

        };

        Thread t1 = new Thread(task,"Thread 1");
        Thread t2 = new Thread(task, "Thread 2");
        Thread t3 = new Thread(task, "Thread 3");

        System.out.println("Main Thread Started");

        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(500);
        t1.interrupt();
        t3.start();
        
        System.out.println("Main Thread Ended");
        
       
    }
}
