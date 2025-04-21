import java.util.Arrays;

public class FibonacciBottomUp{
    public static void main (String [] args){
        int n = 5;
        System.out.println(fibonacci(n));
        System.out.println(fibonacciOptimized(n));
    }
    public static int fibonacci(int n){
        
        int [] dp = new int [n+1]; //Create an Array of size n+1 because fibonacci Series upto number n has a size of n+1.
        dp[0] = 0;
        dp[1] = 1;
        /*
         * Thinking at the base level, and figuring out the smallest sub-Problem. And they are 0 and 1. So we put them in our array at first two positions.
         * */
        for(int i = 2; i<=n; i++){ //we go till i<=5, because we want to find fibonnaci upto the given number n
            dp[i] = dp[i-1] + dp[i-2]; //The formula/Step to calculate the just next value using the previous value.
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];  //Returning the last element
    }
    public static int fibonacciOptimized(int n){
        int a = 0; //last value
        int b = 1; // last second value
        
        for(int i = 2; i<=n; i++){
            int temp = a+b; //The next number
            a = b; // Assign the last Second to the very last
            b = temp; // Assign the current evaluated number to last second
        }
        return b; // return the lastSecond(Answer)
    }
}
