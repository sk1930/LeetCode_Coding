package Geeks;


/*
    https://www.geeksforgeeks.org/program-nth-catalan-number/

Below are steps to calculate Catalan numbers using the formula: 2nCn/(n+1)

Calculate 2nCn using the similar steps that we use to calculate nCr
Return the value 2nCn/ (n + 1)

// Java program for nth Catalan Number


 */
public class AABCatalan {

    // Returns value of Binomial Coefficient C(n, k)
    static long binomialCoeff(int n, int k)
    {
        long res = 1;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }

        // Calculate value of [n*(n-1)*---*(n-k+1)] /
        // [k*(k-1)*---*1]
        for (int i = 0; i < k; ++i) {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }

    // A Binomial coefficient based function
    // to find nth catalan number in O(n) time
    static long catalan(int n)
    {
        // Calculate value of 2nCn
        long c = binomialCoeff(2 * n, n);

        // return 2nCn/(n+1)
        return c / (n + 1);
    }

    // Driver code
    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++) {
            System.out.print(catalan(i) + " ");
        }
    }
}
