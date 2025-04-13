import java.util.Arrays;
import java.util.HashMap;

public class MaxSumPair{
    public static void main(String [] args){
        int [] arr = {1,2,3,4};
        System.out.println(maxkSum(arr,5));
        System.out.print(maxkSumHashMap(arr,5));
    }
    public static int maxkSum(int [] nums, int k){
        Arrays.sort(nums); //Sorted the Array;
        int left = 0, right = nums.length-1;
        int count = 0;

        while(left<right){
            int sum = nums[left]+nums[right];
            if(sum==k){ //if k = sum we increment count
                count++;
                left++; //we increase and decrease left and right because we consider them pairs and we are asked to remove them
                right--;
            }else if(sum>k){
                right--; //if sum>k we do right--, (Array is sorted)
            }else{
                left++; //Same as above
            }
        }
        return count;
    }
    public static int maxkSumHashMap(int [] nums, int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;

        for(int num: nums){
            int complement = k-num; //calculates the complement
            
            if(map.getOrDefault(complement,0)>0){ //if complement is present and its value > 0 that means we have a pair, we will increase count. 
                count++;
                map.put(complement,map.get(complement)-1); //We will decrease the pair count to eliminate the pair.
            }else{
                map.put(num,map.getOrDefault(num,0)+1); //if the complement does not exist that means we have to add the num, (because we are looking for that num that becomes complement in the next iteration).
            }
        }
        return count; //finally we return count
    }
}
