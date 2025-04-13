public class MyAtoi{
    public static void main (String [] args){
        String s = "+23u4";
        System.out.println(myAtoi(s));
    }
    public static int myAtoi(String s){
       s.trim(); //Removed white spaces
       
       long ans = 0; //varible to store the converted answer
       boolean neg = false; //negative flag if encountered '-'

       for(int i = 0; i<s.length(); i++){
           
           char ch = s.charAt(i); //stored the character in ch
           
           if(i==0){ //if the first char is neg we flag as negative
               if(ch == '-'){
                   neg = true;
                   continue;
               }else if(ch == '+'){
                   continue;
               }
           }
           

           if(ch>='0' && ch<='9'){ //ch range should be between ASCII '0' - '9'
              
              int digit = ch - '0'; //Conversion of ASCII char to Integer
              ans = ans*10 + digit; //Making the number one by one

              if(neg){
                  long check = -ans;
                  if(check<Integer.MIN_VALUE){
                      return Integer.MIN_VALUE; // if when calculating suppose our ans becomes < Integer.MIN_VALUE we return Interger.MIN_VALUE;
                  }
              }else{
                  if(ans>Integer.MAX_VALUE){
                      return Integer.MAX_VALUE; //Similarly we return Integer.MAX_VALUE on meeting this condition
                  }
              }

           }else{
               break;
           }

       }

       if(neg){
           ans = -ans;
       }

       return (int) ans; 


    }
}
