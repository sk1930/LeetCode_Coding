package LeetCode.Daily2;


// Medium
// Nice solution
/// iterating on the input
// but also taking i from output string



/*
Constraints
1 <= s.length <= 100
s contains only lower and upper case English letters.

 */

/*Example 1:

Input: s = "leEeetcode"
Output: "leetcode"
Explanation: In the first step, either you choose i = 1 or i = 2, both will result "leEeetcode" to be reduced to "leetcode".
Example 2:

Input: s = "abBAcC"
Output: ""
Explanation: We have many possible scenarios, and all lead to the same answer. For example:
"abBAcC" --> "aAcC" --> "cC" --> ""
"abBAcC" --> "abBA" --> "aA" --> ""
Example 3:

Input: s = "s"
Output: "s"

 */
public class AAA1544MakeTheStringGreat {



    /* 65 to 90 is A to Z
    97 to 122 to a to z
    the difference between them is 32.


     */
    public static String makeGood(String s) {


        StringBuilder s1 = new StringBuilder();
        Character prev;
        for(char current:s.toCharArray()){
            prev = (s1.length()>0)?s1.charAt(s1.length()-1):'1'; // for prev we can put anythihng other than A to Z and a to z as in constraints it is goven
            // input s is any english character
            // if s1 is empty taking previous character to be anything other than A to Z and a to z.
            //

            /*if(Math.abs(prev-current)==32){
            if prev is '1' it mean 49 numeric
            and current is 'Q' it has 81, then the difference is 32
            then that if returns a true
            and the length of s1 is 0
            so s1.deleteCharAt fails
            so add one more condition saying to delete a character the length of s1 should be atleast 1

             */
            /*if(Math.abs(prev-current)==32 && (s1.length()>0)){
            or we can write as below
             */
            if(Math.abs(prev-current)==32 && (prev!='1')){


                s1.deleteCharAt(s1.length()-1);
            }
            else{
                s1.append(current);
            }

        }
        return s1.toString();
    }

    public static void main(String[] args) {

        System.out.println(makeGood("QkqMGmQKq"));

        System.out.println(makeGood("leEeetcode"));
        System.out.println(makeGood("abBAcC"));
        System.out.println(makeGood(""));
        System.out.println(makeGood("s"));


    }



}
