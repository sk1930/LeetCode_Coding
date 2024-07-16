package LeetCode.Stack.Easy;

//https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/

import java.util.Stack;

public class AAA1598CrawlerLogFolder {
    static int minOperations(String[] logs) {
        Stack<String> x = new Stack<String>();

        for(String y:logs){
            if(y.equals("../")){
                if(!(x.isEmpty())) {
                    // if x is empty and u try to pop. u get a error
                    x.pop();
                }
            }else if (y.equals("./")) {

            }
            else{
                x.push(y);
            }
        }
        return x.toArray().length;


    }
    public static void main(String[] args) {
        String[] x = new String []{"d1/","d2/","./","d3/","../","d31/"};

        System.out.println(minOperations(x)); //3

        x = new String[]{"d1/","../","../","../"};
        System.out.println(minOperations(x)); //0

        x = new String[]{"./","../","./"};
        System.out.println(minOperations(x)); //0

    }

}
