# Maximum Number of Vowels in a Substring of Given Length
Leetcode #1456

## Intuition:
1. Create a Lookup table for vowels.
2. count the number of vowels for the first window of size k
3. We assign the first count to be equal to max
4. Create another loop and check if the first character at the substring is a vowel if yes decrease count by one indicating shift in window towards right
5. Again check if the right neighbour is a vowel from the lookup, if yes we are going to increase the count indicating shift in window towards right.

## Approach:
Lookups: 
1. HashSet:
   1. Just include the characters one by one.
   2. Slow due to collision
2. boolean array:
   1. Use a boolean array of size [26]
   2. mark the vowels to be true:
       1. Characters are internally stored as ASCII
       2. we want the 26 letters only thus we include them manually
       3. 'a' to 'z' are contiguous in ASCII
       4. 'a' - 'a' = 0 and 'z' - 'a' = 25. Using this we mark all the vowels to be true.
### IMPORTANT:
       ASCII : 
       1. 'a' -> 97
       2. 'b' -> 98
       .
       .
       .
       26. 'z' -> 122
1. Why do we have to subtract 'a' and use new boolean[26] instead of directly usingthem?
Ans: Without new boolean[26], new boolean[128] would also work, [128] contains all the standard ASCII characters which includes control characters, spaces, symbols, alphabets and everything. Technically we can use this array also to solve our problem. There are 3 main reasons not to:
    1. Memory Optimization: 128 and 26, 26 more memory efficient
    2. Avoiding Noise(Clarity & Safety): Includes only the 26 alphabets not other characters this reduces the noise
    3. Using 'c' - 'a' guarantees 0<=index<=25.
2. Why vowels[c] is risky?
Ans: if a weird character comes, we would need a bigger array, otherwise it could produce ArrayOutOfBounds 

### Using 'c' - 'a' keeps my index small, safe and inside bounds when we are working with lowercase letters only.

3. Create a loop and check if our the character is a vowel, if yes we increase the count. We do this for a window size k
4. initialize max = count because, this is the current max that we have.
5. Create another loop starting from k and then check if the first element of the window is a vowel, if yes we are going to decrease the count.
6. We put another check that if our right neighbouring character is a vowel we will increase the count.
7. we will put a Math.max function to compare the maximum and update the max.
8. Finally we return the max.

## TC & SC:
1. TC: O(n)
2. SC: O(1)

