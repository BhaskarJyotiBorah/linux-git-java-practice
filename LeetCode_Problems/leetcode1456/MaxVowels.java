public class MaxVowels{
    public static void main(String [] args){
        String s = "weallloveyou";

        System.out.println(maxVowels(s,7));

    }
    public static int maxVowels(String s, int k){
        boolean [] vowels = new boolean[26]; // 26 size boolean array
        vowels['a' -'a'] = true;
        vowels['e' - 'a'] = true;
        vowels['i' - 'a'] = true;
        vowels['o' - 'a'] = true;
        vowels['u' - 'a'] = true;
        //Marked the vowels as true

        int count = 0;
        
        for(int i = 0; i<k; i++){ 
            if(vowels[s.charAt(i)-'a']){ //check and increament count
                count++;
            }
        }
        
        int max = count; //initial max

        for(int i = k; i<s.length(); i++){
            if(vowels[s.charAt(i-k)-'a']){ //if first char at substring is vowel, we need to remove it from our count, indicating right movement of window
                count--;
            }
            if(vowels[s.charAt(i)-'a']){ //if the right neighbouring element is vowel then we are going to increment count, indicating right movement of window
                count++;
            }
            max = Math.max(count,max); //max evaluator
        }

        return max; //returning result
    }
}
