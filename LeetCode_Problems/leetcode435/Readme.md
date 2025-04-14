# Non-Overlapping Intervals
LeetCode #435

## Intuition: 
1. Sort the array.
2. Compare the last element of the previous interval with the first element of the current interval.
3. If condition satisfies we increase the count. 
4. If not we update second

## Approach:
1. Sort the Matrix using a custom comparator. We use Sort by end time method.
   ### NOTE:
   1. We do end-time activity selection because:
       "The earlier we finish an activity, the more free time we leave open for future ones."
       Eg: [1,4],[3,5],[0,6],[5,7],[8,9].
   2. If we do start time sorting here, The first interval would be [0,6] which would block everything else till time 6.
2. initialize count and second, count is number of intervals we need to remove, Second is the variable that will store the second element of the first interval.
3. We create a loop from the second interval and begin comparing.
4. We compare the first element of the second interval with second.
5. If the condition is true then we are going to increase count. 
6. Else we are going to update second to hold the next second element or the second element on this current interval.
7. Finally we return the count.

## IMPORTANT:
1. Why not update second at each iteration?
ANS: Because the question asks to eliminate the interval that overlaps.
2. Okay but how does it help?
ANS: suppose we encounter and overlapping pair, we increase count and move on to the second interval, we do not explicitly remove the interval, instead we just keep our second as it is. And make it compare with the other interval's first element. 
3. Why update second?
ANS: Because if they are not overlapping we don't need to count them as "Need to remove" thus we move on to check others.

## TC & SC: O(nlogn) & O(1)
