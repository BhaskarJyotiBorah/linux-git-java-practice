public class ClimbingStairs{
    public static void main (String [] args){
        int n = 5;
        System.out.println(climbingStairs(n));

        System.out.println(climbingStairsOptimized(n));
    }
    public static int climbingStairs(int n){
        if(n==1 || n==2) return n; //Edge cases

        int [] dp = new int [n]; //dp array to store the sub-problems
        
        dp[0] = 1; 
        dp[1] = 2;

        /*
         * The above are the smallest sub-problems i.e. the base cases : 1 step and 2 step at a time as per the question
         * */
        
        for(int i = 2; i<n; i++){
            dp[i] = dp[i-1] + dp[i-2]; //Ask How did i reach here? Ans: I either took 1 step or 2 step.
        }

       return dp[n-1]; // return the last element of the array
     
    }
   public static int climbingStairsOptimized(int n){

       if(n==1 || n==2) return n; //Edge case
       
       /*
        * Since this problem only focuses on two fixed previous states, I can space optimize them by only storing the last two elements
        * */
       int a = 1; //first sub-problem or step
       int b = 2; //Second sub-problem or step

       for(int i = 2; i<n; i++){
           int temp = a + b; //calculate the present state
           a = b; // Assign the just previous element to a
           b = temp; //Assign the current evaluated element to b;
       }

       return b; //The answer will be stored at b
   }

}
