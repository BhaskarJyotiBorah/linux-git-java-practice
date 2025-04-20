# Find Pivot Index
Leetcode #724

## Intuition:
1. Since it talked about sums. First thought: Prefix / Suffix sum.
2. Roughly calculated the prefix and suffix array and found the pattern that, when prefix[i] == suffix[i] the and return i, the question is solved.
3. But how do i reduce the calculation of prefix and suffix array. The first approach that i did , was the above only.
4. The second approach given by my dear Friday.

## Approach:
1. The most optimized is Friday's approach where the SC is O(1). 
2. We start by calculating the totalSum by looping through the array.
3. We initialize leftSum, and create a loop to start from 0th index.
4. We write a relation : int rightSum = totalSum - leftSum - nums[i]. This calculates the right sum from (i+1)th index till (n-1)th index.
5. We compare if rightSum==leftSum which is our main condition of the question, if this question satisfies we return the index i.
6. We also add the elements on leftSum.
7. If we do not find the index, we return -1

## Time and Space Complexity:
1. TC of my other approach and this approach is same in worse case i.e. O(n)
2. SC of my other approach is O(n) but in this Approach it is O(1).
