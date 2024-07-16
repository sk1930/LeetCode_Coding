package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class AAC013RomanToInteger {
    /*
    Here we have used String
    in next use character
    in 3rd we compare character and next character
    public static int romanToInt(String s) {

        Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("I",1);
            map.put("V",5);
            map.put("X",10);
            map.put("L",50);
            map.put("C",100);
            map.put("D",500);
            map.put("M",1000);

            int x=0;
            int j = s.length();
            int i=0;
            int cur;

            int prev = -1;
            int temp = 0;
            while (i<j){

                String p = String.valueOf(s.charAt(i));
                cur = (int)map.get(p);
                //System.out.println("cur is"+ cur);
                if ((prev < cur) && (prev != -1))
            {
                    //System.out.println("prev < cur"+ prev+"," +cur);
                    //System.out.println("x is",x);
                    x = x - (2 * prev); // in the else part we have added prev once so we
                    // are subatracting prev twice and adding current
                    //MCM ---M= 1000, C= 100
                    // in the else part first 100 is added to make x = 1100
                    // so we have to remove that 100 added, to make 1000 again
                    // next we have to add current value M to make 2000 but have to subtract C
                    // to make 1900 ie the reason we have subtracted 100 twice and then added 1000
                    //System.out.println("x is"+x);
                    x=x+cur;
                    //System.out.println("x after is"+x);

                }


                else{

                    x=x+cur;
                    prev = cur;
                }
                i++;
            }
        return x;
    }

     */


    // 2nd way here with chars

    /*
    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int x=0;
        int j = s.length();
        int i=0;
        int cur;

        int prev = -1;
        int temp = 0;
        while (i<j){
            // Character instead of String
            cur = (int)map.get(s.charAt(i));
            //System.out.println("cur is"+ cur);
            if ((prev < cur) && (prev != -1))
            {
                //System.out.println("prev < cur"+ prev+"," +cur);
                //System.out.println("x is",x);
                x = x - (2 * prev); // in the else part we have added prev once so we
                // are subatracting prev twice and adding current
                //MCM ---M= 1000, C= 100
                // in the else part first 100 is added to make x = 1100
                // so we have to remove that 100 added, to make 1000 again
                // next we have to add current value M to make 2000 but have to subtract C
                // to make 1900 ie the reason we have subtracted 100 twice and then added 1000
                //System.out.println("x is"+x);
                x=x+cur;
                //System.out.println("x after is"+x);

            }


            else{

                x=x+cur;
                prev = cur;
            }
            i++;
        }
        return x;
    }

     */


    //compare current character and next character
    // if current character is less than next character subtract it else add it
    // LIX means 50-1 = 49, then 49+x = 59
    public static int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        int x=0;
        int j = s.length();
        int i=0;
        int cur;

        int prev = -1;
        int nextChar = -1;
        while (i<j){
            // Character instead of String
            cur = (int)map.get(s.charAt(i));

            // if s has only one character then && in java is a short circuit operator so it wont go till s.charat(i+1)
            if ((i < s.length() -1) && (cur < (int)map.get(s.charAt(i+1))))
            {
                x=x-cur;
            }
            else{
                x=x+cur;
            }
            i++;
        }
        return x;
    }




    public static void main(String args[]) {
        System.out.println(romanToInt("MCM"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));


}
}