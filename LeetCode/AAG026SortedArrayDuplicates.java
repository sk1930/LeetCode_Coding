package LeetCode;

import java.util.Arrays;

public class AAG026SortedArrayDuplicates {
    //removeDuplicates1 is having j++ twice and is complex
    // removeDuplicates : considering it as sliding window problem makes the solution easy to understand
    // removeDuplicates2 is also sliding window and easy



    public static int removeDuplicates1(int[] nums) {
        // this is all complex so ignore this and see removeDuplicates only better

        // in here i have started at 0 and moved to the end comparing j and j+1
        // as i started from 0 and j+1 will be out of bounds
        // so i had to write a separate condition for that in while j+1< len and if j==len-1

        int i =0,j=0;
        int len = nums.length;
        while(j<len){
            //System.out.println("i is"+i);
            nums[i] = nums[j];
            while((j+1 < len)&& (nums[j] == nums[j+1])){
                /*System.out.println("j is"+j);
                for(int num: nums){
                    System.out.print(num);
                }
                System.out.println("");
                */

                j++;
            }
            if(j == len-1){
                nums[i]=nums[j];
            }

            j++;
            i++;
        }
        System.out.println("end of the program");
        System.out.println(Arrays.toString(nums));

        return i;


    }


    public static int removeDuplicates(int[] nums) {

        int i =0,j=0;
        int len = nums.length;
        while(j<len) {
            //System.out.println("i is"+i);
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        System.out.println("end of the program");
        System.out.println(Arrays.toString(nums));

        return i+1; // is is the index i+1 is the number of elements


    }

    public static int removeDuplicates2(int[] nums) {

        int i =0,j=1;
        int len = nums.length;
        while(j<len) {
            //System.out.println("i is"+i);
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        System.out.println("end of the program");
        System.out.println(Arrays.toString(nums));

        return i+1; // is is the index i+1 is the number of elements


    }








    public static void main(String args[]){
        //int nums[] = new int[]{1, 1, 2,2};


        System.out.println(removeDuplicates(new int[]{1, 1, 2,2}));
        System.out.println(removeDuplicates2(new int[]{1, 1, 2,2}));

        System.out.println(removeDuplicates(new int[]{1, 1, 2, 3, 3,4,4,4,5,5,6}));
        System.out.println(removeDuplicates2(new int[]{1, 1, 2, 3, 3,4,4,4,5,5,6}));

        System.out.println(removeDuplicates(new int[]{1, 2, 2, 3, 3,4,4,4,5,5,6}));
        System.out.println(removeDuplicates2(new int[]{1, 2, 2, 3, 3,4,4,4,5,5,6}));

        System.out.println(removeDuplicates(new int[]{1,2,3}));
        System.out.println(removeDuplicates2(new int[]{1,2,3}));

        System.out.println(removeDuplicates(new int[]{1}));
        System.out.println(removeDuplicates2(new int[]{1}));

        //System.out.println(nums);
        // we passed an object here so nums is automatically changed everywhere.


    }


}
