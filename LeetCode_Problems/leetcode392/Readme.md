# LeetCode 392 : Is Subsequence

2 ways of solving:

## Brute Force:
 
### Using Stack:

1. We declare a stack which will take Character values.
2. create a loop and push all the characters of String s to the stack.
3. Create another loop and pop out from the check if it is similar to the the character at ith position. :
    3.1 If yes we do nothing and continue
    3.2 If no we push the popped value back into the stack
4. Finally we put a check that if my stack gets empty i return true.

EDGE CASE : for empty String s, we return true at the begining

### Time Complexity: O(m+n) m = s.length(), n = t.length();
### Space Complexity: O(m)

## Optimized:

### Using Two-pointers

1. Use two pointers i = j = 0;
2. Create a loop and check if they are equal:
    2.1 If yes increase i;
3. Increase j, j does not depend on conditions.
4. Return true only if i has reached index = s.length().
    4.1 This means all the character at s has been matched and no character is left. 
    4.2 Thus it is a subsequence.

### Time Complexity: O(m)
### Space Complexity: O(1) 
