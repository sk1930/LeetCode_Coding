package LeetCode.Arrays.Medium;

import java.util.Arrays;

//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

public class AAA033SearchInRotatedSortedArray {
    static int search(int[] nums, int target) {
        int i=0,len=nums.length;
        int j=len-1;
        int mid = (i+j)/2;
        // for (1+4)/2  it is  2


        /* this is failing when there is only one element in the array
        in the else if part we check nums[mid+1]...which is array index out of bounds
        while(i<=j){
            if(target<nums[mid] && target>=nums[i]){
                j=mid-1;
            } else if (target >= nums[mid+1] &&  target<=nums[j]) {
                i=mid+1;
            }
            else{
                return mid;
            }
            mid=(i+j)/2;
        }

        */

        /* this fails in the case where the left array is not exactly sorted like in case of
        [5,1,3], and target 5
        in the else if part the left array we are checking is not exactly sorted
        while(i<=j){
            if(nums[mid]==target){
                return mid;
            }
            else if(target<nums[mid] && target>=nums[i]){
                j=mid-1;
            } else {
                //(target >= nums[mid+1] &&  target<=nums[j]) {
                i=mid+1;
            }
            mid=(i+j)/2;
        }

         */
        while(i<=j){
            if(nums[mid]==target){
                return mid;
            }
            // check if the left array is sorted first
            // in case [5,1,2] and the target is 5
            //left part will be [5,1]
            else if(nums[i]<=nums[mid]){
                if(target>=nums[i]&&target<nums[mid]){
                    j=mid-1;
                }
                else{
                    i=mid+1;
                }
            }
            // right half is sorted
            else{
                if(target>nums[mid] && target<=nums[j]){
                    i=mid+1;
                }
                else{
                    j=mid-1;
                }
            }
            mid=(i+j)/2;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] x = {4,5,6,7,0,1,2};


        int mid=(1+4)/2; //2
        System.out.println(search(x,0)); //4

        x = new int[]{1};
        System.out.println(search(x,1)); //0

        x= new int[]{5,1,3};
        System.out.println(search(x,5)); //0




    }

}
