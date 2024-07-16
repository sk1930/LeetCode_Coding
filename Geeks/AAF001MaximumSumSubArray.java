package Geeks;

class AAF001MaximumSumSubArray {

    // using DynamicProgramming
    public static int maxSubArray1(int[] a) {
        int size = a.length;
        int[] dp = new int[size];// Create an array to store intermediate results
        int ans = Integer.MIN_VALUE;
        dp[0]= Math.max(ans,a[0]);
        ans = dp[0];
        for (int i = 1;i<size; i++) {
            // Calculate the maximum of the current element and the sum of the current element and the previous result
            dp[i] = Math.max(a[i], a[i] + dp[i - 1]);
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }


    //https://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
    static int maxSubArray(int a[]) {
        int size = a.length;
        int max_So_Far = Integer.MIN_VALUE, sumTillHere = 0;
        for (int x : a) {
            sumTillHere = sumTillHere+x;
            if (sumTillHere > max_So_Far) {
                max_So_Far = sumTillHere;
            }
            if (sumTillHere < 0) {
                sumTillHere = 0;
            }
        }
        return max_So_Far;
    }


    public static void main(String argsp[])
    {

        int[] a = { -2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println("Maximum contiguous sum is "
                + maxSubArray(a));
        System.out.println("Maximum contiguous sum is "
            + maxSubArray1(a));

        a = new int[]{-1};
        System.out.println("Maximum contiguous sum is "
                + maxSubArray(a));
        System.out.println("Maximum contiguous sum is "
                + maxSubArray1(a));

    }

}