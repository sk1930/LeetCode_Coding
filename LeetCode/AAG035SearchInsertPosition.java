package LeetCode;

/*Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
 */

public class AAG035SearchInsertPosition {


    public static int searchInsert(int[] nums, int target) {

        int i =0;
        while((i< nums.length) && (nums[i] < target)){
            i++;
        }
        return i;

    }

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1,2,3},3));
        System.out.println(searchInsert(new int[]{1,3,5,6},5));
        System.out.println(searchInsert(new int[]{1,3,5,6},2));
        System.out.println(searchInsert(new int[]{1,3,5,6},7));
        System.out.println(searchInsert(new int[]{1,3,5,6},7));



    }


}
