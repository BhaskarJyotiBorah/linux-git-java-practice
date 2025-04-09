
import java.util.Arrays;

public class SetMatrixZeroes{
    public static void main(String [] args){
        int [][] matrix = {{0,3,4,5},{6,7,0,5},{0,5,9,2},{4,7,6,8}};
       
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
        boolean isFirstColZero = false;
        boolean isFirstRowZero = false;
        for(int i = 0; i<rows; i++){
            if(matrix[i][0]==0) isFirstColZero = true; //if any element in the leftmost col is 0 our flag tracks it
            
            for(int j = 1; j<cols; j++){
            if(matrix[0][j]==0) isFirstRowZero = true;    

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

        /*
         * If isFirstColZero and isFirstRowZero is true that means we encountered 0 that is in either leftMost element or topmost element
         * There for we manually make the corresponding row and col zeros
         * */
        if(isFirstColZero){ 
            for(int i = 0; i<rows; i++){
                matrix[i][0]=0;
            }
        }

        

        
        if(isFirstRowZero){
           for(int j = 0; j<cols; j++){
               matrix[0][j] = 0;
           }
        }

        
       System.out.print(Arrays.deepToString(matrix));

    }
}
