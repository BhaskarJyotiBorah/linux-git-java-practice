# Unique Binary Search Trees

## Approaches: 
1. Dynamic Programming
2. Catalan's Formula

## Intuition:
1. Total nodes = n, and we are at the root. So every node from 1 till root-1 will be smaller than root and every node from root+1 till n will be greater than root.
2. Thus using this logic we break down the problem as follows:
        1. left sub-tree calculation : root-1.
        2. right sub-tree calculation : n-root.
3. Breaking down the problem untill we reach the base case. 
4. On reaching the base case we calculate the total number of combinations and store that in a total variable.
5. Update the dp[] array with total and return total.
6. Gradually we move up the recursion tree and use dp[] look-up when necessary.

## Approach 1: Top-Down (Memoization):

### Function: numTrees(int n):
1. We create an Array of size n+1
2. We fill the array with -1;
3. Call countTrees function and return its result;

### Function: countTrees(int n, int [] dp):
1. We set the base recursive case 
2. We check if our dp array has been filled for that particular 'n'. If yes return that value please. This helps to remove redundant calculation.
3. Initialize total variable
4. Created a loop to from 1 till n. 
5. Divided the left and right subtree and calculated total upon reaching the base case.
6. When the loop ends we update the dp[] array and return the total.

### Dry run :
![Dry run](https://github.com/BhaskarJyotiBorah/linux-git-java-practice/blob/master/LeetCode_Problems/leetcode96/Dry_run.png?raw=true)


### Time Complexity: O(n^2)
1. Loop uses O(n) and inside we divide the loop from 1 till n. So Roughly about 2* O(n) for both right and left sub tree.
2. In Total its roughly about O(n^2).

### Space Complexity: O(n)
1. Uses an extra look-up array of size n+1 so its complexity would be O(n).



