# Longest Subarray of 1's after deleting One element
Leetcode 1493

## Intuition:
1. This problem is 98 % similar to Leetcode #1004
2. In the other problem we were given a value k, which was the maximum 0's that could fit inside the window
3. Here the maximum 0 is 1. Anything more than 1 will result in shrinking of the window till we reach our first zero while incrementing left.
4. In the other problem we were calculated the total length including the 0. Because the other problem told us to flip the 0's and count them. 
5. In this problem we were told to delete the zero and that means we should not count it.
6. The rest are same as problem number 1004.

## Approach
1. We initialize left, right, maxLen, countZero.
2. We create a loop and check if the current element is 0, if yes then we found our zero that should be deleted
3. We put a check that if countZero>1 then we are going to shrink the window until we find the first zero. When we find it, we are going to decrease our countZero, in the meanwhile our left pointer will increase that means window will shrink.
4. Finally we calculat maxLen at each position.
5. We return the maxLen 
### IMPORTANT:
1. In this problem, our max 0 limit is 1. Anything greater than it should be reduced, and as a result window will shrink finding the extra zero from left.
2. Here we are asked to calculate the length by deleting the zero that we found. Thus we are not going to include the zero as well.

# TC & SC:
1. TC : O(n)
2. SC : O(1)
