public class searchIn2DMatrix{
    public static void main(String [] args){
        int [][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 20;

        System.out.print(searchElement(matrix,target));
    }
    public static boolean searchElement(int [][] matrix, int target){
        int rows = matrix.length; //Total number of rows
        int cols = matrix[0].length; //Total number of cols
                              
        int left = 0, right = rows*cols-1; //Assigning left and the right pointers assuming the matrix to be a 1D array
        
        while(left<=right){
           int mid = left + (right - left)/2; //Calculating the mid similar to regular binary search
           
           int row = mid/cols; 
           int col = mid%cols;

           /*
            * 1. Here I Noticed that i can use regular binary search since the Matrix is sorted.
            * 2. All are same except for locating the correct mid value in a Matrix situation
            * 3. For that I examined and found that if i do mid/cols to find the row and mid%cols to find col, it always gives the correct mid value
            * 4. From this observation i took it into consideration to solve this problem
            * */
           
           if(matrix[row][col]==target){
               return true;
           }else if(matrix[row][col]>target){
               right = mid-1;
           }else{
               left = mid+1;
           }    

        }

        /*
         * The rest of the process is exactly same as the regular binary search
         * Main catch here is to find the exact location in a matrix situation 
         * */

        return false;

    }
}
