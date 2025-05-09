

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "2[abc]3[cd]ef";
        System.out.println(decodeString(s));
    }
    public static String decodeString(String s){
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();
        StringBuilder currStr = new StringBuilder();
        int currNum = 0;

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                currNum = currNum*10+(ch-'0'); //Handles multi-digit number
            }else if(ch=='['){
                countStack.push(currNum);
                stringStack.push(currStr);
                currStr = new StringBuilder();
                currNum = 0;
            }else if(ch == ']'){
                int repeat = countStack.pop();
                StringBuilder prevStr = stringStack.pop();
                for(int i = 0; i<repeat; i++){
                    prevStr.append(currStr);
                }
                currStr = prevStr;
            }else{
                currStr.append(ch);
            }
        }
        return currStr.toString();
    }
}
