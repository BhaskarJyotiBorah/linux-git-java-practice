import java.util.Arrays;

public class TwoSum{
	public static void main (String [] args){
		int [] nums = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums,target)));
	}
	public static int[] twoSum(int [] nums, int target){
		 //Can't sort the numbers because i need thier indexes.

		 for(int i = 0; i<nums.length-1; i++){ // start from i at first and j at second
			 
			 for(int j = i+1; j<nums.length; j++){ //j starts immediate right of i, that is one step ahead
				 
				 int sum = nums[i]+nums[j]; // we store sum in a variable sum

				 if(sum==target){
					 return new int[] {i,j}; // if we encounter target... Our job is done, return and exit
				 }
			 }
		 }
                 return new int [] {-1,-1}; //Atlast i will have to return something.. because of the return type
	}
}
