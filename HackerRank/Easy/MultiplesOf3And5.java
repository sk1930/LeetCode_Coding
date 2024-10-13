package HackerRank.Easy;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class MultiplesOf3And5 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());
                System.out.println(findValue(n));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
    static long findValue(int n){
        //for example if n is 10
        //below 10 we have 3,6,9
        // 10/3 and 3(1+2+3) gives sum of values below 10
        // 10/5 and 5(1+2) gives sum of values below 10
        // sum is n*(n+1)/2

        n=n-1;  // we only need values below n, like if 10 is passed we have to consider only till 9
        /*int fails a few testcases had to use long

         */

        long n1=n/3;
        long n2=n/5;
        long n3=n/15;
        //multiples of 15 are counted twice once in 3 multiples, once in 5 multiples
        // so remove one set
        long sum1 = 3* (n1 * (n1+1))/2;
        long sum2 = 5* (n2 * (n2+1))/2;
        long sum3= 15* (n3 * (n3+1))/2;
        System.out.println(sum1+sum2-sum3);

        return sum1+sum2-sum3;
    }

}

