# Climbing Stairs Using Tabulation(Bottom-up)
Leetcode #70

## Important points:
1. The question can be solved in many ways:
   1. With dp array:
     * dp with n+1 size & loop till i<=n 
        - This produces an extra element at the end
     * dp with n size & loop till i<n
        - this does not , but will have to manually adjust the edge cases like if n==1 and n==2.
   2. Space Optimized version:
     * version with i<=n, we will have to return a, not b (extra b calculation)
     * version with i< n, we can return b, no extra calculation, but will have to adjust the edge cases like when n==1 || n==2 return n;
2. Time and space complexity: 
   1. dp array : O(n) & O(n)
   2. space optimized version : O(n) & O(1)

## Key Takaways:
   1. I can design my solution however i can, there is no "FIXED" solution.
   2. Look for Redundant/unnecessary calculations and remove them for optimized solution.
