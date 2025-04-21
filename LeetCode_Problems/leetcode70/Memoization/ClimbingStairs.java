import java.util.Arrays;

public class ClimbingStairs{
    public static void main (String [] args){
        int n = 4;
        System.out.print(climbStairs(n));
    }
    public static int climbStairs(int n){
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return canClimb(n,dp);

    
    }
    public static int canClimb(int n, int [] dp){
        if(n<=2)return n; // we make it return n because thats the number of possibilites when its reduced to two and below it.
        if(dp[n]!=-1) return dp[n]; // dp condition to check if dp[n] exists(or the subproblem exists)

        return dp[n] = canClimb(n-2,dp) + canClimb(n-1,dp); // we do n-1 and n-2, because they are the main conditions that was given to us. 
    }
}
