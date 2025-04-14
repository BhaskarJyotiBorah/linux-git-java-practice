public class MaxAvgSubArray{
    public static void main (String [] args){
        int [] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAvg(nums,4));

    }
    public static double findMaxAvg(int [] nums, int k){
        
        double sum = 0; //We need it in decimal
        for(int i = 0; i<k; i++){
            sum+=nums[i];
        }
        double maxAvg = sum/k;  //Store the first avg
        for(int i = k; i<nums.length; i++){
            sum = sum - nums[i-k]+nums[i]; //i increases thus i-k
            maxAvg = Math.max(sum/k,maxAvg);
        }

        return maxAvg;
    }
}
