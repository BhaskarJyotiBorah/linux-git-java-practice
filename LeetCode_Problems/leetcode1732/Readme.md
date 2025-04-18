# Find the Highest Altitude 
Leetcode #1732

## Intuition
1. In this problem it is told that we are given n+1 points, And the biker starts at point 0 and alt 0.
2. And and as we gradually go up the altitude gets added.
3. So by intuition this is a prefix sum question.
4. We have to initialize it our prefix with 0, because biker starts at 0 index, and max also == 0, because he won't be going underground lol.
5. We calculate the prefix sum at each iteration and calculate the max.
6. And return the max.

## Approach:
1. We initialize prefix and max.
2. We create a loop and add the the first element of nums to prefix sum.
3. We then calculate its the max.
4. Finally return max.

## Important: 
1. We add nums[i] directly to the prefix because our prefix was initialized with 0. Which perfectly fits the situation where i imagined it to be a prefix sum array.
2. we calculate max at each iteration


## TC & SC:
1. TC: O(n)
2. SC: (1)
