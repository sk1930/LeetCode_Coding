package LeetCode.Arrays.Medium;

//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

public class AAA0011701AverageWaitingTime {

    public static double averageWaitingTime(int[][] customers) {
        int currentTime = customers[0][0];

        int currentWaitingTime = 0;
        int totalWaitingTime = 0;
        int startTime = 0;
        for (int[] x : customers) {
            currentTime = x[0];
            startTime = Math.max(startTime, currentTime);


            totalWaitingTime += startTime - x[0] + x[1];
            startTime = startTime + x[1];


        }
        return (double) (totalWaitingTime) / customers.length;
    }


    public static void main(String[] args) {
        int x[][]= new int[][]{{1,2},{2,5},{4,3}};
        System.out.println(averageWaitingTime(x));
    }

}
