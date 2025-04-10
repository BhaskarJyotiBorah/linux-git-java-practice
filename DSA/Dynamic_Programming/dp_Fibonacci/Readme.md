# Fibonacci with Dynamic Programming

1. Fibonacci series calculation can be done by recursion. But Recursion calculates the same sub-Problem many times. which often takes more time.
2. With Dynamic Programming we are able to achieve the same result much faster.

## Approach:
1. We create a regular recursion structure.
2. But we store the result of calculated sub-problem in a Data structure like Array or Hashmap. 
3. This will allow us to use the same value when we encounter the same sub-problem once again. 
4. This will eliminate the repeatitive calculation of the same sub-problem and will produce faster results.

## Detailed Breakdown of Fibonacci problem:
1. We create an Array of size n+1 and fill it with -1.
2. Inside memoization function, we write the recursive base case.
3. After we check if any of the subproblem that we have calulated and stored so far is ready to be returned or not. if dp[n]!!=-1, that means we have encountered this particular nth sub-problem before, so we return dp[n]. This reduces redundant calculation.
4. We break down the problem into sub-problems and store them in our dp[] array.

## IMPORTANT POINTS:
1. This method is called Top-Down because, we break down the problem from the top till we reach the base case and then only we store the calculated sub-problems from bottom to top.
2. The dp[] array starts storing the values when it hits the base case and gradually stores values of bigger subproblems from bottom to top.
3. In my memoization function i did not store the base cases. thus the first 2 indexes remains -1. 

## Result: n=10;
1. dp [] array: [-1,-1, 1, 2, 3, 5, 8, 13, 21, 34, 55];
2. print: 55



