# Max Number of K-Sum Pairs
LeetCode #1679

## Intuition:
1. Focus on just returning the number of count
2. Sorting and two pointers will help to track each element and if sum equals k, we increase count. 
3. Finally return the count.

## Approaches:
   ### Using Sorting and Two-Pointers:
       1. Sort the Array using the built in Arrays.sort();
       2. Use two pointers to tract the sum
       3. If the sum == k, we increase the count and increase and decrease our left and right pointer.
       4. If sum > k, we decrease right pointer
       5. If sum < k, we increase left pointer
  
     ### TC & SC : O(nlogn) & O(1)

   ###  Using HashMap:
       1. initialize count variable.
       2. create a loop, in the loop, we find the complement which is k - num.
       3. For every iteration, we are looking if the complement exist in our hashmap. 
       4. In the first if statement we see if the complement exists in our hashmap and if yes is its value > 0. If greater than 0, that means we have found a pair.
       5. if the above condition is true we increment our count and we decrease the corresponding value count by 1. This is done so that we eliminate the already counted pair.
       6. if the above is false, we put our num in the hashmap. We put num and not complement because, in every iteration we are looking if the complement matches the already existing num. Thus we upadate it with num and increase its count y 1.
    ### TC & SC: O(n) & O(n)


