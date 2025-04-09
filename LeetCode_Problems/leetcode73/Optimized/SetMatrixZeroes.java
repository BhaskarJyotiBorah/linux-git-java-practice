
import java.util.Arrays;

public class SetMatrixZeroes{
    public static void main(String [] args){
        int [][] matrix = {{0,3,4,5},{6,7,0,5},{0,5,9,2},{4,7,6,8}};
       
        setMatrixZeroes(matrix);

    }
    public static void setMatrixZeroes(int [][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;

      
        boolean firstColHasZero = false;
        boolean firstRowHasZero = false;

        for(int j = 0; j<cols; j++){
            if(matrix[0][j] == 0){
                firstRowHasZero = true; //Check the topmost one row
                break;
            }
            
        }

        for(int i = 0; i<rows; i++){
            if(matrix[i][0] == 0){
                firstColHasZero = true; //Check if the leftMost col has 0
                break;
            }
        
        }

       
        
        for(int i = 1; i<rows; i++){
            for(int j = 1; j<cols; j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        
       

        for(int i = 1; i<rows; i++){
            for(int j = 1; j<cols; j++){
                if(matrix[0][j] == 0 || matrix[i][0]==0){ 
                    matrix[i][j] = 0;
                }
            }
        }

    
        if(firstColHasZero){ 
            for(int i = 0; i<rows; i++){
                matrix[i][0]=0;
            }
        }

        

        
        if(firstRowHasZero){
           for(int j = 0; j<cols; j++){
               matrix[0][j] = 0;
           }
        }

        
       System.out.print(Arrays.deepToString(matrix));

    }
}
