public class MaxConsecutiveOnes{
    public static void main (String [] args){
        int [] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(longestOnes(nums,k));
    }
    public static int longestOnes(int [] nums, int k){
        int left = 0, right = 0, maxLen = 0, zeroCount = 0;
        
        while(right<nums.length){

            if(nums[right]==0){  //counts if the current element is zero
                zeroCount++;
            }

            while(zeroCount>k){ // If zero's exceeds the limit, we shrink and decrease zeros
                if(nums[left]==0){
                    zeroCount--;
                }

                left++;
            }

            maxLen = Math.max(maxLen,right-left+1); // Calculating the maxLen
            right++; // Expanding the window
        }

        return maxLen;
    }
}
