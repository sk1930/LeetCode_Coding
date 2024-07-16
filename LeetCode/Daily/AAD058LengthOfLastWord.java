package LeetCode.Daily;

public class AAD058LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        int end = s.length() -1 ;
        int ans = 0;
        while(s.charAt(end)==' '){
            end--;
        }
        // if we keep end ! = 0 as condition it fails for s = 'a' and ans will be 0
        while((end >= 0)&& (s.charAt(end)!=' ')){
            ans++;
            end--;
        }
        return ans;


    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("        luffy is still joyboy"));
        System.out.println(lengthOfLastWord("a"));



    }


}
