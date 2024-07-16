package LeetCode;

public class AAB009Palindrome {
    public boolean isPalindrome4(int x) {
        // finding the reverse of 2nd half
        //for 12321,  12 == 123/10 => 12== 12
        // for 123321, 123 == 123
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;

        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return (x == reversed) || (x == reversed / 10);
    }
    public static boolean isPalindrome3(int x) {
        if(x<0){
            //-121 cannot be a palindrome as -121 != 121-
            return false;
        }
        if((x!=0) && (x%10 == 0)){
            return false; // 1210  numbers ending with  0 in the 1s place can never be a palindrome.
        }
        int rev = 0;
        int num = x;
        while(x>0){
            rev = (rev *10)+(x%10);
            x/=10;

        }
        if (rev == num){
            return true;
        }
        return false;

    }

    public static boolean isPalindrome2(int x){

        if(x<0){
            //-121 cannot be a palindrome as -121 != 121-
            return false;
        }
        if((x!=0) && (x%10 == 0)){
            return false; // 1210  numbers ending with  0 in the 1s place can never be a palindrome.

        }
        String y = Integer.toString(x);
        int n = y.length();
        for(int i=0;i<((n)/2);i++){
            if (y.charAt(i)!= y.charAt(n-i-1)){
                return false;
            }
        }
        return true;


    }

    public static boolean isPalindrome1(int x) {



            int n= 3;
            for(int i=0;i<n;i++){
                System.out.println(i); //0,1,2
            }

            for(int i=0;i<n;++i){
                System.out.println(i); // 0,1,2
            }
            /* from loops perspective both are same
            The way for loop is processed is as follows

1 First, initialization is performed (i=0)
2 the check is performed (i < n)
3 the code in the loop is executed.
4 the value is incremented
5 Repeat steps 2 - 4
This is the reason why, there is no difference between i++ and ++i in the for loop which has been used.



If you want to know the difference, look at this example:

int a = 0;
int b = a++; // b = 0; a = 1

a = 0;
b = ++a: // b = 1; a = 1


             */
            return true;

        }
        public static void main(String args[]){

        /*isPalindrome1(121);
            int y=0122;
            System.out.println(y); // prints 82 // it became octal (2*8^0)+(2*8^1)+(1*8^2)= 2+16+64 = 82

            //System.out.println(7/2); // 3

            System.out.println(isPalindrome2(12321));


            System.out.println(isPalindrome2(12321));
            System.out.println(isPalindrome2(123321));
            System.out.println(isPalindrome2(11));
            System.out.println(isPalindrome2(1));

         */

            System.out.println(isPalindrome3(12321));



        }


}
