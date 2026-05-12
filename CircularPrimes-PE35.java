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
        allCircPrimes.add(5);
        int countCircPrimes=2; //start with 1 bc 2 and 5 will always be a circ prime
        for (int i=3;i<1000000;i+=2){//check odd nums only

            int iLength = String.valueOf(i).length();
            ArrayList<Integer> digits=new ArrayList<>();

            int temp=i;
            while (temp > 0) {
                digits.add(temp%10);
                temp/=10;
            }
            Collections.reverse(digits);

            if (digits.contains(2) || digits.contains(4) || digits.contains(6) || digits.contains(8) || digits.contains(0) || digits.contains(5) || allCircPrimes.contains(i)){
                continue;
            }
            else if (2<i && i<10 && !allCircPrimes.contains(i)) {
                if (isPrime(i)) {
                    countCircPrimes++;
                    allCircPrimes.add(i);
                }
            } else if (9 < i && i < 100  && !allCircPrimes.contains(i)) {
                if (isPrime(i) && isPrime(digitReverse(i))){ //reversing the digits for a two digit number is the same as rotating it
                    countCircPrimes++;
                    allCircPrimes.add(i);
                    if (i!=digitReverse(i)) { //like 11, which we don't want it to count twice
                        countCircPrimes++;
                        allCircPrimes.add(digitReverse(i));
                    }
                }
            }
            else if (iLength==3  && !allCircPrimes.contains(i)){
                int temp1=digits.get(0);
                digits.set(0, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int secondRotation=digits.get(0)*100+digits.get(1)*10+digits.get(2);

                temp1=digits.get(0);
                digits.set(0, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int thirdRotation=digits.get(0)*100+digits.get(1)*10+digits.get(2);

                if (isPrime(i) && isPrime(secondRotation) && isPrime(thirdRotation)){
                    countCircPrimes+=3;
                    allCircPrimes.add(i);
                    allCircPrimes.add(secondRotation);
                    allCircPrimes.add(thirdRotation);
                }

            } else if (iLength==4  && !allCircPrimes.contains(i)){
                int temp1=digits.get(0);
                digits.set(0, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int secondRotation=digits.get(0)*1000+digits.get(1)*100+digits.get(2)*10+digits.get(3);

                temp1=digits.get(0);
                digits.set(0, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int thirdRotation=digits.get(0)*1000+digits.get(1)*100+digits.get(2)*10+digits.get(3);

                temp1=digits.get(0);
                digits.set(0, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int fourthRotation=digits.get(0)*1000+digits.get(1)*100+digits.get(2)*10+digits.get(3);

                if (isPrime(i) && isPrime(secondRotation) && isPrime(thirdRotation) && isPrime(fourthRotation)){
                    countCircPrimes+=4;
                    allCircPrimes.add(i);
                    allCircPrimes.add(secondRotation);
                    allCircPrimes.add(thirdRotation);
                    allCircPrimes.add(fourthRotation);
                }


            } else if (iLength==5  && !allCircPrimes.contains(i)){
                int temp1=digits.get(0);
                digits.set(0, digits.get(4));
                digits.set(4, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int secondRotation=digits.get(0)*10000+digits.get(1)*1000+digits.get(2)*100+digits.get(3)*10+digits.get(4);

                temp1=digits.get(0);
                digits.set(0, digits.get(4));
                digits.set(4, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int thirdRotation=digits.get(0)*10000+digits.get(1)*1000+digits.get(2)*100+digits.get(3)*10+digits.get(4);

                temp1=digits.get(0);
                digits.set(0, digits.get(4));
                digits.set(4, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int fourthRotation=digits.get(0)*10000+digits.get(1)*1000+digits.get(2)*100+digits.get(3)*10+digits.get(4);

                temp1=digits.get(0);
                digits.set(0, digits.get(4));
                digits.set(4, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int fifthRotation=digits.get(0)*10000+digits.get(1)*1000+digits.get(2)*100+digits.get(3)*10+digits.get(4);

                if (isPrime(i) && isPrime(secondRotation) && isPrime(thirdRotation) && isPrime(fourthRotation) && isPrime(fifthRotation)){
                    countCircPrimes+=5;
                    allCircPrimes.add(i);
                    allCircPrimes.add(secondRotation);
                    allCircPrimes.add(thirdRotation);
                    allCircPrimes.add(fourthRotation);
                    allCircPrimes.add(fifthRotation);
                }

            } else if (iLength==6  && !allCircPrimes.contains(i)) {
                int temp1=digits.get(0);
                digits.set(0, digits.get(5));
                digits.set(5, digits.get(4));
                digits.set(4, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int secondRotation=digits.get(0)*100000+digits.get(1)*10000+digits.get(2)*1000+digits.get(3)*100+digits.get(4)*10+digits.get(5);

                temp1=digits.get(0);
                digits.set(0, digits.get(5));
                digits.set(5, digits.get(4));
                digits.set(4, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int thirdRotation=digits.get(0)*100000+digits.get(1)*10000+digits.get(2)*1000+digits.get(3)*100+digits.get(4)*10+digits.get(5);

                temp1=digits.get(0);
                digits.set(0, digits.get(5));
                digits.set(5, digits.get(4));
                digits.set(4, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int fourthRotation=digits.get(0)*100000+digits.get(1)*10000+digits.get(2)*1000+digits.get(3)*100+digits.get(4)*10+digits.get(5);

                temp1=digits.get(0);
                digits.set(0, digits.get(5));
                digits.set(5, digits.get(4));
                digits.set(4, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int fifthRotation=digits.get(0)*100000+digits.get(1)*10000+digits.get(2)*1000+digits.get(3)*100+digits.get(4)*10+digits.get(5);

                temp1=digits.get(0);
                digits.set(0, digits.get(5));
                digits.set(5, digits.get(4));
                digits.set(4, digits.get(3));
                digits.set(3, digits.get(2));
                digits.set(2, digits.get(1));
                digits.set(1, temp1);
                int sixthRotation=digits.get(0)*100000+digits.get(1)*10000+digits.get(2)*1000+digits.get(3)*100+digits.get(4)*10+digits.get(5);

                if (isPrime(i) && isPrime(secondRotation) && isPrime(thirdRotation) && isPrime(fourthRotation) && isPrime(fifthRotation) && isPrime(sixthRotation)){
                    countCircPrimes+=6;
                    allCircPrimes.add(i);
                    allCircPrimes.add(secondRotation);
                    allCircPrimes.add(thirdRotation);
                    allCircPrimes.add(fourthRotation);
                    allCircPrimes.add(fifthRotation);
                    allCircPrimes.add(sixthRotation);
                }

            }
        }
        System.out.println("There are "+ countCircPrimes+ " circular primes below one million.");
   System.out.println("All circular primes "+ allCircPrimes);
   System.out.println(allCircPrimes.size());
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
