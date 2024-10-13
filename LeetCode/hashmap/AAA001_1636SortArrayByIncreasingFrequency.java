
// medium
// here we are creating a Integer class [] as Arrays.sort work on Integer object
package LeetCode.hashmap;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class AAA001_1636SortArrayByIncreasingFrequency {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Integer[] integerNums = new Integer[nums.length];
        // u can also create a arraylist and use
        // arrayList.stream().sorted((p1,p2)->{}).collect(Collectors.toList())
        //https://www.geeksforgeeks.org/stream-sorted-in-java/

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            integerNums[i] = nums[i];
        }

        //Arrays.sort need Integer class
        Arrays.sort(integerNums, (n1, n2) -> {
            if (freq.get(n1) != freq.get(n2)) {
                // if freq of numbers are not equal then return in increasing order based of frequency
                return freq.get(n1) - freq.get(n2);
            } else {
                //else sort them in decreasing order based on numbers
                return n2 - n1;
            }
        });


        for (int i = 0; i < nums.length; i++) {
            nums[i] = integerNums[i];
        }


        return nums;
    }

    public static void main(String[] args) {
        AAA001_1636SortArrayByIncreasingFrequency obj = new AAA001_1636SortArrayByIncreasingFrequency();


        int test[] = obj.frequencySort(new int[]{1,1,2,2,2,3});
        Arrays.stream(test).forEach(System.out::println);

        //input [1,1,2,2,2,3]
        //output [3,1,1,2,2,2]

    }


}
