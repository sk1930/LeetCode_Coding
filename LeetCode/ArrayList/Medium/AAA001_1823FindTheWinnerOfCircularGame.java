package LeetCode.ArrayList.Medium;

import java.util.ArrayList;

public class AAA001_1823FindTheWinnerOfCircularGame {


    // assume there are 6 numbers 1,2,3,4,5,6 if u want to remove the 7th element
    // 7%6 = 1 so remove the first position.
    // index starts at 0  and 7-1 is for 6th index in the circle so (0+(7-1))%size(6) = 0
    // remove 0 index
    public static int findTheWinner(int n, int k) {
        ArrayList<Integer> circleList = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            circleList.add(i);
        }
        int cur_ind = 0;

        while (circleList.size() > 1) {
            int nextIndexToRemove = (cur_ind + k - 1) % circleList.size();
            circleList.remove(nextIndexToRemove);
            cur_ind = nextIndexToRemove;
        }

        return circleList.get(0);    }

    public static void main(String[] args) {

        System.out.println(findTheWinner(5,2));//3

    }

}
