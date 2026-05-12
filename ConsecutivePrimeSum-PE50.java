import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        //12/12/24
        //Weekly programming problem
        //Consecutive Prime Sum - Project Euler #50

        //The prime 41 can be written as the sum of six consecutive primes: 41 = 2+3+5+7+11+13

        //This is the longest sum of consecutive primes that adds to a prime below one-hundred
        //The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953 (prime ).
        //Which prime, below one-million, can be written as the sum of the most consecutive primes?

        System.out.println(method1(1000000)); //argument of the max (1million)

    }
    //method1 = first intuitive solution that came to mind, brute force, not very efficient
    public static Integer method1( int limit){
        //finding all primes below 1M and sum to find the largest consecutive sum
        int maxLength=0;
        int sum=0;
        int maxPrime=2;
        ArrayList<Integer> currentSum= new ArrayList<>();
        ArrayList<Integer> allPrimes = new ArrayList<>();
        for (int i=2; i<1000000;i++){
            if (isPrime(i)){
                allPrimes.add(i);
            }
        }
        for (int i=0; i<allPrimes.size();i++){
            sum=0;
            currentSum.clear();

            for (int j=i;j<allPrimes.size();j++){
                sum+=allPrimes.get(j);
                currentSum.add(allPrimes.get(j));
                if (sum>limit){ //if (sum>limit || !allPrimes.contains(sum))
                    sum=0;
                    break; //break is break out of the j for loop
                }
                if (currentSum.size()>maxLength && allPrimes.contains(sum)){
                    maxLength = currentSum.size();
                    maxPrime=sum;
                }
            }
        }
        //System.out.println("var sum "+ sum);
        System.out.println("maxPrime "+ maxPrime);
        System.out.println("var maxLength "+ maxLength);
        return maxPrime;
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
}
