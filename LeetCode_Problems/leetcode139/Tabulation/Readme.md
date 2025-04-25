# Word Break Using Tabulation

## Procedure:
1. Initialize a Hashset and put wordDict in its constructor. We are using a HashSet for faster look up.
2. We Initialize boolean dp array which will keep track of the sub-problems. It has a size of (n+1) because we will be using substring to solve this problem so, to satisfy  substring's property to include every letter we will have to use (n+1) array.
3. dp[0] is marked as true because:
     - an empty string can be separated from the whole and will satisfy the condition of spaced-separated sequence
     - It will be considererd a starting point of the potential dictionary word that we are looking for.
4. We create 2 loops and we put a condition:
5. We finally return dp[n]

### Loops and the condition:
1. The first starts form index 1 till n;
2. the inner loop starts from 0 everytime and goes upto (i-1)th index
3. We put a condition inside the inner loop that says that if we found that dp[j] is true and set contains our substring from j till i, we will mark dp[i] as true and we will break from our loop.

### Important:
1. At each iteration of i, we check all previous j indices. If dp[j] is true and the substring from j to i is in the dictionary, we mark dp[i] as true.
2. we return dp[n] because if the last element is true that means the last cut is valid and from j till n the word exists in the dictionary, but if not then we are sure that there cannot be a valid cut from the last dp[j] that is true till dp[n].

## TC & SC:
1. TC : O(n^2) because of two loops
2. SC: O(n+1) or O(n) beacause of two boolean array.
