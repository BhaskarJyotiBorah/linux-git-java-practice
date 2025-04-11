import java.util.Arrays;

public class UniqueBST{
    public static void main(String [] args){
        int n = 4;
        System.out.print(numTrees(n));
    }
    public static int numTrees(int n){
        int [] dp = new int [n+1]; //Creating the dp array
        Arrays.fill(dp,-1); //Make every element -1;
        return countTrees(n,dp); 

    }
    private static int countTrees(int n, int [] dp){
        if(n==0 || n==1) return 1; //Base Recursive case
        if(dp[n]!=-1) return dp[n]; //Check if dp contains pre-calculated results

        int total = 0; //to store the total number of combinations.

        for(int root = 1; root<=n; root++){ // Start from first root till n
            int left = countTrees(root-1, dp); // Calculate left-subTree
            int right = countTrees(n-root, dp); //Calculate right- subTree

            total+=left*right; //Store the total combinations
        }
        
        dp[n] = total; //Update dp array
        return total; //return total
    }
}
