
import java.util.Arrays;

public class SetMatrixZeroes{
    public static void main(String [] args){
        int [][] matrix = {{0,3,4,5}, {6,7,0,5}, {0,5,9,2}, {4,7,8,6}};
       
        setMatrixZeroes(matrix);

    }
    public static void setMatrixZeroes(int [][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

        /*
         * Intuition: we make used to store the coordinates in a separate data structure. Here we are going to use the top row and col to store them
         * But there are few key considerations: 1. what if the elements in the top row and cols are itself zero. For that we are going to use a boolean flag
         * Later we are going to update these values
         * */

        //We are going to iterate over every element excluding the first column.
        boolean firstZeroFound = false;
        for(int i = 0; i<rows; i++){
            if(matrix[i][0]==0) firstZeroFound = true; //if any element in the leftmost col is 0 our flag tracks it
            
            for(int j = 1; j<cols; j++){
                if(matrix[i][j] == 0){ // if we find the current element to be 0, we update its location in the top row and the leftmost col
                   matrix[0][j] = 0; //marking at the top most row at jth index
                   matrix[i][0] = 0; //marking at the leftmost col at ith index
                }
            }
        }

        //In the second step we are going to iterate over each element excluding the topmost row and the leftmost column.
        //And we are going to check the stored results from the topmost and the leftmost col and then update our values to 0

        for(int i = 1; i<rows; i++){
            for(int j = 1; j<cols; j++){
                if(matrix[0][j] == 0 || matrix[i][0]==0){ //if any one, either the top or leftmost contains zero at the current ith and jth index, make it 0;
                    matrix[i][j] = 0;
                }
            }
        }

        //In the 3rd step we are going to check if the first element in the matrix is 0
        if(matrix[0][0] == 0){ //if they are zero we make the left most element to zero
            for(int i = 0; i<rows; i++){
                matrix[i][0]=0;
            }
        }

        /*
         * DOUBT: if first element is 0. Then i should make the corresponding row and col to be zero as well. 
         * Clarity: The condition below already tracks that and is going to do the same job
         * */

        //For the last condition, if one of the leftmost element is zero
        if(firstZeroFound){
           for(int j = 0; j<cols; j++){
               matrix[0][j] = 0;
           }
        }

        
       System.out.print(Arrays.deepToString(matrix));

    }
}
