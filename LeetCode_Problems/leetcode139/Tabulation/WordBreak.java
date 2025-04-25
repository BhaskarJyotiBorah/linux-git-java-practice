
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;


public class WordBreak{
    public static void main (String [] args){
        String s = "applepenapple";
        List<String> list = new ArrayList<>();
        list.add("pen");
        list.add("apple");
        System.out.println(WordBreakTabulation(s,list));

    }
   public static boolean WordBreakTabulation(String s, List<String> wordDict){
       int n = s.length();
       HashSet<String> set = new HashSet<>(wordDict); //for faster look-up
      
       boolean [] dp = new boolean [n+1]; //Create a new boolean dp to track the sub-problems
       dp[0] = true; //empty string is considered valid for starting segmentation

       for(int i = 1; i<=n; i++){
           for(int j = 0; j<i; j++){
               if(dp[j] && set.contains(s.substring(j,i))){
                   dp[i] = true; // Marking the end letter of the found word
                   break; //break because we found it
               }
           }
       }

       return dp[n]; // we return dp[n] because it tells us whether the entire string s[0----n-1] can be segmented into valid dictionary words

   

    }
}
