import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class WordBreak{
    public static void main(String [] args){
        String s = "applepenapple";
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");

        System.out.println(wordBreak(s,list));
    }
    public static boolean wordBreak(String s, List<String> wordDict){
        Set<String> wordSet = new HashSet<>(wordDict); //pass the list into a hashSet for a faster lookup
       Map<String, Boolean> memo = new HashMap<>(); //memo to store the subproblem
       return canBreak(s,wordSet,memo);

    }
    private static boolean canBreak(String s, Set<String> wordSet, Map<String, Boolean> memo){
        if(s.isEmpty())return true; //base case
        if(memo.containsKey(s))return memo.get(s); //dp case

        for(int i = 1; i<=s.length(); i++){
            
            String prefix = s.substring(0,i); // prefix

            if(wordSet.contains(prefix)){
                
               String suffix = s.substring(i); //suffix

               if(canBreak(suffix,wordSet,memo)){
                   memo.put(s,true); // if enters, that means it exists, thus update memo
                   return true; // And return true;
               }

            }
        }

        memo.put(s,false); // if reach here, that means not found thus update false
        return false; //And return false;

    }
}
