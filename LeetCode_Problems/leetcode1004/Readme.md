# Max Consecutive Ones
LeetCode #1004

## Intuition:
1. Simulation: we could use simulation, but this would result in O(n^2) which would give TLE on leetcode
2. Using Sliding Window:
    1. We start from 0 and we expand our right till nums.length; 
    2. And we also calculate the length at each iteration
    3. But we also note down the number of 0's encountered. 
    4. If the number of zero exceeds the limit that is k,
    5. we reduce the k and shrink the window
    6. Finally when right exceeds the last index the loop ends
    7. We finally return the maxLen

### Why Shrink window? 
Ans: Because there are more zero's in our window than the limit that is k
### Okay which direction are we gonna shrink?
Ans: 1. We expand from right, so we are not gonna touch right
     2. We already took the count from (right-1)th index so if we shrink from right, it will produce the same calculated result.
     3. We Will Shrink from left pointer. 
### Okay Till when will we skrink?
Ans: Check if the current element at the index is 0. If yes congratulations we found the zero now we can reduce our zeroCount and shrink our window i.e. left++
.And when zero count matches k, we continue our regular expanding.
### Okay What if we do not find our 0 at first left index?
Ans: We go on shrinking until we encounter 0. If we encounter it, we reduce zero count, shirnk the window and exit the inner loop and calculate the maxLen


## Approach:
1. Initialize left, right, maxLen and zero count pointers
2. create a while loop using the right pointer
3. we check for 0 and if found we increase the count
4. we put another check that if our zero exceeds k we are going loop through our array and find the nearest 0 and decrease our count, while searching we increase our left pointer which will shrink the window.
5. Outside the inner loop we calculated maxLen for every iteration
6. And right++, to expand the window
7. We finally return the maxLen as answer.


## TC & SC:
1. TC: O(n)
2. SC: O(1)
