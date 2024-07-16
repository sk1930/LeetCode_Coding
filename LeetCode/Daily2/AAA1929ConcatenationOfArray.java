package LeetCode.Daily2;

import java.util.Arrays;

/*

Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).
Specifically, ans is the concatenation of two nums arrays.
Return the array ans.


n == nums.length
1 <= n <= 1000
1 <= nums[i] <= 1000


nput: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]





 */
public class AAA1929ConcatenationOfArray {
    public static int[] getConcatenation(int[] nums) {
        int[] result = new int[nums.length*2];
        for(int i=0;i<nums.length;i++){
            result[i] = nums[i];
            result[i+nums.length] = nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int result[] = getConcatenation(new int[]{1,2,1});
        System.out.println(Arrays.toString(result));

    }


}
