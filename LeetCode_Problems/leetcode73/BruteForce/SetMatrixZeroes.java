
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes{
    public static void main(String [] args){
        int [][] matrix = {{1,0,1,2,4}, {0,9,6,0,3}, {4,0,1,1,3}, {4,5,6,7,8}, {13,0,1,3,5}};
        setZeroes(matrix);
    }
    public static void setZeroes(int [][] matrix){
        int rows = matrix.length; //number of rows
        int cols = matrix[0].length; //number of cols

        List<int []> zeroList = new ArrayList<>(); //list to store the coordinates of 0 thats found

        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(matrix[i][j]==0){
                    zeroList.add(new int []{i,j}); //Every zero that we encounter, its coordinates are recorded in the list while traversing the whole array
                }
            }
        }


        for(int [] pos: zeroList){
            int row = pos[0]; //row number of the element
            int col = pos[1]; // Col number of the element
           

            for(int i = 0; i<cols; i++){  //iterating through the column directed by the row number
                matrix[row][i] = 0; // Replacing it with 0
            }

            for(int j = 0; j<rows; j++){ //iterating through the row directed by the col number
                matrix[j][col] = 0;
            }
        }

        System.out.print(Arrays.deepToString(matrix));

    }
}
