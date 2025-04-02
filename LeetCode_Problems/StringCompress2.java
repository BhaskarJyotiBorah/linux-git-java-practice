public class StringCompress2{
	public static void main(String [] args){
		char [] chars = {'a','a','a','b','b','b','c','c','c'};
		System.out.println(stringCompress(chars));

	}
	public static int stringCompress(char [] chars){
	          int writeIndex = 0;
		  int count = 1;

		  for(int i = 1; i<chars.length; i++){
			  if(chars[i-1]==chars[i]){
				  count++; //if current == previous we increase count
			  }else{
				  chars[writeIndex++]=chars[i-1]; 
				  /*
				   * We include the first character , we don't need to put 1 in the string if it has occured only 1 time
				   * We can just write it as 'a' or 'b' and not 'a1' or 'b1'
				   * For occurence 0, we do not have to even worry
				   * For occurence more than 1, we need convert the count into a string and then slowly add each digit to the char array after
				   * Only after the addition of respective count char.
				   * */

				  if(count>0){
					  String num = Integer.toString(count);
					  for(char c: num.toCharArray()){
						  chars[writeIndex++]=c;
					  }
				  }
			  }
			  
		  }


		  /*
		   * We have to include the last character separately because the above loop's pointer is one step ahead.
		   * If the count is 1, we just add the character, if the count is more than one, we do the same old digit digit addition into the char Array
		   * Finally we return the writeIndex, because thats what gives us the correct size of Array. You might be asking why not writeIndex+1? 
		   * This is because look below we did chars[writeIndex++] that means after including the last char or adding the last digit it is gonna increase itself
		   * Making it equal to the size of the required Array
		   * */


		  chars[writeIndex++] = chars[chars.length-1];
		  if(count>1){
			  String num = Integer.toString(count);
			  for(char c: num.toCharArray()){
				  chars[writeIndex++] = c;
			  }
		  }

		  return writeIndex;
			
	}

}
