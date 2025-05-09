# Leetcode 933
## Number of Recent Calls:

### Intuition:

- I need to store all the past `ping()` calls in a time-ordered way.
- I need to discard old ones that fall out of 3000ms.
- At each `ping()` call, i will check if all the values in the queue matches the condition for this current `t`.
- Once I do that, the number of items left is my answer.

### Approach: 

- Create an instance ``Queue<Integer> queue``
- In the Constructor initialize it as ``new LinkedList<>()`` to implement our queue.
- In the ping method:
    * We store the value of ``t`` in our queue.
    * In a loop we will check if the current element in the ``queue`` does not meet our condition ``[t-3000, t]``.
    * This condition ``while(queue.peek()<t-3000`` if true we shall eliminate the first element. 
    *  Finally we return the **size of the queue**.

### Logic behind ``[t-3000, t]``:

- The question wants us to include those values that satisfy this condition.
- Taking example : ``[1], [100], [3001], [3002]``:
     * Here we enter each of them one by one in our ping, and store it in ``queue``.
     * Then we check if the first element that we added is in the range or not:
         * ``[1-3000, 1]`` is ``[-2999, 1]`` here, `1` is at the edge but still is in the range so we won't remove it.
         * ``[100-3000,100]`` is ``[-2900, 100]`` again within range.
         * ``[3001-3000, 3001]`` is ``[1,3001]`` here `3000` and **others** are still in range so we include `3000` in the queue.
         * ``[3002-3000, 3002]`` is ``[2, 3002]`` here we will include `3002` but we can see that for `t=3002` the range is `[2,3002]` so we will have to remove anything in the queue that is out of this range.
         * So we remove `1`

## Time and Space Complexity: 

- TC : 
   * Worst-case per call: O(n) where n is number of old pings removed
   *  Amortized: O(1) per call over time
- SC is O(n), where n is the number of pings needed to store in the last 3000ms.