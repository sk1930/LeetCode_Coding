package LeetCode.Daily2;


import java.util.Stack;

/*Example 1:

Input: s = "lee(t(c)o)de)"
Output: "lee(t(c)o)de"
Explanation: "lee(t(co)de)" , "lee(t(c)ode)" would also be accepted.
Example 2:

Input: s = "a)b(c)d"
Output: "ab(c)d"
Example 3:

Input: s = "))(("
Output: ""
Explanation: An empty string is also valid.

 */
public class AAA1249MinimumRemoveToMakeValidParentheses {

    //Runtime 148 ms Beats 9.73% of users with Java Memory 45.32 MB Beats 56.14% of users with Java
    public static String minRemoveToMakeValid1(String s) {
        StringBuilder s1 = new StringBuilder();
        int open=0;
        for(Character c:s.toCharArray()){
            if(c!='(' && c!=')'){
                s1.append(c);

            }
            else if(c=='('){
                open++;
                s1.append('(');

            }
            else{
                // this is for ')'
                if(open>0){
                    s1.append(c);
                    open--;
                }
            }

        }

        if(open>0){

            for(int i=0;i<open;i++){
                    s1.deleteCharAt(s1.lastIndexOf("("));
        }
    }
        return s1.toString();
    }



    // using stacks
    //Runtime 34 ms Beats 14.86% of users with Java Memory 45.70 MB Beats 20.32% of users with Java
    public static String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<Character>();

        StringBuilder s1 = new StringBuilder();
        int open=0;
        for(Character c:s.toCharArray()){
            if(c!='(' && c!=')'){
                stack.push(c);

            }
            else if(c=='('){
                open++;
                stack.push('(');

            }
            else{
                // this is for ')'
                if(open>0){
                    stack.push(')');
                    open--;
                }
            }

        }

        while (!stack.isEmpty()) {
            char currentChar = stack.pop();
            if(currentChar=='(' && open>0) {
            open--;
            }
            else{
            s1.append(currentChar);
            }
        }

        return s1.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
        System.out.println(minRemoveToMakeValid("a)b(c)d"));
        System.out.println(minRemoveToMakeValid(""));
        System.out.println(minRemoveToMakeValid("))(("));




    }

}
