package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class AAE205IsomorphicStrings {


    // implementing with maps is correct
    public static boolean isIsomorphic(String s, String t) {
        Map<Character,Character> map = new HashMap<Character,Character>();

        if(s.length()!=t.length()){
            return false;
        }
        Character c1,c2;
        int i =0;
        while(i<s.length()) {
            c1 = s.charAt(i);
            c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (c2 != map.get(c1)) {
                    return false;
                }
            }
            else if(map.containsValue(c2)){
                if(map.get(c1)!= c2){
                    return false;
                }
            }
            else {
                map.put(c1,c2);
            }
            i++;
        }

        return true;
    }



    //taking arrays is wrong here and better to use maps as this failed for inputs
    // paper vs tiile which returns a true here but should return a false
    public static boolean isIsomorphic1(String s, String t) {
        int freq1[] = new int[127];  // taking array size to be 127 as there are 127 ascii characters
        int freq2[] = new int[127];

        if(s.length()!=t.length()){
            return false;
        }
        int i =0;
        while(i<s.length()) {
            if(freq1[s.charAt(i)]!=freq2[t.charAt(i)]){
                return false;
            }
            freq1[s.charAt(i)]= freq1[s.charAt(i)]+1;
        freq2[t.charAt(i)] = freq2[t.charAt(i)] +1;
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("title","paper"));
        System.out.println(isIsomorphic("tiile","paper"));
        System.out.println(isIsomorphic("badc","baba"));


        System.out.println(isIsomorphic1("title","paper"));
        System.out.println(isIsomorphic1("tiile","paper"));




    }
}
