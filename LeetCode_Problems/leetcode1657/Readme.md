# Close Strings 
Leetcode 1657

## Intuition:
- First thought was to follow the simulation
- As i began to understand more i figured out that it is not about simulating
- There are two main Conditions that are mentioned in the question.
    * Swap two existing characters
    * Transforms the occurrence of one existing characters into another existing characters

### Concept :

- If we carefully examining the examples, I figured out that :
    * The length must be same of the both words
    * The characters of both the words must be same. There cannot be any unique character between both Strings
    * The frequency of occurrence of the characters should be equal. Eg :
        * "cabbba" & "abbccc", Here the frequencies are for the respective words are:
            * "cabbba" : c - 1, a - 2 & b - 3
            * "abbccc" : a - 1, b - 2 & c - 3
        * Here we can see the the frequencies are same i.e (1, 2, 3).
        * Even though the letter's frequency does not match, the **swapping** & **transform** operations are suppose to make it happen.
        * And this will only happen if the frequencies of both words match. (1, 2, 3)

## Approach: 
- We put a check that if lengths of both words are not equal we will return false.
- We can create HashMaps or frequency Array. To keep the TC more optimized Freq Array will be better option
- We create 2 freq array of size 26.
- We count the frequency of word1 and word2 using the ASCII count method(explained in the comments)
- We create another loop and check that if freq1 at ith index is 0 and freq is not zero and vice-versa we will return zero.
    * This means if any character exists that is unique to any one of the array will will fail our **String close** check so we return false.
- We sort the arrays and compare their equalities if they are equal we return true.


## TC & SC:

- TC is O(n log n) because the lengths should be same and Arrays.sort uses mergeSort.
- SC is O(1)
