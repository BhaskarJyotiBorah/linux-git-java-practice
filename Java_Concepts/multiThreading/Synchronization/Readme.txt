OBJECTIVE: To Test the Use of Synchronization

PROCESS:
Counter Class: 

1. I made a class Counter with 1 private variable count = 0. On calling the method increment it, Count increases by one.
2. Also added a getCount method that returns the count.

MyThread Class:
1. Created a MyThread class that extends Thread. 
2. Created a private instance variable of Counter type and named it counter
3. Created a constructor which will take Counter as argument
4. And in the Run Method we increase the count till 1000 using a loop
5. Since we are using Counter class we can access its public method increment(). And we are using it inside the loop to increase count

Test Class:
1. Created the main function (or Thread).
2. Created an Object of Counter class and named it count.
3. Created 2 Threads t1 and t2 and passed count in their constructor
4. Initialized Multi-Threading by calling ".start()" method on both threads
5. finally printed the total count using the getCount() method.

OBSERVATIONS: 
1. I expected a behavior of getting values greater than 1000 atleast. But here i am getting values some times 223, 102, etc
2. I figured that the main method ends before t1 and t2 and thus not able to print them.
3. I used ".join()" method and surrounded by try catch to stop the main thread and complete the task of both threads
4. I observed the expected behavoior. I saw that i am getting values such as 1839, 1424, etc 
Explanation to This Observation:
1. Sometimes both Thread t1 and t2 are at count 1001 (suppose).
2. Both increase their respective counts to 1002, without knowing that the other thread has also increased it at the same time
3. This results in skipping 1 count.
4. when this process repeats 100s and thousands of time we get corrupted results.
SOLUTION: 
We use synchronized keyword or block to securely lock the thread until the whole task is complete and only then it continues with the other thread
This results is always correct results : 2000
