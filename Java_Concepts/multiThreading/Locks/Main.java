public class Main{
    public static void main(String [] args){
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
        t1.start();
        t2.start();
        t3.start();
       
    }
}
