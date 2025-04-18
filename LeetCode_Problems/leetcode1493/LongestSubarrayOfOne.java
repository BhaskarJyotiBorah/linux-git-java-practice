public class LongestSubarrayOfOne{
    public static void main(String [] args){
        int [] arr = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(arr));
    }
    public static int longestSubarray(int [] nums){
        int left = 0, right = 0, maxLen = 0, countZero = 0; 
        
        while(right<nums.length){
            if(nums[right]==0){  //Put a check to see if our element is 0
                countZero++;
            }

            while(countZero>1){ // if exceeds 1, we are going to shrink and decrease count
                if(nums[left]==0){
                    countZero--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left); //Calculate maxLen but do not include 0, because we are deleting the 0
            right++; //Expand window
        }

        return maxLen; //return the length
    }
}
