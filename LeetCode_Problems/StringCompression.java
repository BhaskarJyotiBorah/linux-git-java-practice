

import java.util.HashMap;

public class StringCompression{
	public static void main(String [] args){
		char [] input = {'a','a','b','b','b','c','c','c','c' };
 
		System.out.println(compress(input));
	}
	public static int compress(char [] chars){
		HashMap<Character, Integer> map = new HashMap<>();

		for(char ch: chars){
			map.put(ch,map.getOrDefault(ch,0)+1);

		}
		
		StringBuilder sb = new StringBuilder();

		for(char key: map.keySet()){
			if(map.get(key)!=0 && map.get(key)!=1){
		        	sb.append(key).append(map.get(key));
	        	}else if(map.get(key)==1){
				sb.append(key);
			}
		}
                

		return sb.length();

	}
}
