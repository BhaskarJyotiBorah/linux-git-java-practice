# 394. Decode String

## Intuition:
- Use 2 stacks two store the numbers and alphabets separately.
- Use StringBuilder for fast concatenation
## Approach:

- Create numStack which will take integers and stringStack which will take StringBuilders.
- Create a StringBuilder currStr which will keep track of the final decoded string, and we will finally return this
- Create a currNum to temporarily store our number until we store them in our stack.
- We create a loop by converting the given string into a character array.
- We put 4 conditions:
     * When we encounter a number :
         * we put if condition to check if the current number character is a number and store it temporarily in currNum.
     * When we encounter the bracket ``[``
         * When we encounter ``[`` we are going to store our currNum in numStack
         * We are going to store currStr in stringStack (even if its empty-> very important step)
         * we are going to re-initialize our currStr and currNum to "" & 0.
     * When we encounter the bracket ``]``
         * When we encounter ``[`` we will proceed to our step of repeating.
         * We will pop out the value from numStack and store it in repeat variable.
         * We will pop out the StringBuilder from stringStack and store it in StringBuilder prevStr.
         * We will create a loop that will start from 0 and will go till ``repeat - 1`` and append currStr on prevStr
         * And we will finally we will store prevStr in currStr
     * When we encounter any character
         * When we encounter any character we will just append it to our currStr.
- Finally on completing the loop , we will return currStr.toString().


## Time and Space Complexity: 

- Time complexity O(n * k) -> base case O(n) but repetition is k times so O(n * k)
- Space complexity (n * K) -> because of repetition. same as TC
