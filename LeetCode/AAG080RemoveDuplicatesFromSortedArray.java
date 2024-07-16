package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AAG080RemoveDuplicatesFromSortedArray {

    // the last  code with name removeDuplicates is only better and better to ignore others
    // and this passed 157/167 passed with the failed one [1,1,1] input , output should be 2, but got 3./


    //  this is working partially let me try maps implementation
    public static int removeDuplicates1(int[] nums) {



        int len = nums.length;
        int prev=nums[0];
        int count =1; // count of nums[i] here it is 1 as we have nums[0]
        int i=1,j=1,maxCount=2;
        int max = nums[0];


        while(i< len){
            if(nums[i]<prev){
                if(i+1 == len){
                    break;
                }
                swap(nums,i,i+1);
            }
            if(prev == nums[i]){
                count++;
                i++;
            }
            else{
                count = 1;
                prev = nums[i];
                j=i;
                max = nums[i];


            }
            if(count > maxCount){
                swap(nums,i,i+1);
                max =nums[i];
                count = 1;
                prev = nums[i];
                i++;
            }


        }
        return i;


    }



    // this maps implementation not working properly
    public static int removeDuplicates2(int[] nums){
        Map<Integer,Integer> mapcounts = new HashMap<Integer,Integer>();
        int i=0, increement = 0, maxCount=2;;
        int len = nums.length;
        int prev=nums[0];
        int count =1; // count of nums[i] here it is 1 as we have nums[0]
        int j=-1;
        int max = nums[0];
        System.out.println("start  is"+i);



        while(i< len){
            if (mapcounts.containsKey(nums[i])){
                increement = mapcounts.get(nums[i])+1;

                mapcounts.put(nums[i],increement);
            }
            else{
                increement = 1;
                mapcounts.put(nums[i],increement);
            }
            if(increement > maxCount && (i+1<len)){
                //j = findNext(nums,i,j);
                swap(nums,i,i+1);
                i--;

            }
            i++;

        }
        System.out.println("i is"+i);
        return i;
    }




    // this maps implementation worked.
    //just updating the non unique element with next unique element
    // //replace the eleement with maxCount > =2 with any element after it with maxCount < =2.
    // this case after  passed 157/167 and failed at         System.out.println(new int[]{1,1,1}); // expected [1,1] with length 2
    // failed at 160/167 -- [1,2,2,2] output is 4 instead of 3.
    public static int removeDuplicates(int[] nums){
        Map<Integer,Integer> mapcounts = new HashMap<Integer,Integer>();
        int i=0, increement = 0, maxCount=2;;
        int len = nums.length;
        int prev=nums[0];
        int count =1; // count of nums[i] here it is 1 as we have nums[0]
        int j=-1;
        int max = nums[0];
        int trackOfLastReplaced =0;
        //System.out.println("start  is"+i);



        while(i< len){
            if (mapcounts.containsKey(nums[i])){
                increement = mapcounts.get(nums[i])+1;
                mapcounts.put(nums[i],increement);
            }
            else{
                //trackOfLastReplaced++;
                increement = 1;
                mapcounts.put(nums[i],increement);
            }
            if((increement > maxCount) && (i+1<len)){
                //j = findNext(nums,i,j);
                boolean flag = true;
                j=i+1;
                while(flag){
                    // doesnt contain key means its count in map is 0
                    if ((!mapcounts.containsKey(nums[j])) || ( mapcounts.get(nums[j]) < maxCount)){
                        flag = false;
                        increement--;
                        mapcounts.put(nums[i],increement);
                        swap(nums,i,j);
                        trackOfLastReplaced=i;


                        i--;
                    }
                    j++;
                    if(j==len){
                        flag=false;
                    }
                }
            }
            i++;

        }

        if(trackOfLastReplaced == 0){
            // no replacements done even once
            //[1,1,2,2]

            trackOfLastReplaced = i-1;
        }
        //System.out.println("i is"+i);
        trackOfLastReplaced++; //trackoflastreplaced is index so ++ to return the position

        System.out.println("array in the end i s");
        System.out.println(Arrays.toString(nums));
        if (len == increement){
            // all elements in the array are same and no replacement done
            // like [1,1,1,1,1]
            return 2;
        }
        return trackOfLastReplaced;
    }




    // this is a simple implementation and passes all test cases
    public static int removeDuplicates4(int[] nums) {
        int i =0;
        for(int num : nums)
        {
            if(i==0 || i==1 || nums[i-2] != num)
            {
                nums[i] = num;
                i++;
            }
        }
        return i ;
    }


    public static int findNext(int nums[],int i , int j){
        if(j==-1){
            j=i;
        }

        while(j< nums.length){
            if (nums[j]>nums[i])
                    return j;
            j++;
        }
        return j;
    }

    public static void swap(int nums[],int i , int j){
        int temp;

        temp = nums[i];
        nums[i]= nums[j];
        nums[j] = temp;
        // this received nums object so we need not return anything
    }
    public static void main(String args[]){
        System.out.println(removeDuplicates4(new int[]{1,1,2,2,2,3,3}));
        System.out.println(removeDuplicates4(new int[]{1,1,2,2,2,3,3,3}));
        System.out.println(removeDuplicates4(new int[]{1,1,2,2,2,3,3,3,3,4,4}));
        System.out.println(removeDuplicates4(new int[]{1,1,1,2,2,3,3,3,3,4,4}));
        System.out.println(removeDuplicates4(new int[]{1,2,2,2,2,3,4}));

        System.out.println(removeDuplicates4(new int[]{1,2,2}));
        System.out.println(removeDuplicates4(new int[]{1,1,1})); // expected [1,1] with length 2
        System.out.println(removeDuplicates4(new int[]{1,1,1,1,1,1,1})); // expected [1,1] with length 2

        System.out.println(removeDuplicates4(new int[]{1,1,1,1,1,1,2})); // expected [1,1,2] with length 3
        System.out.println(removeDuplicates4(new int[]{1,2,2,2})); // expected [1,2,2] with length 3





    }
}
