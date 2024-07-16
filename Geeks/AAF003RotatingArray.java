package Geeks;

//https://leetcode.com/problems/product-of-array-except-self/description/

class AAF003RotatingArray {

    static void rotate(int[] nums,int k){
        int n = nums.length;
        // If rotation is greater
        // than size of array
        k=k%n;
        /* for size 10 after every 10 rotations, we get same array
         */

        reverse(nums, 0, nums.length-1); // reverse the entire array
        reverse(nums, 0, k-1); // reverse the first k elements
        reverse(nums, k, nums.length-1); // reverse the last k elements
    }

    static void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }


    static void rotate1(int a[],  int k) {
        int n = a.length;
        // If rotation is greater
        // than size of array
        k=k%n;
        /* for size 10 after every 10 rotations, we get same array
         */
        int result[] = new int[n];

        for(int i = 0; i < n; i++)
        {
            if(i<k)
            {
                // Printing rightmost
                // kth elements
                result[i]= a[n + i - k];

            }
            else
            {
                // Prints array after
                // 'k' elements
                result[i]= a[i - k];
            }
        }
        a = result;
        for(int i : a){
            System.out.print(i);
        }
    }


    // time limit exceeded
    static void rotate2(int[] arr,int k) {
        int n= arr.length;
        if (k == 0) {
            return;
        }

        // Rotate the array to the right by one position
        int temp = arr[n - 1];
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = temp;

        // Recursively rotate the remaining elements k-1 times
        rotate(arr, k - 1);
    }







    public static void main(String args[])
    {

        int Array[] = {1, 2, 3, 4, 5};
        int N = Array.length;

        int K = 2;
        rotate(Array, K);

        rotate1(Array,K);


    }

}