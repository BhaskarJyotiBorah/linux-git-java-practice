# Climbing Stairs
LeetCode #70

## Intuition:
1. The problems wants to calculate all the possibilites of climbing to the top.
2. Condition: Can climb 1 or 2 steps.
3. We can use Recursion, because it has the reputation of visiting every possible step if we make it visit properly.
4. We will also Use DP array to store the values of subproblems to reduce redundancy.

## Approach:
1. We will initialize our DP array of n+1, and fill it with -1.
2. We will create a recursive function which will take dp array and n as arguments.
3. if n<=2 we return n. why? because if n is reduced to 2 there are only 2 possiblities:

   1.Climb one by one.
   2 Climb directly two step.

5. And when there n has been reduced to 1, there is only 1 possibility, that is climb 1 by 1 only. Thus whatever the n becomes when its less or equal to 2. we make it return n only.
6. We put a condition to check if for that particular n, is n is not -1, if its not -1, that means there is some subproblem which we can return. So we return dp[n] at nth index
7. We store our possibility in our dp array. 

### The Possibility:
1. We have to think in relation to time
2. We ask , "How did I arrive here?", "What were the valid paths that led me here?", "Can I reuse the results of those paths?". 
3. We than see (n-1)th and (n-2)th step, based upon the condition given to us. 
4. The possibility is (n-1) + (n-2), so we add them and put it in our dp[n] so that we can use them when we encounter again.

## Time And Space Complexity:
1. Time complexity: Time complexity without DP is O(2^n). This is because when we observe the recursive tree structure, we see that at each level, starting from level zero: 2^0, 2^1, 2^2, 2^3 ..... 2^n , at each level the number of nodes grows at exponential rate. Thus the worst case TC is O(2^n). Also when we measure TC we focus on the growth rate of time.
2. The space complexity here is O(m) where m = n+1, because we are storing every value from n till 0, so the total length would be m = n+1. 
