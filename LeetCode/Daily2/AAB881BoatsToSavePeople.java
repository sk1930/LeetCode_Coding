package LeetCode.Daily2;

import java.util.Arrays;

public class AAB881BoatsToSavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats=0;
        int leftPointer=0, rightPointer = people.length-1;

        while(leftPointer<=rightPointer){
            if(people[leftPointer]+people[rightPointer]<=limit){
                leftPointer++;
                rightPointer--;
            }
            else{
            if(people[rightPointer]<=limit){
                rightPointer--;
            }
        }
            boats++;

        }
        return boats;
    }

    public static void main(String[] args) {
        AAB881BoatsToSavePeople obj = new AAB881BoatsToSavePeople();
        System.out.println(obj.numRescueBoats(new int[]{3,2,2,1},3));
    }

}
