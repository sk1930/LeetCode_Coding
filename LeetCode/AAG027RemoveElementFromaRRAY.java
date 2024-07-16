package LeetCode;


import java.util.Arrays;

/*Example 1:

Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
Explanation: Your function should return k = 2, with the first two elements of nums being 2.
It does not matter what you leave beyond the returned k (hence they are underscores).
Example 2:

Input: nums = [0,1,2,2,3,0,4,2], val = 2
Output: 5, nums = [0,1,4,0,3,_,_,_]
Explanation: Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
Note that the five elements can be returned in any order.
It does not matter what you leave beyond the returned k (hence they are underscores).

 */
public class AAG027RemoveElementFromaRRAY {

    /* both are working and removeElement is more simple and works same */

    public static int removeElement1(int[] nums, int val) {

        int i =0;
        int len = nums.length;
        if(len ==0){
            return 0;
        }
        if(len==1){
            if(nums[0]==val){
                return 0;
            }
            else{
                return 1;
            }
        }
        int j = len-1;
        while (i <= j){
            if (nums[i] == val ){
                // j> i is for as j moves back and i moves forward we have to stop once j<=i
                while(nums[j]==val && j>i){
                    j--;
                }
                swap(nums,i,j);
                j--;
            }

            i++;
        }
        //return j;
        // usually i have to return j but if j is 0 ie array has only one element then return j+1
        // like in case of nums= [3] and val = 2 then output should be 1 with [3]
        System.out.println("nums in the end is ");
        System.out.println(Arrays.toString(nums));
        return j+1;

    }


    public static int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void swap(int nums[],int i , int j){
        int temp;

        temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
    }
    public static void main(String args[]){

        System.out.println(removeElement(new int[]{3,2,2,3},3));
        System.out.println(removeElement(new int[]{},3)); //output should be 0 with {}
        System.out.println(removeElement(new int[]{2},3)); // output should be 1 with nums[2]

       System.out.println(removeElement(new int[]{2},2)); // output should be 0 with nums[]
        System.out.println(removeElement(new int[]{2,2},3)); //output should be 2 with [2,2]
        System.out.println(removeElement(new int[]{2,2},2)); //
        System.out.println(removeElement(new int[]{4,5},5)); //





    }
}
