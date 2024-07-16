package LeetCode.Daily;


import java.util.Arrays;

// medium difficult I felt

/*Example 1:

Input: nums = [8,1,2,2,3]
Output: [4,0,1,1,3]
Explanation:
For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
For nums[1]=1 does not exist any smaller number than it.
For nums[2]=2 there exist one smaller number than it (1).
For nums[3]=2 there exist one smaller number than it (1).
For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
Example 2:

Input: nums = [6,5,4,8]
Output: [2,1,0,3]
Example 3:

Input: nums = [7,7,7,7]
Output: [0,0,0,0]
 */
public class AAD1365HowManyNumbersAreSmallerThanTheCurrentNumber {


    /*
    merge sort is O(nlogn)
    and Arrays.sort is also O(nlogn)


    10ms
Beats 26.31% of users with Java

44.86 MB Beats 5.49% of users with Java

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int temp[] = nums.clone();

        QuickSort(nums,0,nums.length-1);

        int smaller[] = new int[nums.length];
        int repeat=0;
        for (int i =1;i<nums.length;i++){
            if(nums[i]>nums[i-1]) {
                smaller[i] = smaller[i-1] + 1+repeat;
                repeat=0;
            }
            else{
                smaller[i]= smaller[i-1];
                repeat++;
            }

        }
        System.out.println(Arrays.toString(smaller));
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(temp));

        int smallerResult[] = new int[nums.length];
        int j=0;
        for(int num:temp){
            int i=0;
            while(num!=nums[i]){
                i++;
            }
            smallerResult[j++]=smaller[i];
        }


        System.out.println(Arrays.toString(smallerResult));
        return smallerResult;

    }

    public static void QuickSort(int nums[],int low,int high){
        int i=low,pivot =low,j=high;
        if(low<high){
            while(i<j) {
                while ((i < high)&&(nums[i] <= nums[pivot])) {
                    i++;
                }
                while ((j > 0) && (nums[j] > nums[pivot])) {
                    j--;
                }
                if (i < j) {
                    swap(nums, i, j);
                }
            }
            swap(nums,j,pivot);
            QuickSort(nums,low,j-1);
            QuickSort(nums,j+1,high);

        }




    }
    public static void swap(int nums[],int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j]= temp;
    }


     */



    /* with Arrays.sort

    same metrics here as well
    Runtime 11 ms Beats 11.32% of users with Java
    Memory 44.84 MBBeats 5.49% of users with Java
     */

    public static int[] smallerNumbersThanCurrent(int[] nums) {

        int temp[] = nums.clone();

        Arrays.sort(nums);
        int smaller[] = new int[nums.length];
        int repeat=0;
        int init=0;
        for (int i =1;i<nums.length;i++){
            if(nums[i]>nums[i-1]) {
                smaller[i] = smaller[i-1] + 1+repeat;
                repeat=0;
            }
            else{
                smaller[i]= smaller[i-1];
                repeat++;
            }

        }
        System.out.println(Arrays.toString(smaller));
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(temp));

        int smallerResult[] = new int[nums.length];
        int j=0;
        for(int num:temp){
            int i=0;
            while(num!=nums[i]){
                i++;
            }
            smallerResult[j++]=smaller[i];
        }


        System.out.println(Arrays.toString(smallerResult));
        return smallerResult;

    }
    public static void main(String[] args) {

        int test1[]= smallerNumbersThanCurrent(new int[]{8,1,2,2,3});
        System.out.println(Arrays.toString(test1));

    }
}
