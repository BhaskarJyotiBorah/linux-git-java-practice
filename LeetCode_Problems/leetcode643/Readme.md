# Maximum Average SubArray

LeetCode #643

## Intuition:
1. Use sliding window and calculate the first sum
2. divide by k and store it in the maxAvg
3. Create another loop where i = k till nums.length-1 and subtract the left most from the window and add the first right neighbour untill end.
4. This will give us the maxAvg.

## Approach:
1. We create a loop where we calculate the sum of first k elements.
2. Initialize maxAvg and store the first avg
3. Create another loop from i = k till i < nums.length
4. Inside update the sum to exclude first element of the subarray and inlcude first right neighbour of the subArray.
5. Finally compare the max for every iteration


## TC & SC:
1. TC: O(n)
2. SC: O(1)

