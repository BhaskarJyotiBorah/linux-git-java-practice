
package DSA.DataStructures.HashMap.Problems;

import java.util.Arrays;


public class CloseStrings{
    public static void main (String [] args){
        String word1 = "cabbba";
        String word2 = "abbccc";
        System.out.println(closeStrings(word1,word2));
    }
    public static boolean closeStrings(String word1, String word2){
        //Main Trick: Don't simulate observe the pattern
        //if both string's lengths differ return false
        if(word1.length()!=word2.length())return false;

        //We can use hashMap also but this would increase the TC because of potential collisions
        //We will use two two arrays to store the characters
        int [] freq1 = new int[26];
        int [] freq2 = new int [26];

        /*
         * We are going to count the frequencies of the letters of the two words
         * We have used 0 - 26 as scale to put the frequencies
         * We subtract the ASCII value of 'a' from what ever char c becomes and store it in the respective index
         * The subtraction looks something like this: a - a = 97 - 97 = 0 index.  c - a = 2 index and like wise.
         * */

        for(char c: word1.toCharArray()){
            freq1[c - 'a']++;   // storing all the frequencies of letters in the word1 in freq1
        }

        for(char c: word2.toCharArray()){
            freq2[c-'a']++; // storing all the frequencies of letters in the word2 in freq2

        }

        for(int i = 0; i<freq1.length; i++){
            if(freq1[i]==0 && freq2[i]!=0 || freq1[i]!=0 && freq2[i]==0){
                return false;  // if any frequency that occurs of any character that is not matching in either of the arrays, we will return false. This is because there are extra unfamiliar characters
            }
        }

        //Sorting both the array's freq

        Arrays.sort(freq1);
        Arrays.sort(freq2);


        return Arrays.equals(freq1, freq2); //If both frequencies produces same result we are can return true


    }
}
