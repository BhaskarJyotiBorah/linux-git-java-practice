# Dota2 Senate

## Intuition:

- Understand that the problems wants us to simulate a situation where each element gets a **chance** to ban the opposite team.
- If R gets the **chance**, it bans D, vice-Versa
- If for example the input String is : "RDD".
- R comes first with index 0, so it gets the **chance** to ban a D. so it bans one of the D.
- Now the next element D with index 1 gets banned, so the **chance** to ban comes to the next element, that is D with index 2. So it bans R
- So only D remains and no R. Therefore we declare Dire as the Winner.


## Approach:

- We two queues: 
    * Radiant - To store the indexes of Radiants
    * Dire - To store the indexes of Dires
- Then we create a loop and store the respective indexes in the queue.
- Then we simulate the rounds:

### Simulation: 

- We `poll()` out the elements of radiant and dire and store in `rIndex` and `dIndex` respectively.
- then we compare if `rIndex`<`dIndex` if yes, we can say that R comes first so it gets the **first chance** to ban the opponent.
    * we ban the opponent(`dIndex` polled out and we do not think about it). 
    * We store our `rIndex` in our radiant queue by adding `n` to it.
    * We add `n` so that the same senator comes back only after the current round finishes. This gives others in line a chance to act before it returns.
- else we can say D comes first and ban R.
    * We ban R and forget about `rIndex` and store the `dIndex` by adding `n`.
    * We add `n` so that the same senator comes back only after the current round finishes. This gives others in line a chance to act before it returns.
- We continue this loop until one of the `queue` gets empty.

Whichever queue gets empty first loses, and we return the other party as the winner.

## Time and Space Complexity:

- Time complexity: O(n) because we iterate through the size of the String.
- Space complexity: O(n) worse case 