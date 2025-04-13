# String to Integer:
LEETCODE #8

## Intuition:
1. Convert the String using ASCII approach using a loop.
2. Handle the edge cases efficiently

## Approach
1. trim the String to remove any white spaces
2. initialize the long var and a bool negative to store and track negative
3. create a loop and form the base condition:
    3.1 ch lies between ASCII '0' till '9' : we are going to convert them into integers
    3.2 This is done by int digit = ch - '0'.
    3.3. Please note thatt ch starts from 48 till 57. So if suppose we encounter 4. Then digti would be int digit = 52-48 = 4 (in integer).
    3.4 We are subtracting directly the ASCII value to obtain the integer value.
    3.5. We build our number by this algo: ans = ans * 10 + digit.
4. Now we deal with the edge cases:
    ### Edge Case Handling:
        1. check if the value is positive or negative:
            1.1 we check if the first index contains '-' or '+' if we find '-' we mark the flag neg as true and continue;
            1.2 if we found '+' we just continue.
            1.3 If suppose we encounter 2 signs one after the other. It will only consider the first index and from the next index it is going to check if ch belongs to '0' till '9' and since the next index is another sign like '-' or '+' it will enter the else condition and break the loop. And will return 0.
        2. Check for out numbers greater than Max and Min Integer value: 
           2.1 For this we put a check just after ans conversion.
           2.2 We first check if we hit the negative value. If yes. Then we better convert it to negative(it was not negative till now , only the flag is). We do check  = -ans. And compare if check<Integer.MIN_VALUE, if yes we return Integer.MIN_VALUE.
           2.3 if its a positive number we just have to check if ans is exceeding the Integer.MAX_VALUE limit. If yes return the Integer.MAX_VALUE.
        3. After the loop we finally again check if our boolean is true, if yes we update our ans to negative and return as (int) ans;

        4. IMPORTANT: we used another variable long check to convert it into negative to check Integer is exceeding or not because if we directly convert it into ans = -ans, the conversion would be corrupted. 
        5. We are using long to avoid any potential case of exceeding Integer limit while conversion.
 
## Time Complexity: O(n)
## Space Complexity: O(1)
