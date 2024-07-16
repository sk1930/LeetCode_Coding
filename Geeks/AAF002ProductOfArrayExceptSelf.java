package Geeks;

//https://leetcode.com/problems/product-of-array-except-self/description/

class AAF002ProductOfArrayExceptSelf {

    // epsilon value to maintain precision
    static final double EPS = 1e-9;
    /* this failed for input [-1,1,0,-3,3]

Solve it without division operator and in O(n)
    https://www.geeksforgeeks.org/product-array-puzzle-set-2-o1-space/
    x^y = z
    y = log base x z

    sum => log (abcd) = log(a) + log b + log c + log d
    for position 1 we have to fing b*c*d = >
    log(a) + log b + log c + log d - log a
    => bcd == 10^(sum - log a)

     in one loop find sum ie abcd
     in 2nd loop for each a find bcd by subtracting log a
     */
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // to hold sum of all values
        double sum = 0;
        for (int i = 0; i < n; i++)
            sum += Math.log10(nums[i]);

        // output product for each index
        // anti log to find original product value
        for (int i = 0; i < n; i++)
            result[i] = (int) (EPS + Math.pow(
                    10.00, sum
                            - Math.log10(nums[i])));

    return result;
}



        //Runtime 3 ms Beats 24.67% Analyze Complexity Memory 56.26 MB Beats 14.24%
    /*
    Time Complexity: O(n).
The array needs to be traversed three times, so the time complexity is O(n).
Auxiliary Space: O(n).
Two extra arrays and one array to store the output is needed so the space complexity is O(n)
*/
    public static int[] productExceptSelf1(int[] nums) {
        int size = nums.length;
        int left[] = new int[size];
        int right[] = new int[size];
        left[0] =1;
        right[size-1]=1;
        int i;
        int result[] = new int[size];
        for(i=1;i<size;i++){
            left[i] = left[i-1]*nums[i-1];

        }
        for(i=size-2;i>=0;i--){
            right[i]=right[i+1]*nums[i+1];
        }
        for(i=0;i<size;i++){
            result[i]=left[i]*right[i];
        }
        return result;

    }

    public static void main(String args[])
    {

        int[] a = new int[]{ 1,2,3,4 };
        for (int i : productExceptSelf1(a)) {
            System.out.print(i);
        }
        System.out.println("====================");

        for (int i : productExceptSelf(a)) {
            System.out.print(i);
        }
        System.out.println("====================");



        a = new int[]{-1,1,0,-3,3 };
        // expected output here is [0,0,9,0,0]
        for (int i : productExceptSelf1(a)) {
            System.out.print(i);
        }
        System.out.println("====================");


        for (int i : productExceptSelf(a)) {
            System.out.print(i);
        }
        System.out.println("====================");



    }

}