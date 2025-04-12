import java.util.concurrent.locks.ReentrantLock;

public class BankAccount{
    private int balance = 100;
    private final ReentrantLock lock =  new ReentrantLock();

    public void withdrawal(int amount){
       
        //Let's See Which Thread enters first:
        System.out.println(Thread.currentThread().getName()+" Attempting to withdraw "+amount);

     try{   
         lock.lockInterruptibly();
    
          if(balance>=amount){
              System.out.println(Thread.currentThread().getName()+ " proceeding with the withdrawal");
              //Before final withdrawal some work is done. To simulate this we use Thread.sleep();

              try  {
                 
                  Thread.sleep(3000); //Sleeping Thread

              }catch(InterruptedException e){

                  System.out.print(e.getMessage()); //Prints exception message
              }finally{
                  lock.unlock();
              }
 
              balance-=amount; // Balance deducted
              System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining Balance: "+ balance);

          }else{
              System.out.println(Thread.currentThread().getName() + " insufficient balance");
          }
     }catch(InterruptedException e){
         System.out.print(e.getMessage());
     }


    }
}
