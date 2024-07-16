package Geeks;

class AAACatalan{
    /*https://www.geeksforgeeks.org/program-nth-catalan-number/
    better performance with binomial coefficient implementaion
    0 1 2 3 4 5
    1 1 2 5 14 42
     */

    static int cat(int n){

        int arr[] = new int [n+2];

        arr[0]=1;
        arr[1]= 1;

        if(n<=1) {
            return arr[n];
        }
            for(int i=2;i<=n;i++)
            {
                arr[i]=0;
                for (int j=0;j<i;j++)
                {
                    arr[i] += arr[j]*arr[i-j-1];

                }
            }

        return arr[n];


    }


    public static void main(String argsp[])
    {
        System.out.println(cat(5));
    }

}