package LeetCode.Arrays.Medium;

import java.util.Arrays;

public class AAA350IntersectionOfTwoArrays {
    public int[] intersect(int[] nums1, int[] nums2) {
            int l1 = nums1.length;
            int l2 = nums2.length;
            int i = 0, j = 0, k = 0;
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            while( i < l1 && j < l2)
            {
                if(nums1[i] < nums2[j])
                {
                    i++;
                }
                else if(nums1[i] > nums2[j])
                {
                    j++;
                }
                else
                {
                    nums1[k++] = nums1[i++];
                    j++;
                }
            }
            return Arrays.copyOfRange(nums1,0,k);
    }
    public static void main(String[] args) {
        int[] x = {1,2,2,1};

        int[] y = {2,2};





    }

}
