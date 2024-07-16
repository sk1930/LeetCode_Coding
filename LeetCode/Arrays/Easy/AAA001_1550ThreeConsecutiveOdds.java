package LeetCode.Arrays.Easy;

public class AAA001_1550ThreeConsecutiveOdds {
    static boolean threeConsecutiveOdds(int[] arr) {
        int i=0,n = arr.length;
        while(i<n-2){
            if(arr[i]%2 ==1 &&(arr[i+1]%2==1)&&(arr[i+2]%2==1)){
                return true;

            }
            i++;
        }
        return false;

    }

    public static void main(String[] args) {
        int[] x = {2,6,4,1};
        System.out.println(threeConsecutiveOdds(x));


        x = new int[]{1, 2, 34, 3, 4, 5, 7, 23, 12};
        System.out.println(threeConsecutiveOdds(x));

    }

}
