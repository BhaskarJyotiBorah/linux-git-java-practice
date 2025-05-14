# Plus One

## Intuition : 

- First I tried to simulate what was told in the question by converting the elements into a number and then adding one.
- It was correct but caused Integer Overflow.
- Could not use any other data type except Big Integer which is not allowed on Leetcode
- So the next approach was to directly modify the array

## Important points to remember :

- Only 9 is the most important element here.
- If the last element is not 9 and since we are adding 1, we can just return the digits array by adding 1 to its last element
- If last digit is 9, we will have to replace the last digit with 0 and carry the 1 in the next iteration
- Again in the next iteration we will repeat this process.

## Approach:

- We Will loop through the array from the last till first.
- We will check if the last element is `<9` if yes we will simple add 1 and return the digits array
- if the last element is 9, we replace it with 0 and carry 1 over to the ext digit. In the next iteration the same will repeat.
- If the array contains all 9, or the `digits` array is not returned, then upon exiting the loop we create a new array of size `digits.length + 1`and add 1 at the very first.
- Finally we return it.

## Time and Space Complexity: 

- TC is O(n) worse case 
- SC is O(n) worse case