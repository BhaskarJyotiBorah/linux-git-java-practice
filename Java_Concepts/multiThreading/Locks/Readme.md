# Lock Interface

## The heart of explicit locking in Java:
1. It is a part of java.util.concurrent.locks
2. It is the interface that allows use to make custom locks for our programs
3. Synchronization also uses locks underneath. But it is automatic kind of lock which gives no control. It is also called Intrinsic or Monitor locks

## Concept:
1. Imagine a room where only one person(Thread) is allowed at a time - thats critical section
2. The door to room is protected by Lock.

## Important Methods:
1. lock() & unlock():
    1. A thread comes to the room and waits until the door(lock) is available.
    2. When the lock is available, it locks itself until the work is completed
    3. Upon completion of the work, it unlocks itself and pass the lock to the awaited Threads.

### OBSERVATION BankAccount class:
   1. Using BankAccount's withdrawal method without any locks or Synchronization:
       1. Threads Does not wait for each other
       2. Everything might just happen at once.
       3. Parallel execution :
           1. When balance i had 100 and suppose 3 Threads want to withdraw money
           2. Condition says if bal>=amount, only then shall u can withdraw
           3. Parallel Execution occurs Thus bypasses our balance condition
           4. For bal = 100, it the remaining bal = -50 after 3 task completed (WRONG).
           4. Total time taken = 10, expected = 30;

  2. Using withdrawal with Synchronization:
        1. Withdraw's money one thread at a time
        2. Execution : Correct
        3. Problem : Locks the thread until the whole code block is executed or the method is executed. It cause delay, other Threads have to wait for too long
  3. Using withdrawal with ReentrantLock:
        1. Thread 1 enters the lock completes the waiting time and unlocked, 
        2. Immediately thread 2 enters the lock, similarly for other threads also.
        3. It follows the locking system with more control and reduces the waiting time significantly.

2. lockInterruptibly():
    1. its a special type of lock that allows ".interrupt()" while .lock() does not.
    2. It simply means another thread can call .interrupt() on the current thread which sets the current thread as "Interrupted flag". 
    IMPORTANT: .interrupt() method does not kill the thread, its a gentle reminder that the thread is doing something interruptible so its better to end the thread. 
    3. We surround it with try catch because it might throw interruptedExceptionif it listens.
    4. Make sure to place the lock before the condition logic. And in this case we have to surround it with one more try catch because it could throw interrupted Exception
    
### Important Points to be noted in BankAccount.java class (20-04-2025)
    1. When we are using .lockInterruptibly(). we will have to use another boolean flag gotLock. Which will track if The thread was actually locked. There can arise a situation where the Thread got interruped before even locked, but the finally block will execute regardless.
    2. In the Finally block there is .unlock() which will create a problem when the Thread was not even lock in the first place. It will throw IllegalMonitorStateException.
    3. Thus it is compulsory to put a gotLock check so that if its locked only then shall it will unlock at the finally block.
    4. In the catch blocks do not throw the exception, it will end the program.
    5. Also while sleeping, in the catch block please do not throw the exception.In the inner catch block put a print statement and return from there. This was observed when T1 was interrupted.



