# Locks

## Overview:
- This is the heart of explicit locking in java.
- It is a part of java.util.concurrent.locks
- It is the interface that allows us to make custom locks for our programs
- Synchronization also uses locks underneath. But it is automatic kind of lock which gives no control. It is also called intrinsic or Monitor locks.


## ReentrantLock:
- **ReentrantLock** is one of the implementation classes of Lock.

### Methods:
- lock() & Unlock : 
     * Behavior : Acquires the lock. **Waits forever** until becomes available
     * Use Case : When you are okay with threads waiting as long as necessary.
     * Blocking : Yes(waits indefinitely).
     * Interruptible: ❌ No. If stuck waiting, it cannot be interrupted.
     * **IMPORTANT** : 
         * After lock(), you must use unlock() inside a finally block.
         * Reason: If an exception occurs inside the critical section, finally ensures the lock is still released safely.
     

``` 
lock.lock();
try {
    // critical section
} finally {
    lock.unlock();
}
```
- unlock()
    * Behavior: Release the lock
    * Use case: Always call it after acquiring the lock.
    * Blocking: ❌ No (instant).
    * Interruptible: ❌ No (instant).
    * **IMPORTANT** : 
         * unlock() must only be called after you successfully acquired the lock.
         * Always place it inside a finally block to guarantee release.
 
- tryLock()
    * Behavior: Always place it inside a finally block to guarantee release.
        * If available → acquires the lock and returns true.
        * If not → skips and returns false.
    * Use case: When you don't want threads to wait. You want to try once and either proceed or move on.
    * Blocking: ❌ No (instant check).
    * Interruptible: ❌ No.
    * **IMPORTANT** :
         * No need for try-catch unless your logic inside the critical section might throw exceptions.
         * Still use finally after successful tryLock() to safely unlock().

```
if (lock.tryLock()) {
    try {
        // critical section
    } finally {
        lock.unlock();
    }
} else {
    // could not acquire the lock, do something else
}
```


- tryLock(timeout, TimeUnit) :
  ```
  boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException
  ```
  * Behaviour : 
      * Tries to acquire the lock.
      * Waits for the specific maximum time (timeout) if the lock is currently held by another thread.
      * If lock becomes available during the wait → acquires and returns true.
      * If time runs out without getting the lock → returns false.
      * If interrupted while waiting → throws InterruptedException.
  * Use Case: 
      * When you want to give a thread some time to get the lock but don’t want it to wait forever.
      * Useful when long waiting is risky (like real-time systems, banking, APIs).
  * **IMPORTANT** : 
      * You must surround it with a try-catch block for InterruptedException.
      * If lock is acquired, always unlock it inside a finally block to avoid deadlocks.
      * It’s a middle ground between:
          * lock() (wait forever)
          * lock() (wait forever)
  
```
try {
    if (lock.tryLock(2, TimeUnit.SECONDS)) {
        try {
            // critical section
        } finally {
            lock.unlock();
        }
    } else {
        System.out.println(Thread.currentThread().getName() + " could not acquire the lock after waiting.");
    }
} catch (InterruptedException e) {
    System.out.println(Thread.currentThread().getName() + " was interrupted while waiting for the lock.");
}

```



- lockInterruptibly()
    * Behavior: Like lock(), waits to acquire the lock, but can be interrupted during waiting.
    * Use case: When you want threads to be able to give up waiting if interrupted.
    * Blocking: ✅ Yes (but can be interrupted).
    * Interruptible: ✅ Yes (throws InterruptedException).
    * **IMPORTANT** : 
        * You must wrap lockInterruptibly() inside a try-catch to handle InterruptedException.
        * Still use finally to safely unlock() after locking.
```
try {
    lock.lockInterruptibly();
    try {
        // critical section
    } finally {
        lock.unlock();
    }
} catch (InterruptedException e) {
    // thread was interrupted while waiting for the lock
}
```

### Diagnostic Methods in ReentrantLock
- isLocked():
   * Checks if any thread currently holds the lock.
   * Returns true if the lock is held by anyone, false if free.
- isHeldByCurrentThread():
   * Checks if the current thread (your thread) holds the lock.
   * Returns true if this thread holds it, else false.
- getHoldCount():
   * Returns the number of times the current thread has acquired the lock without unlocking.
   * Useful for reentrant behavior (where the same thread can lock multiple times).
- getQueueLength():
   * Returns the approximate number of threads waiting to acquire the lock.
   * Gives an idea of how much "traffic" is waiting.
        