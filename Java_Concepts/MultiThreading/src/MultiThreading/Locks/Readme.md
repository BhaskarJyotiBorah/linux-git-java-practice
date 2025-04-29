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
     

``` java
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

``` java
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
  ```java
  boolean tryLock(long timeout, TimeUnit unit) throws InterruptedException;
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
  
``` java
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


## IMPORTANT:

### Why do we manually interrupt a thread in catch block? And what's the better way to do it?

- So i have understood that if we **just print a message** when encountering an ```InterruptedException```, it **does nothing meaningful**.
- The important **interruption status** (the internal flag) **gets cleared and lost**.
- In real-world programming, the **interruption might be linked** to a lot of **other important operations** — operations that **depend on knowing** whether a thread was interrupted or not.
- If we just print a message, the system or the data depending on that thread will **never know** that an interruption happened.
- So, to confirm that the thread really got interrupted, we manually interrupt the thread again using ```Thread.currentThread().interrupt()```.
- (This basically **re-raises the flag**, like a **gentle tap** on the thread, telling the higher system, "Hey, I'm interrupted, handle me properly!").
- And we also added **another catch block** to catch any **other exceptions** that are not ```InterruptedException```.
- Because if we don't catch them separately, the program might **stop unexpectedly** on other types of exceptions.

``` java
        catch (InterruptedException e){
            System.out.println(Thread.currentThread().getName()+ " was interrupted");
            Thread.currentThread().interrupt();
        }catch  (Exception e){
            System.out.println("Some other exception happened: "+e.getMessage());
        }
```
### Why is it called ReentrantLock and importance about Hold Count.

#### what happens when your do multiple ```.lock()```?

- Every time a thread calls ```.lock()```, the **hold count increases by 1**.
- The **same thread** can acquire the **same lock multiple times** without blocking itself.
- Each ```.lock()``` must be matched with a ```.unlock()``` later to fully release the lock.

#### Hold Count Behavior:

- 1st ```.lock()``` → hold count = 1
- 2nd ```.lock()``` → hold count = 2
- 5th ```.lock()``` → hold count = 5
- 1 ```.unlock()``` → hold count = 4
- Only after 5 ```.unlock()``` → hold count = 0 → **lock is fully free**.

#### Behavior when other threads are waiting:

- While the hold count is **greater than 0**, **other threads cannot acquire the lock**.
- Even if 3, 10, or 100 threads are waiting, they will stay blocked **until the original thread unlocks completely** (hold count becomes 0).
- Only when **hold count = 0**, the next waiting thread can grab the lock.
- If if try to unlock a lock that has holdCount = 0 already, it will throw an ```IllegalMonitorStateException```. (What are u even trying to unlock?)

- ✅ The lock behaves like a **stack of locks** internally.
- ✅ Partial unlocking doesn't free it — **full unlock is required**.

#### Why is it called ReentrantLock?

- Reentrant means:

- > "The thread can re-enter (lock again) into the lock it already holds without getting stuck or deadlocked."```

- ✅ Normally, if a thread that already holds a lock tries to lock it again, it would deadlock itself.
- ✅ But a ReentrantLock allows the same thread to lock again and again safely.

That's why it’s called re-entrant — the thread can enter (lock) again into the protected zone without problems.

#### Final One-Line Essence:

> "ReentrantLock allows the same thread to lock itself again and again without getting stuck, but the lock is truly free only after all unlocks are done."

## Fairness of Locks:

- Fairness in locks refers to the guarantee that threads acquire a lock in order they requested it.
- A fair lock ensures **first-come-first-serve** behavior among **threads waiting** for the lock.
- A **non-fair(unfair)** lock allows **any thread** (even a newly arrived one) to acquire the lock immediately if it is available, **even if** other threads have been waiting longer.

### Characteristics
|Lock Type| Behavior                                                                                                  |
|:-------:|:----------------------------------------------------------------------------------------------------------|
|Fair lock| Threads are granted access to the lock in the order they requested it (FIFO queue).                       |
|Unfair Lock| Threads may "barge in" and acquire the lock even if they just requested it, leading to potential unfairness|

### What is Starvation?

- Starvation occurs when a thread waits indefinitely for resource (like a lock) but never acquires it because other threads keep getting preference.
- Starvation is a **risk in unfair locks**, where certain threads might **continuously be bypassed**.
- In systems with critical operations(e.g. Banking, ticket booking), starvation must be avoided at all costs.

#### How Starvation Happens:
- In an unfair lock, newer or faster threads may repeatedly acquire the lock.
- Older waiting threads might never get scheduled.
- If this continues indefinitely, the waiting thread starves -- making no progress.

#### Thread Order:

- **Fairness is based on the real-time arrival** at the lock — whichever thread calls ``lock()`` first is placed earlier in the internal waiting queue.
- **Thread names (like "Thread-1", "Thread-2", etc.) do not determine lock acquisition order.
- **If a later-created thread reaches** ``lock()`` before others, it will acquire the lock earlier — even if its thread number is higher.

 ***Example:***
 * Thread-3 reaches and calls lock() first,
 * Thread-2 reaches next,
 * Thread-2 reaches last.
Then the lock acquisition order will be:
```
Thread-3 ➔ Thread-1 ➔ Thread-2
```
even though Thread-3's name suggests it was created third.

### How to enable fairness in ReentrantLock?

- In the constructor we can either put **fairness** as ``true`` or ``false``.
#### Fair Lock:
```java
ReentrantLock fairLock = new ReentrantLock(true); //fair lock
```
#### Unfair Lock:

```java
ReentrantLock fairLock = new ReentrantLock(false); //unfair lock
```
#### Unfair lock with default constructor:

```java
ReentrantLock fairLock = new ReentrantLock(); //unfair lock

```

### Why **Unfair Lock** is the Default in ReentrantLock?

- Because in most real-world high-performance systems:
    * Performance is more important than strict fairness.
    * Unfair locks are faster than fair locks. 🚀

### why unfair locks are faster?

- In unfair lock, when a thread releases the lock:
     * The next thread doesn't have to wait in a strict queue.
     * Any active thread (even a newly arrived one) can grab the lock immediately if the CPU schedules it faster.
     * This reduces **context-switching** and improves **throughput**.
  
#### How much slower?

- Fair locks can be 5–20% slower under very heavy loads.
- In huge systems (e.g., Google servers, high-frequency trading, databases), even 5% matters a lot.

#### Simple analogy:

*  You're organizing an airport security line.

* Normally, you fast-track VIPs to avoid slowing down the whole system. (Unfair but fast.)

Only if the public complains about unfairness,
- You change to strict FIFO — slower, but fair.

##### Important

> **ReentrantLock** defaults to unfair locking to maximize performance.
Unfair locks allow threads to acquire locks immediately when available without queue management overhead, leading to faster execution.
Fair locks, while preventing starvation, add extra latency and context-switching cost, and are used only when fairness is a strict requirement.

