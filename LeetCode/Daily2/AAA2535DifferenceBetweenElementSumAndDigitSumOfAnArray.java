package LeetCode.Daily2;


/*Constraints:

1 <= nums.length <= 2000
1 <= nums[i] <= 2000


Input: nums = [1,15,6,3]
Output: 9
Explanation:
The element sum of nums is 1 + 15 + 6 + 3 = 25.
The digit sum of nums is 1 + 1 + 5 + 6 + 3 = 16.
The absolute difference between the element sum and digit sum is |25 - 16| = 9.

 */
public class AAA2535DifferenceBetweenElementSumAndDigitSumOfAnArray {

    public static int differenceOfSum(int[] nums) {
        int sum1=0,sum2=0;
        for( int num:nums){
            sum1+=num;

            int x;

            while(num>0){
                x = num%10;
                sum2 +=x;
                num = num/10;
            }
        }
        return Math.abs(sum1 - sum2);


    }

    public static void main(String[] args) {
        System.out.println(differenceOfSum(new int[]{1,15,6,3})); //9
        System.out.println(differenceOfSum(new int[]{1,2,3,4})); //0



    }
}
