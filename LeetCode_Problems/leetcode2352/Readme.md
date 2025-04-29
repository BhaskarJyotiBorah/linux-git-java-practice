# LeetCode Equal Row and Column Pairs
 
- This question can be solved in two ways:

## Approach 1: Array to List<Integer> Conversion

- We initialize HashMap which would take Key: List<Integer> and Value(Count): Integer.
    * We used ```List<Integer>``` instead of primitive ```int []``` because We want to compare the rows and cols as List. 
    * If we use use ```in []```, only the variable address is compared which is different for everyone.
    * To compare the arr/List by elements we will have to use ```List<Integer>``` which makes it possible to compare the elements in the Array and provide us the correct equal or not result.
- We then create a loop which will store all the rows in the map and will also note the frequencies of their appearance.
- Why use ```List<Integer> row = Arrays.stream(grid[i]).boxed().collect(Collectors.toList());```? 
    * We use this to wrap the primitive or to convert the primitive ```int []``` array into ```List<Integer>```.
    * Arrays in java don't have good ```.equals()``` and ```.hashCode()```.
    * List(```List<Integer>```) do have good ```.equals()``` and ```.hashCode()```, meaning:
       * They can be compared element-by-element
       * They can be stored properly in HashMap or HashSet.
      1. ```Arrays.stream(grid[i])``` creates a Stream of primitive ```int``` values.
           * A Stream lets us process elements one by one without manually writing loops.
           * Here we want to "Convert every int into an Integer" (Primitive - Object) easily.
      2. ```boxed()``` changes each primitive ```int``` to an Integer object.
           * Java's Collections like ```List```, ```HashMap``` ```HashSet``` -- they only work with objects (```Integer```), not with primitive(```int```);
      3. ```.collect(Collectors.toList())``` gathers all the stream elements into a new ```ArrayList```.
- After that we will create another loop and to store the columns in a ArrayList. We do this by using nested loops and storing the col values one by one.
- After we get our first column and exiting the inner loop, we do ```count+=map.getOrDefault(col,0);```.
     * This statement says that, if there exists a row/List that is same as the col that i just got, please add its frequency.
     * If not found we will add its default value 0.
- Finally We Return count.

### Time and Space Complexity:

- Time Complexity: O(n²).
    * Storing all rows + Building each column as aList and checking HashMap
- Space Complexity: O(n²).
    * Since each List stores n rows and each row has n elements

## Approach 2: Using StringBuilder:

- The main idea is same as the above appraoch.
- This approach increases the speed of the algorithm in the following areas:

### 🎯 Reason why the String approach is faster than List<Integer>:

| Aspect  | List<Integer> |  String  |
|:-------:|:-------------:|:--------:|
| Hashcode calculation| Slower | Very fast|
|Equal() comparisont| Slower | Extremely fast|
|Memory Model| Multiple Objects (Integer objects)| Single Contiguous object (String characters)|
| Boxing Overhead| Yes(int -> Integer)| No boxing needed|



