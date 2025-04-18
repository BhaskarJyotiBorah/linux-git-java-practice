class HighestAltitude{
    public static void main (String [] args){
        int [] arr = {-5,1,5,0,-7};
        System.out.println(largestAltitude(arr));
    }
    public static int largestAltitude(int [] nums){
        int prefix = 0, max = 0;
        
        for(int i = 0; i<nums.length; i++){
            prefix+=nums[i];
            max = Math.max(prefix,max);
        }
        return max;
    }
}
