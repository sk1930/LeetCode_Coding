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



public class Euler002EvenFibonacciNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());
                number(n);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
    static long number(long n){

            long first=1;
            long second=2;
            long sum=0,third=0;
            third=first+second;
            while(second<n)
            {
                if(second%2==0){
                    sum=sum+second;
                }
                third = first+second;

                first=second;
                second=third;

            }
            //System.out.println(sum);
            return sum;
        }

    }


