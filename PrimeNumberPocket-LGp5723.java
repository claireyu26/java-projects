import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //11/9/24
        //Luogu P5723 - Prime Number Pocket

        //Little A has a prime number pocket, which can hold prime numbers.
        //First, determine whether each natural number is a prime number or not. If it is a prime number, put the number into your pocket.
        //The load of a pocket is the sum of all the numbers in the pocket.
        //But the pocket has a limited load capacity, and the sum of the prime numbers it can hold cannot exceed
        //L. Given L, how many prime numbers can be put in your pocket? Output these prime numbers from small to large, and then output the maximum number of prime numbers that can be put in your pocket, with numbers separated by line breaks.

        //Input format: one positive integer per line L
        //Output format: output these prime numbers from small to large, and then output the maximum number of prime numbers that can be accomodated, with a blank line between all numbers

        Scanner console=new Scanner(System.in);
        int sum=0;
        ArrayList<Integer> primes= new ArrayList<>();

        int L=console.nextInt();
        console.nextLine();

        if (L!=1){
            primes.add(2); //if L is greater than 1, 2 is always going to be the first prime number pocket
        }

            for (int i=3; i<L;i+=2){
                if (isPrime(i) && ((sum+i)<=L)){
                    primes.add(i);
                    sum+=i;
                }
            }

        for (int prime: primes){
            System.out.println(prime);
        }
        System.out.println(primes.size()); //the count of the number of primes in the prime number pocket


    }

    static boolean isPrime(int x){
        //one way is the count all factors and see if factors==2
        //another way is to loop through ints from 1 to x and if (x%i)==0 then return false
        boolean primeBool=false;

        if (x<2){ //if x is 0, 1, or negative, it is not prime
            return false;
        }
        for (int i=2; i<x;i++){
            if ((x%i)==0){
                return false;
            }
        }
        return true;
    }
}
