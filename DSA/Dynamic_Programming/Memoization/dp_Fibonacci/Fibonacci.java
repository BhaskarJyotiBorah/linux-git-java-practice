import java.util.Arrays;

public class Fibonacci{
    public static void main(String [] args){
        int n = 10;
        int [] dp = new int[n+1]; //Creating an array to store calculated sub-problems
        Arrays.fill(dp,-1);
        System.out.println(memoization(n,dp));

    }
    public static int memoization(int n,int [] dp){
        if(n<=1)return n; //Base recursive case;
        if(dp[n]!=-1) return dp[n]; //if subproblem is calculated and is stored in the array return it upon encountering the same sub-problem.
        return dp[n] = memoization(n-1,dp) + memoization(n-2,dp); //store the calculated results in the dp array.
    }
}
