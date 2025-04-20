import java.util.concurrent.locks.ReentrantLock;

public class BankAccount{
    private int balance = 100;
    private final ReentrantLock lock =  new ReentrantLock();

    public void withdrawal(int amount){

        boolean gotLock = false; //boolean gotLock to identify if it has been locked or not
       
     try{

         lock.lockInterruptibly(); //locks (accepts and respects interrupt())
         gotLock = true; // Mark as true
    
        //Let's See Which Thread enters first:
        System.out.println(Thread.currentThread().getName()+" Attempting to withdraw "+amount);

          if(balance>=amount){
              System.out.println(Thread.currentThread().getName()+ " proceeding with the withdrawal");
              //Before final withdrawal some work is done. To simulate this we use Thread.sleep();

              try  {
                 
                  Thread.sleep(3000); //Sleeping Thread

              }catch(InterruptedException e){

                  System.out.println(Thread.currentThread().getName() + " has been interrupted"); //Prints exception message
                                                                                                   return;
              }
 
              balance-=amount; // Balance deducted
              System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining Balance: "+ balance);

          }else{
              System.out.println(Thread.currentThread().getName() + " not able to withraw due to insufficient balance");
          }
     }catch(InterruptedException e){ //Often throws interrupted exception when interrupted
         System.out.println(Thread.currentThread().getName() + " has been interrupted"); //Prints if thread gets interrupted. 
     }finally {
         if(gotLock){ //if and only if gotLock is true we unlock other wise without this, java would try to unlock a thread that was never locked in the first place. Exceptions like : IllegalMonitorStateException may have been thrown
             lock.unlock();
         }
     }


    }
}
