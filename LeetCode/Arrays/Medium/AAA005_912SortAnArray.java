package LeetCode.Arrays.Medium;

import java.util.Arrays;

public class AAA005_912SortAnArray {
    public int[] sortArray(int[] nums) {
        int r = nums.length-1;
        int l=0;
        divide(nums,0,r);
        return nums;



    }
    public void divide(int[] nums,int l,int r){
        int mid;
        if(l<r){
            mid=(l+r)/2;
            divide(nums,l,mid);
            divide(nums,mid+1,r);
            merge(nums,l,mid,r);
        }

    }
    public void merge(int[] nums,int l,int mid,int r){
        int n1=mid-l+1;
        int n2= r-mid;
        // temporary arrays to sort
        int L[]=new int[n1];
        int R[]= new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=nums[l+i];
        }
        for(int j=0;j<n2;j++){
            R[j]=nums[mid+j+1];
        }
        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                nums[k++]=L[i++];
            }
            else{
                nums[k++]=R[j++];
            }
        }
        // remaining numbers in Left array
        while (i < n1) {
            nums[k++] = L[i++];
        }
        // remaining elements in right array
        while (j < n2) {
            nums[k++] = R[j++];
        }




    }

    public static void main(String[] args) {
        // we are passing array object between methods
        /// and moodifying it
        // so need not worry about returning it as it is the same object that
        // gets modified.

        int nums[] = new int[]{5,2,3,1};
        AAA005_912SortAnArray obj = new AAA005_912SortAnArray();
        int result[]=obj.sortArray(nums);
        Arrays.stream(result).forEach(System.out::println);


    }
}
