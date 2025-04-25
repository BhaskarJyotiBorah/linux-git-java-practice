# Word Break
LeetCode #139

## Intuition: Protocol: The Banyan Method
1. What is the problem asking?
The problem wants us to break the string in such a way that each word in the list should exist. Like applepenapple, should be divided into apple, pen , apple which are the same words that the list have.
2. How are we going to do this?
We are going to check this recursively, we are going check using substring, starting from 0th index till we find the word. Eg:
        applepenapple we are going to check if a exists? no move on, does ap, exist ? no, app? no.....apple? yes. Then we are going to mark that particular word as true in our memo.
3. Wait what is memo?
Memo is going to be a map which will store our result, so that when we encounter the same word, we do not have to check it again and again, just look from the memo and return its value.
4. But we are not directly marking it true, why?
Because if we found the word, does not necessarily mean we found the other words in our list. We will have to search them up again, and if one of them is not found we will return false.
5. Basically its not about finding one word, its about finding all of the words present in the list(wordSet/wordDict)


## Approach:
1. Create two functions wordBreak and canBreak, CanBreak will be recursive.
2. Pass all the Strings, from the list to HashSet for faster lookup
3. Use a memo to store all the calculated/existing to reduce redundancy
4. In the Recursive function - we put a base case that if s length is 0, we return true. Why? because we have successfully broken down the string into valid words from the dictionary.
5. We put a check that if memo contains the key we return its value, it maybe false or true.
6. Inside the loop, we create a String prefix which stores the substring, begining from the first character till the we find any word that matches our dictionary.
7.If we find that, we move on to calculate the next part recursively, we submit the remaining part again to the canBreak function recursively.
8. We keep on searching until we encounter the base case or we never enter the first if condition(which will finally return false).
9. The result will be recursively carried upward and finally return the boolean value true or false.

## TC & SC:
1. TC: O(n^2), if no DP, it becomes O(2^n)
2. SC: O(n + k*w);
