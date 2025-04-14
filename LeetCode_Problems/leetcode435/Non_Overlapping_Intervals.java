import java.util.Arrays;
import java.util.Comparator;

public class Non_Overlapping_Intervals{
    public static void main (String [] args){
        int [] [] arr = {{0,2}, {1,3}, {2,4}, {3,5}, {4,6}};
        System.out.println(eraseOverlaps(arr));
        
    }
    public static int eraseOverlaps(int [][] intervals){
        Arrays.sort(intervals, Comparator.comparingInt(a->a[1])); //Sort by end time
        int count = 0;
        int second = intervals[0][1]; //This is the second element of the 1st interval
         for(int i = 1; i<intervals.length; i++){
             if(intervals[i][0]<second){
                 count++;
             }else{
                 second = intervals[i][1];
             }
         }
         

         return count; 
    }
        
}
