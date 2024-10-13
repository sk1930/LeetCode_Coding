package Concepts;

import java.util.Arrays;
import java.util.List;

public class AAA002Streams {

    public static void main(String[] args) {
        //https://www.geeksforgeeks.org/stream-in-java/

        // create a list of integers
        List<Integer> number = Arrays.asList(2, 3, 4, 5);
        int even = number.stream()
                .filter(x -> x % 2 == 0)
                .reduce(0, (ans, i) -> ans + i);

        System.out.println(even);

        //Here ans variable is assigned 0 as the initial value and i is added to it.

        even = number.stream()
                .filter(x -> x % 2 == 0)
                .reduce(1, (ans, i) -> ans + i);

        //Here ans variable is assigned 1 as the initial value and i is added to it.



        System.out.println(even);

    }


}
