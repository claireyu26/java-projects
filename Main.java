import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;
import java.util.List;

import static java.lang.Math.round;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //10/30/24
        //Truncatable Primes - Project Euler #37
        //The number 3797 has an interesting property. Being prime itself, it is possible to continuously remove digits from left to right, and remain prime at each stage: 3797, 797, 97, and 7. Similarly we can work from right to left; 3797, 379, 37, and 3.
        //Find the sum of the only eleven primes that are both truncatable from left to right and right to left.
        //NOTE: 2, 3, 5, and 7 are not considered to be truncatable primes.

        /*int sum=0;

        ArrayList<Integer> primeNumbers=new ArrayList<>();
        ArrayList<Integer> primeNumbersReversed=primeNumbers;

        //int i=12;
        for (int i=11; i<Integer.MAX_VALUE; i++){
            primeNumbers.clear(); // Clear tryDigits for the next combination
            primeNumbersReversed.clear();
            while (i > 0) {
                primeNumbers.add(i%10);
                i/=10;
                System.out.println(primeNumbers);
                Collections.reverse(primeNumbersReversed);

                for (int j=0; j<primeNumbers.size();j++){
                    primeNumbers.remove(j);
                }
            }
        } */
        int sum=0;
        int count=0;
        int num=11;

        while (count < 11){
            if (isPrime(num) && isTruncatable(num)){
                sum+=num;
                count++;
                System.out.println("Found truncatable prime: "+ num);
            }
            num++;
        }
        System.out.println("Sum of trunc primes: "+ sum);
    }
    static boolean isPrime(int num) {
        List<Integer> factors = new ArrayList<>();
        if (num<2) return false; //0 and 1 are not prime
        int div=2;
        while (num>1){
            if (num%div==0) {
                factors.add(div);
                num/=div;
            } else{
                div++;
            }
        }
        if (factors.size()==1){
            return true;
        } else{
            return false;
        }
    }
    static boolean isTruncatable(int num){
        return isTruncLeft(num) && isTruncRight(num);
    }
    static boolean isTruncLeft(int num){
        //convert to string to find the length
        //%10 to the power of i (i in the for loop to the length of string num)
        String strNum=String.valueOf(num);

        while (num>9){
            for (int i=strNum.length(); i>0;i--){
                num=(int) Math.round(num%(Math.pow(10, i)));
                if (!isPrime(num)){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isTruncRight(int num){
        while (num>0){
            if (!isPrime(num)){
                return false;
            }
            num /= 10;
        }
        return true;
    }
}
