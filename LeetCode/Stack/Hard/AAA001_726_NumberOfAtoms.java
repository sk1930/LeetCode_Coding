package LeetCode.Stack.Hard;

// important
//https://leetcode.com/problems/number-of-atoms/?envType=daily-question&envId=2024-07-14
import java.util.*;

public class AAA001_726_NumberOfAtoms {

    // implemented using stack of hashmaps
    public String countOfAtoms(String formula) {
        int len = formula.length();
        Stack<HashMap<String, Integer>> stackMap = new Stack<>();
        HashMap<String, Integer> topMap;


        int start;
        String atom;
        int number;
        stackMap.push(new HashMap<String,Integer>());
        // if the input is like Mg(O)2 then when O) comes it takes out the elements from the top stack
        // and puts in the above hashmap
        for (int i = 0; i < len; ) {
            if (formula.charAt(i) == '(') {
                // whenever a new bracket comes, start with a new HashMap
                stackMap.push(new HashMap<String,Integer>());
                i++;

            } else if (formula.charAt(i) == ')') {
                //whenever a ) is there, take out the top element from the stack and
                // multiply by the number after the ) and put back in the previous stack
                //(MgO)2
                i++;
                topMap = stackMap.pop();
                start=i;
                while(i<len && Character.isDigit(formula.charAt(i))) i++;
                // the number can be more than a single digit like 22,33 or any thing so get the total number
                // if the number is having more than one digit i moves ahead so start can be less than i
                //  in case of MgO after Mg, start will be 2 and i will be at 2 only, so the count will be 1
                number=start<i?Integer.parseInt(formula.substring(start,i)):1;
                for(String atom1:topMap.keySet()){
                    stackMap.peek().put(atom1,stackMap.peek().getOrDefault(atom1,0)+topMap.get(atom1)*number);
                }
            }
            else{
                // it is a character
                start=i;
                i++;
                while(i<len && Character.isLowerCase(formula.charAt(i))) i++;
                atom = formula.substring(start,i);
                start=i;
                while(i<len && Character.isDigit(formula.charAt(i))) i++;
                // the number can be more than a single digit like 22,33 or any thing so get the total number
                // if the number is having more than one digit i moves ahead so start can be less than i
                //  in case of MgO after Mg, start will be 2 and i will be at 2 only, so the count will be 1
                number=start<i?Integer.parseInt(formula.substring(start,i)):1;
                //if the same element/atom is already present in the hashmap , get that value and increase by the number.
                stackMap.peek().put(atom,stackMap.peek().getOrDefault(atom,0)+number);
            }
        }
        topMap = stackMap.pop();
        List<String> atomsList = new ArrayList<>(topMap.keySet());
        Collections.sort(atomsList);
        StringBuilder sb = new StringBuilder();
        for (String atom1 : atomsList) {
            sb.append(atom1);
            int count = topMap.get(atom1);
            if (count > 1) sb.append(count);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        String x = new String("H2O");
        AAA001_726_NumberOfAtoms obj = new AAA001_726_NumberOfAtoms();

        //System.out.println(obj.countOfAtoms(x)); //H20

        x = new String("Mg(OH)2");
        //System.out.println(obj.countOfAtoms(x));//H2MgO2


        x = new String("K4(ON(SO3)2)2");
        System.out.println(obj.countOfAtoms(x)); //K4N2O14S4
    }

}
