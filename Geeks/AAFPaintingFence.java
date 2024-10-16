package Geeks;
import java.util.*;

/*Given a fence with n posts and k colors, find out the number of ways of painting the fence such that at most 2
adjacent posts have the same color. Since the answer can be large return it modulo 10^9 + 7.

 */
public class AAFPaintingFence {

    // Returns count of ways to color k posts
    // using k colors
    static long countWays(int n, int k)
    {
        // To store results for subproblems
        long dp[] = new long[n + 1];
        Arrays.fill(dp, 0);
        int mod = 1000000007;

        // There are k ways to color first post
        dp[1] = k;

        // There are 0 ways for single post to
        // violate (same color_ and k ways to
        // not violate (different color)
        long same = 0, diff = k;

        // Fill for 2 posts onwards
        for (int i = 2; i <= n; i++) {
            // Current same is same as previous diff
            same = diff;

            // We always have k-1 choices for next post
            diff = (dp[i - 1] * (k - 1));
            diff = diff % mod;

            // Total choices till i.
            dp[i] = (same + diff) % mod;
        }

        return dp[n];
    }

    // Driver code
    public static void main(String[] args)
    {
        int n = 100, k = 25;
        System.out.println(countWays(n, k));
    }
}


