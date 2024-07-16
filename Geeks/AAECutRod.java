package Geeks;
// My solution

import java.util.*;
public class AAECutRod {
    static int x=0;

    /* Returns the best obtainable price for a rod of length
    n and price[] as prices of different pieces */
    static int cutRod(int price[], int index, int n,int [][]dp)
    {
        x+=1;
        //System.out.println("index is "+index+ "n is"+n);
        if(index < 0){
            return 0;
        }
        if(dp[index][n]!=-1)
        {
            return dp[index][n];
        }

        // base case
        // if index ==0 that means we can get n number of pieces of unit length with price price[0]

        if (index == 0) {
            return dp[index][n] = n * price[0];
        }
        // if n is 0 we cannot cut the rod anymore.
        if (n ==0) {
            return 0;}

        // At any index we have 2 options either
        // cut the rod of this length or not cut
        // it
        int notCut = cutRod(price, index - 1, n,dp);
        int cut = Integer.MIN_VALUE;
        int rod_length = index + 1;
        int new_length = n - rod_length;

        // rod can be cut only if current rod length is than actual length of the rod

        if (rod_length <= n)
            //next cutting index can only be new length - 1
            cut = price[index]
                    + cutRod(price, new_length-1, new_length,dp);

        return dp[index][n] = Math.max(notCut, cut);
    }

    /* Driver program to test above functions */
    public static void main(String args[])
    {
        int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20};
        int size = arr.length;
        int [][] dp = new int [size][size+1];
        for (int row[] : dp)
        {
            Arrays.fill(row,-1);
        }
        System.out.println("Maximum Obtainable Value is "
                + cutRod(arr, size - 1, size,dp));
        System.out.println("x is"+x);

    }
}

// This code is contributed by Lovely Jain