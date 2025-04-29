import java.util.Arrays;
import java.util.HashMap;

public class EqualRowCol{
    public static void main(String[] args) {
        int [][] grid = {{3,2,1}. {1,7,6}, {2,7,7}};
        System.out.println(equalRowCol(grid));
    }
    public static int equalRowCol(int [] grid){
        //Initialize a HashMap to store Arrays and compare if equal array exists
        int count = 0;
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        int n = grid.length;

        for(int i = 0; i<n; i++){
            List<Integer> row = Arrays.stream(grid[i]).boxed().collect(Collectors.toList()); //Wraps primitive int [] into List<Integer>
            map.put(row, map.getOrDefault(row,0)+1);
        }

        for(int i = 0; i<n; i++) {
            List<Integer> col = new ArrayList<>(); //Created a new ArrayList to store the columns
            for(int j = 0; j<grid[0].length; j++){
                col.add(grid[j][i]);
            }
            count+=map.getOrDefault(col,0); // if col array is found we add the existing count else add 0
        }

        return count;
    }
    public static int equalRowColOptimized(int [][] grid){
        int n = grid.length;
        HashMap<String, Integer> map = new HashMap<>();

        //Store rows as Strings
        for(int i = 0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<n; j++){
                sb.append(grid[i][j].append(',')); //Using comma to separate numbers
            }
            String row = sb.toString();
            map.put(row,map.getOrDefault(row,0)+1);
        }

        int count = 0;

        //Checking for each column
        for(int j = 0; j<n; j++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<n; j++){
                sb.append(grid[j][i]).append(',');
            }
            String col = sb.toString();
            count+= map.getOrDefault(colKey,0);
        }
        return count;
    }
}