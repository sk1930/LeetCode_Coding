package Geeks;

//https://www.geeksforgeeks.org/merging-intervals/

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

class AAF005MergeIntervals {

    /* this failed for [[1,4],[2,3]]
    expected is [1,4].
    but my output is [1,3]
    while assigning value - add the maximum of result[j][1] and intervals[i][1];
     */
    static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int len = intervals.length;;
        int result[][]= new int[len][2];
        int i,j=0;
        result[0] = intervals[0];

        for(i=1;i<len;i++){
            if(result[j][1]>=intervals[i][0]){
                result[j][1]= intervals[i][1];
            }
            else{
                result[++j] = intervals[i];
            }
        }

        //return result;
        return Arrays.copyOfRange(result, 0, j+1 );


    }

    // see how the for loop behaves here as the same object is being modified.
    static int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int e = 0;
        for (int[] interval : intervals) {
            if (interval[0] <= intervals[e][1]) { // overlap, merge it with last element of your output array.
                intervals[e][1] = Math.max(intervals[e][1], interval[1]);
            } else { // no overlap, add current (start, end) pair at the end of your output array.
                intervals[++e][0] = interval[0];
                intervals[e][1] = interval[1];
            }
        }
        if (e == intervals.length - 1) return intervals;
        return Arrays.copyOfRange(intervals, 0, e + 1);
    }




    public static void main(String args[])
    {

        int arr[][] = {{1,3},{2,6},{8,10},{15,18}};
        for(int[] i :merge(arr)){
            System.out.println(i[0]+""+i[1]);

        }
        arr= new int[][]{{1, 4}, {4, 5}};
        for(int[] i :merge(arr)){
            System.out.println(i[0]+""+i[1]);

        }





    }

}