package LeetCode.Stack.Medium;

import java.util.Stack;

public class AAA001_1717_MaximumScoreFromRemovingSubstrings {

    int ans=0;
    public int maximumGain(String s, int x, int y) {

        // if x is more score we first remove ab and then ba
        // else if y is more , we first remove ba and then remove ab

        if (x > y) {
            s = removeFirst(s, 'a', 'b',x);
            removeFirst(s, 'b', 'a',y);

        }
        else{

            s = removeFirst(s, 'b', 'a',y);
            removeFirst(s, 'a', 'b',x);

        }
        return ans;
    }

    String removeFirst(String s, char firstChar, char secondChar, int score) {

        Stack<Character> stack = new Stack<Character>();
        System.out.println(s);

        char[] c = s.toCharArray();
        for(char ci:c){
            if(stack.isEmpty() || stack.peek()!=firstChar ||ci!=secondChar){
                stack.push(ci);
            }else
            {
                stack.pop();
                ans+=score;
            }
        }
        StringBuilder sb = new StringBuilder();
        //stack.stream().forEach(char1->sb.insert(0,char1));
        stack.forEach(char1->sb.append(char1));

        //System.out.println(sb.toString());

        return sb.toString();

    }

    public static void main(String[] args) {
        AAA001_1717_MaximumScoreFromRemovingSubstrings obj = new AAA001_1717_MaximumScoreFromRemovingSubstrings();
        String x = new String("cdbcbbaaabab");

        System.out.println(obj.maximumGain(x, 4, 5)); //19

        AAA001_1717_MaximumScoreFromRemovingSubstrings obj1 = new AAA001_1717_MaximumScoreFromRemovingSubstrings();
        x = new String("aabbaaxybbaabb");
        System.out.println(obj1.maximumGain(x, 5, 4)); //20


    }
}