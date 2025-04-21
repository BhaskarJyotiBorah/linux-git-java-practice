# BOTTOM-UP (TABULATION) - DYNAMIC PROGRAMMING
## What is Tabulation(Bottom up)?
1. It is a Dynamic programming Technique where we build the solution *startin from the base case(s)*.
2. We have to fill up a DP Table iteratively.
3. No recursion, no call stack, Everything happens inside a loop.

## Deep BreakDown of the steps to solve a problem using Tabulation:
We are going to take an example of Fibonacci Series where n = 5.
1. We know that, In a Fibonacci series, to get a number at position n, we will have to add its last two numbers.
    EG: Fib(n) = Fib(n-1) + Fib(n-2).
2. Now I will ask myself, "What values do i need to start the tabulation with.?" or "What is the smallest sub-subproblem does it have?" or "What is its base case?".
3. We know that Fibonacci's base cases or smallest sub-problems are 0 and 1.
           Fib(0) = 0;
           Fib(1) = 1;
4. We initialize an Array of size (n+1). because the fibonacci series of a number 'n' has a size of 'n+1'.
5. We Tabulate the Base cases first:
           dp[0] = 0;
           dp[1] = 1;
6. We Then Loop through and array starting from the next number that we need. Tha is 2. 
       ```java
       
       for(int i = 2; i<=n; i++){
           dp[i] = dp[i-1] + dp[i-2];
       }
      
        ```
7. We build up the solution for the next number by adding the last two numbers, that we have stored in our table.

8. We finally return dp[n] or the last element. 

## Space Optimized Version:

### Thumb Rule by Friday:
"If my DP only ever looks back at a fixed number of previous states, we can compress our table and just store those few values."

### Deep Dive:
1. Since in Fibonacci series, Fib(n) depends on last two previous states we are going to use only two variables instead of using an array to store every value.
2. We use a and b to store the base cases 0 and 1.
3. We create a loop starting from 2, because we want the 3rd element or the element at second index and begin calculating:
      1. Temp: Temp stores the caluculated current element Fib(n) which is Fib(n-1) + Fib(n-2).
      2. a: a stores the just previous state of Fib(n) i.e. Fib(n-1).
      3. b: b stores the current element that we got. F(n).
      4. And the loop continues. Until the i==n. 
      
4. When the loop ends, our answer is stored in b. SO we return b.

## Time And Space complexities:
1. Without DP its TC is O(2^n). With DP(Tabulation) its O(n)
2. The Space complexities varies:
    1. The first approach has a SC of O(n+1).
    2. The second approach is Space Optimized so it has an SC of O(1).


