import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        //12/7/24
        //Luogu P1217 [USACO 1.5] Prime Palindomes

        //Write a program to find the range [a,b] (5<=a < b <= 100,000,000) of all palindromic primes

        //Enter two positive integers in one line a and b.
        //Output format: output a list of palindromic prime numbers, one per line.

        //Input #1: 5 500
        //Output #1: 5 \n 7 \n 11 \n 101 \n 131 \n 151 \n 181 \n 191 \n 313 \n\ 353 \n\ 373 \n 383

        Scanner console = new Scanner(System.in);  // Create a Scanner object

        String range = console.nextLine();
        String[] rangeNumbers=range.split(" ");
        int a=Integer.parseInt(rangeNumbers[0]);
        int b=Integer.parseInt(rangeNumbers[1]);

        for (int i=a; i<=b;i++){
            if (isPalindrome(i) && isPrime(i) ){ //faster than isPrime(i) && isPalindrome(i)
                System.out.println(i);
            }
        }
        //method 2: construct palindromes and check if they are prime. may have to order it bc the problem wants it to be printed in order since making the palindromes is random order
        //10 --> creates 101 and 1001


    }

    static boolean isPrime(int x){
        if (x<2){
            return false;
        }
        for (int i=2; i*i<=x;i++){
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(int x){
        if (x<0){
            x=Math.abs(x);
        }
        int lengthX=String.valueOf(x).length();
        int[] xDigits=new int[lengthX];

        int temp=x;
        for (int i=0; i<lengthX;i++){
            xDigits[i]=temp%10;
            temp/=10;
        }

        //Collections.reverse(Arrays.asList(xDigits));
        //REVERSING AN ARRAY
        /*
        for (int i = 0; i < xDigits.length / 2; i++) {
            int t = xDigits[i];
            xDigits[i] = xDigits[xDigits.length - 1 - i];
            xDigits[xDigits.length - 1 - i] = t;
        }
        */
        //System.out.println("xDigits "+ Arrays.toString(xDigits));

        //checking if palindromic

        for (int i=0; i<lengthX/2;i++){
            if (xDigits[i]!=xDigits[lengthX-i-1]){
                return false;
            }
        }
        return true;
    }
}
