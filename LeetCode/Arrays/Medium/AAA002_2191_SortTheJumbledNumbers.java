
package LeetCode.Arrays.Medium;



import java.util.Arrays;


public class AAA002_2191_SortTheJumbledNumbers {


    public int mappedNumber(int mapping[],int x){
        int newNum=0;
        int numPlace=1;
        while (x > 0) {
            int onesPlace = x % 10;
            // get the digit in ones place
            //multiply the number with the numplace to get 10s,100s....
            newNum += numPlace * mapping[onesPlace];

            numPlace *= 10;  //get the next numPlace place value (tens, hundreds, etc.).
            x /= 10;
        }
        return newNum;

    }
    public int[] sortJumbled(int[] mapping, int[] nums) {
        // create a 2D array one to store the mapped number and one to store the index
        // and use custom comparator to sort the mapped number array with mapped values or with indices
        // once the mapped array sorted values are present u have the index present in the array to get the actual number.

        int n = nums.length;
        int array2D [][] = new int[n][2];

        for (int i = 0; i < n; ++i) {
            if(nums[i]==0){
                array2D[i]= new int[]{mapping[0],i};
            }else{
                array2D[i]=new int[]{mappedNumber(mapping,nums[i]),i};
            }
        }


        Arrays.sort(array2D,
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //if the mapped values are same sort them based on index ie a[1]
        // else sort them based on their values


        //from the sorted mapped number get the original array values from their indices stored.

        int[] sortedArray = new int[n];
        for (int i = 0; i < n; ++i) {
            sortedArray[i] = nums[array2D[i][1]];
        }

        return sortedArray;

    }

    public static void main(String[] args) {
        AAA002_2191_SortTheJumbledNumbers obj = new AAA002_2191_SortTheJumbledNumbers();


        int mapping[] = new int[]{8,9,4,0,2,1,3,5,7,6};
        int nums[] = new int[]{991,338,38};
        int result[] = obj.sortJumbled(mapping,nums);
        Arrays.stream(result).forEach(System.out::println);

        //input [1,1,2,2,2,3]
        //output [3,1,1,2,2,2]

    }


}
