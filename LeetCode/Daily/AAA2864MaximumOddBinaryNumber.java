package LeetCode.Daily;

/*Example 1:

Input: s = "010"
Output: "001"
Explanation: Because there is just one '1', it must be in the last position. So the answer is "001".
Example 2:

Input: s = "0101"
Output: "1001"
Explanation: One of the '1's must be in the last position. The maximum number that can be made with the remaining digits is "100". So the answer is "1001".*/

public class AAA2864MaximumOddBinaryNumber {
    public static String maximumOddBinaryNumber1(String s) {
        StringBuilder s0 = new StringBuilder("");
        StringBuilder s1 = new StringBuilder("");
        int count1 = 0;
        for (Character c:s.toCharArray()){
         if (c == '0'){
             s0.append("0");
            }
         else{
             s1.append("1");
         }
        }
        s1.deleteCharAt(0);
        s0.append("1");
        String s3 = s1.toString();
         s3 = s3.concat(s0.toString());



        return s3;
    }

    public static String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder("");
        int count1 = 0;
        int count0 = 0 ;
        for (Character c:s.toCharArray()){
            if (c == '0'){
                count0++;
            }
            else{
                count1++;
            }
        }

        //append all 1s except one 1 to append at last position
        // so that to get odd number
        for(int i  =0;i<count1-1;i++){
            sb.append(1);
        }
        for(int i  =0;i<count0;i++){
            sb.append(0);
        }
        sb.append(1);


        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maximumOddBinaryNumber("0101"));

        System.out.println(maximumOddBinaryNumber("0111"));
    }

}
