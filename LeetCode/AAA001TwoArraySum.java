package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class AAA001TwoArraySum {
    public static int[] twoSum(int[] nums, int target) {
        int diff;
        Map x = new HashMap<Integer,Integer>();
        for(int i =0;i<nums.length;i++){
            diff= target-nums[i];
            if(x.containsKey(diff)){
                //unboxing to integer using (int) as generic classes have Integer class
                return new int[] {(int)x.get(diff),i};
            }
            x.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }


        public static void main(String[] args) {
        int arr [] = {2,7,8,4};
        int target = 9;
        int x[] = twoSum(arr,target);
        System.out.println(x);
            System.out.println(Arrays.toString(x));


        }
}