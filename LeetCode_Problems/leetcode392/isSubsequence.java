import java.util.Stack;

public class isSubsequence{
    public static void main(String [] args){
        String s = "abc";
        String t = "adhbkc";

        System.out.print(bruteForce(s,t));
        System.out.print(optimized(s,t));

    }
    private static boolean bruteForce(String s, String t){
        if(s.isEmpty())return true;

        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i<s.length(); i++){
            char ch = s.charAt(i);
            stack.push(ch); //pushing the character to i
        }

        for(int i = t.length()-1; i>=0; i--){ //We check from last index 

            char ch = t.charAt(i);
            char pop = stack.pop();

            if(pop!=ch){  //if not equal we push the popped value back for the next potential match
                stack.push(pop);
            }

            if(stack.isEmpty()){ //if stack is empty return true;
                return true;
            }
        }
        return false;
    }


    private static boolean optimized(String s, String t){ //optimized version
       int i = 0, j = 0; 
       while(i<s.length() && j<t.length()){ 
           if(s.charAt(i) == t.charAt(j))i++; 
           j++;
       }
       return i==s.length(); 
    }
}
