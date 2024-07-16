package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class AAE020ValidParanthesis {

        /*public static boolean isValid1(String s) {
            Stack<Character> stack = new Stack<Character>();
            int i =0;
            int len = s.length();

            Character c,inStack;
            Map<Character,Character> braces = new HashMap<Character,Character>();
            braces.put('{','}');
            braces.put('(',')');
            braces.put('[',']');

            while (i<len){
                c = s.charAt(i);
                System.out.println("stack is"+stack);
                if(braces.containsKey(c)){
                    stack.push(c);
                }
                else{
                    if(stack.isEmpty()){
                        // if stack is empty and the first char is ) or } or ] then we didnt have a matching character in the stack so return false
                        // ie  inputs are like ()) or {}] or ] or )
                        return false;
                    }
                    inStack = stack.pop();
                    // stack.pop returns a key which should be the key
                    // for the current value
                    if(!(braces.get(inStack).equals(c))) {
                        // instack is ( and c is ) but if not ! is put
                        return false;
                    }

                }
                i++;
                //System.out.println(stack);

            }
            if (!stack.isEmpty()){
                // if stack is not empty after going through all the chars like
                // in [](
                return false;
            }


            return true;

        }*/
        public static boolean isValid(String s) {
            /* same as isValid1 code above  but with if and ||
            here is empty  condition should be put first
            but not after
            for the example input []{}
            if stack isEmpty then the 2nd part after || is not executed and goes to code
                                 if(stack.isEmpty() || (!(braces.get(stack.pop()).equals(c)))) {

             */

            /* if stack isEmpty is put next
            if((!(braces.get(stack.pop()).equals(c))) || stack.isEmpty()) {
                System.out.println("Came here"+ c); // []{} -- in first iteration stack is [, in 2nd iteration c is ] so it comes to else and
                then in if before || is false as ! is put and stack is already popped so executes the 2nd part of or which is not true so returns a false

                   */

            Stack<Character> stack = new Stack<Character>();
            int i =0;
            int len = s.length();

            Character c,inStack;
            Map<Character,Character> braces = new HashMap<Character,Character>();
            braces.put('{','}');
            braces.put('(',')');
            braces.put('[',']');

            while (i<len){
                c = s.charAt(i);
                //System.out.println("stack is"+stack);
                if(braces.containsKey(c)){
                    stack.push(c);
                }
                else{

                    if(stack.isEmpty() || (!(braces.get(stack.pop()).equals(c)))) {
                        // if stack is empty and the first char is ) or } or ] then we didnt have a matching character in the stack so return false
                        // ie  inputs are like ()) or {}] or ] or )

                        // or if there is no matching character in the stack also return false
                        // for [) -- c is ) and stack.pop is [ so return false
                        return false;
                    }
                }
                i++;
                //System.out.println(stack);

            }
            if (!stack.isEmpty()){
                // if stack is not empty after going through all the chars like
                // in [](
                return false;
            }


            return true;

        }

    public static void main(String args[]){
        System.out.println(isValid("[])("));
        System.out.println(isValid("[]))"));
        System.out.println(isValid("[]{{}}"));
        System.out.println(isValid(""));
    }

}
