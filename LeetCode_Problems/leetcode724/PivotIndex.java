public class PivotIndex{
    public static void main (String [] args){
        int [] nums = {1,7,3,6,5,6};
        System.out.print(pivotIndex(nums));
    }
    public static int pivotIndex(int [] nums){

        int totalSum = 0;
        for(int num: nums) totalSum+=num; //sum of all elements of the array

        int leftSum = 0;

        for(int i = 0; i<nums.length; i++){
            int rightSum = totalSum - leftSum - nums[i]; // This relation calculates the sum of all the right elements from i+1 till (n-1)th index
            if(rightSum == leftSum)return i; //The condition giiven in the quesiton
            leftSum+=nums[i]; //add the elements to the leftsum

        }


        return -1; //if index not found


      
    }
}
