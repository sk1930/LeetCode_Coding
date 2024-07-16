package LeetCode.Stack.Medium;

//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

import java.util.Stack;

public class AAA001_1190_ReverseSubstringsBetweenEachPairOfParentheses {
    static String reverseParentheses(String s) {
        Stack<Integer> positions = new Stack<>();
        int len = s.length();
        int j;
        int[] relativePositions = new int[len];
        for(int i=0;i<len;i++){
            if(s.charAt(i)=='('){
                positions.push(i);
            } else if (s.charAt(i)==')') {
                j = positions.pop();
                relativePositions[j]=i;
                relativePositions[i]=j;
            }

        }
        StringBuilder sb = new StringBuilder();
        int direction=1;
        // at 0 index it will goto 5 and start from 5-1
        // once 0 is reached from 5,4,3,2,1, it again changes direction and becomes 6
        for(int i=0;i<len;i+=direction){
            if((s.charAt(i)=='(')||(s.charAt(i)==')')){
                i=relativePositions[i];
                direction=direction*-1;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String x = new String("(abcd)");

        System.out.println(reverseParentheses(x)); //dcba


        x = new String("(u(love)i)");
        System.out.println(reverseParentheses(x)); //iloveu


        x = new String("(ed(et(oc))el)");
        System.out.println(reverseParentheses(x)); //leetcode



    }

}
