package LeetCode.treemap.Easy;

//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

import java.util.Stack;
import java.util.TreeMap;

public class AAA001_2418SortThePeople {

    public String[] sortPeople(String[] names, int[] heights) {

        // another way is to create a hashmap and put heights and names
        // sort the array of heights and
        // iterate from last to first for descending and get the respectiev names from the map and store in result array.

        TreeMap<Integer,String> tmap = new TreeMap<>();
        for(int i=0;i<names.length;i++){
            tmap.put(heights[i],names[i]);
        }
        int j= names.length-1;
        String[] descendingOrder = new String[j+1];
        for(String name:tmap.values()){
            descendingOrder[j]=name;
            j--;
        }
        return descendingOrder;
    }
    public static void main(String[] args) {
        String[] names = new String []{"Mary","John","Emma"};

        int[] heights = new int[]{180,165,170};
        AAA001_2418SortThePeople obj = new AAA001_2418SortThePeople();
        for(String name:obj.sortPeople(names,heights)){
            System.out.println(name);
        }



    }

}
