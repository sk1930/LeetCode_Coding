package LeetCode.Daily;


import java.util.Arrays;

/*Example 1:

Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
Example 2:

Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 */
public class AAB977SquaresOfSortedArray {

    /* approach take i at 0 and j at last position ,
    for new array start at last position and put the larger element of nums[i] and nums[j]

     */
    public static int[] sortedSquares(int[] nums) {
        int j = nums.length-1;
        int i =0;
        int current = nums.length-1;

        int newArr[] = new int[nums.length];
        while(current>=0){
            if(Math.abs(nums[i])>Math.abs(nums[j])){
                newArr[current] = (int)Math.pow(nums[i],2);
                current--;
                i++;
            }
            else{
                newArr[current] = (int)Math.pow(nums[j],2);
                current--;
                j--;

            }

        }


        return newArr;



    }

    public static void main(String[] args) {
        int x[] = sortedSquares(new int[]{-4,-1,0,3,10});
        System.out.println(Arrays.toString(x));

    }
    }
