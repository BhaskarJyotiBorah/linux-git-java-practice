import java.util.Arrays;

public class TwoSum{
	public static void main (String [] args){
		int [] nums = {2,7,11,15};
		int target = 9;
		System.out.println(Arrays.toString(twoSum(nums,target)));
	}
	public static int[] twoSum(int [] nums, int target){
		Arrays.sort(nums); //Sorted the Arrau first;
		
		int [] res = new int[2]; //Made an array of size two, because they said only 1 pair exist

		int i = 0, j = nums.length-1; //Assigned variables
		
		while(i<j){
			
			int sum = nums[i]+nums[j]; //Sum Calculation

			if(sum==target){ 
                               /*
				* We check if the sum == target, if yes we store the indexes, then we check if there exists any duplicate next to us
				* If yes we go to that index, we do this until we know that i+1 is different
				* Similarly we do it for j index to, here we just check equal elements before them that is at (j-1)th position
				* after we have found that i+1 is different and j-1 is different, we do a final increment and decrement of i and j to reach the next and 
				* previos position
				* After that loop continues
				* */


				res[0] = i;
				res[1] = j;

				while(i>j && nums[i]==nums[i+1])i++;
				while(i>j && nums[j]==nums[j-1])j--;

				i++;
				j--;
			}else if(sum>target){ //if sum>target that means we need to look for smaller element, yo j, decrease yourself
				j--;
			}else{ // we need to look for greater elements here, yo i, increase yourself
				i++;
			}
                          

		}
                 return res; //Finally we return the result
	}
}
