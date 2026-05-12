import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        //11/10/24
        //Weekly programming problem
        //Project Euler #35 - Circular Primes

        //The number 197 is called a circular prime because all rotations of the digits: 197, 971, and 719 are themselves prime.
        //There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97
        //How many circular primes are there below one million?
        ArrayList<Integer> allCircPrimes= new ArrayList<>();
        allCircPrimes.add(2);
        int countCircPrimes=1; //start with 1 bc 2 will always be a circ prime
        for (int i=3;i<1000000;i+=2){//check odd nums only
            int iLength = String.valueOf(i).length();

            ArrayList<Integer> digits=new ArrayList<>();
            int temp=i;
            while (temp > 0) {
                digits.add(temp%10);
                temp/=10;
            }
            if (2<i && i<10) {
                if (isPrime(i)) {
                    countCircPrimes++;
                    allCircPrimes.add(i);
                }
            } else if (9 < i && i < 100) {
                if (isPrime(i) && isPrime(digitReverse(i))) {
                    countCircPrimes++;
                    allCircPrimes.add(i);
                }

            } else{
                for (int j=0; j<iLength-1;j++){

                }
            }
        }
        System.out.println("There are "+ countCircPrimes+ " circular primes below one million.");
        System.out.println("All circular primes "+ allCircPrimes);
    }
    static boolean isPrime(int x){
        if (x<2){ //if x is 0, 1, or negative, it is not prime
            return false;
        }

        for (int i=2;i*i<=x;i++){
            if ((x%i)==0){
                return false;
            }
        }
        return true;
    }
    static int digitReverse(int num){
        boolean hasStarted=false;
        String reversedNum= "";
        if (num==0){
            return 0;
        } else if (num<0){
            reversedNum+="-";
            num=-num;
            while(num>0){
                if ((num%10)==0 && !hasStarted){
                    num/=10;
                } else {
                    reversedNum+=(num % 10);
                    num/=10;
                    hasStarted=true;
                }
            }
            return Integer.parseInt(reversedNum);
        } else{ //positive
            while(num>0){
                if ((num%10)==0 && !hasStarted){ //meaning if the current digit is 0 and hasn't started yet (the later last digits)
                    num/=10;
                } else {
                    reversedNum+=(num % 10);
                    num/=10;
                    hasStarted=true;
                }
            }
            return Integer.parseInt(reversedNum);
        }
    }
}