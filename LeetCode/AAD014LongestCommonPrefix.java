package LeetCode;

public class AAD014LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length ==0){
            return "";

        }

        int i=0;
        StringBuilder res=new StringBuilder();
        int len=Integer.MAX_VALUE;
        for (String s:strs){
            len = Integer.min(len,s.length());
        }
        int flag = 1;
        while ((i< len)&& (flag == 1)) {
            for (String s : strs) {
                if (s.charAt(i) != strs[0].charAt(i)) {
                    flag = 0;
                    break;

                }
            }
            if (flag == 1) {
                res.append(strs[0].charAt(i));
            }
            else{
                break;
            }
            i++;
        }

        return res.toString();
    }



        public static void main(String args[]){
            System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
            System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
            System.out.println(longestCommonPrefix(new String[]{}));



    }
}
