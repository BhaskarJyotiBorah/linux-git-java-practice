public class CanPlaceFlowers{
    public static void main(String [] args){
        int [] nums = {0,0,0,0,1,0,1};
        int n = 2;
        System.out.print(canPlaceFlowers(nums,n));
    }
    public static boolean canPlaceFlowers(int [] nums, int n){
        
        /*
         * We have to consider few basic edge case
         * 1. When we are at the beginning of the Array
         * ->  0[0,0,0,1,0,1]0
         *  1.1 We consider a 0 to the left of ith index when i = 0;
         *  1.2 we consider a 0 to the right of ith index when i = nums.length-1;
         *
         * */

        int i = 0;
        while(i<nums.length){
            int prev = (i==0)?0:nums[i-1]; //if it is at i==0, we will consider the 0 at -1th index else the element previous to the current
            int next = (i==nums.length-1)?0:nums[i+1]; // if it is at i==nums.length-1, we consider the 0 at the index nums.length, else the (i+1)th index

            if(nums[i]==0 && prev==0 && next==0){ //Favprable condition to plant
                nums[i]=1;
                n--; //Reduce the number of plants as we plant them
                
                if(n==0)return true; // if at some point if n == 0, we return true as our all plants have been planted and no need to check further.

                i+=2; //skip one element
            
            }else{
                i++; //if no favourable condition, then we increase i
            }
        }

        /*
         * Special Edge case why n<=0?
         * 1. [1,0,1,0,1,0,1], n = 0;
         * In this Edge case, n == 0 and when the loop runs it never encounters favourable condition to be returned true because of the planting structure
         * Thus to return true we will have to declare it outside. i.e: "return n==)".
         *
         * 2. [0,0,0,0,0,0,1,0,1] n = 0;
         * In this Edge case, n==0 and when the loop runs, this time it encounters the favourable condition and gets decreased to -3 at the end. Thus never
         * meeting the condition when "(n==0)return true". Thus for this we will have to modify it further to "return n<=0;"
         * */

        return n<=0; 

        
    }
}
