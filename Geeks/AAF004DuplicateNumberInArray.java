package Geeks;

//https://www.geeksforgeeks.org/find-repetitive-element-1-n-1/

import java.util.HashSet;

class AAF004DuplicateNumberInArray {


    //Time Complexity: O(N)
    //Auxiliary Space: O(N)
    static int findDuplicate1(int[] nums) {
        int N = nums.length;
        HashSet<Integer> s = new HashSet<Integer>();
        // s.add returns True if new element is added in to HashSet
        // returns False if an element added is already present in the hashset.
        for(int i = 0; i < N; i++) {
            if(!s.add(nums[i])){
                return nums[i];
            }
        }
        // If input has no duplicates, return -1
        return -1;
    }


    //Time Complexity: O(N)
    //Auxiliary Space: O(1)
    static int findDuplicate2(int[] nums)
    {
        // Find array sum and subtract sum
        // first n-1 natural numbers from it
        // to find the result.
        int N= nums.length;
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += nums[i];
        return sum - (((N - 1) * N) / 2);
    }


    //The idea is based on the fact that x ^ x = 0 and if x ^ y = z then x ^ z = y
    static int findDuplicate(int[] nums){

        // res is going to store value of
        // 1 ^ 2 ^ 3 .. ^ (N-1) ^ arr[0] ^
        // arr[1] ^ .... arr[n-1]
        int N= nums.length;
        int res = 0;
        for (int i = 0; i < N - 1; i++)
            res = res ^ (i + 1) ^ nums[i];
        res = res ^ nums[N - 1];

        return res;

    }






    public static void main(String args[])
    {

        int arr[] = { 9, 8, 2, 6, 1, 8, 5, 3, 4, 7 };

        // Function call
        System.out.println(findDuplicate(arr));


    }

}