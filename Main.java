import java.util.*;


public class Main {
    public static void main(String[] args) {

        //11/26/24
        //11/25 weekly programming problem
        //Pandigital Prime - Project Euler #41
        //We shall say that a n-digit number is pandigital if it makes use of all the digits 1 to n exactly once. For example, 2143 is a 4-digit pandigital and is also prime.
        //
        //What is the largest n-digit pandigital prime that exists?
        //(n can be anything)

        //Two ways to go about this: 1) less elegant for loop algorithm of searching through ALL numbers and checking if pandigital and then prime
        //2) more elegant and cool, possibly more efficient. Similar to Python's itertools package and permutations(a) Use itertools permutations, sort, check if prime for each digit length,
        //Tuples to int conversion issue for using permutations in itertools (numpy in python converts to array though)

        solution1();
        solution2();

        //System.out.println(pandigChecker(2143));
        //REMEMBER TO CASE CHECK FOR NEGS AS WELL
    }
    static int solution1(){//for loop, brute force solution
        final long startTime = System.currentTimeMillis();
        int maxPandigPrime=0;
        for (int i=1233; i<=987654321; i+=2){
            if (pandigChecker(i)) {
                if (isPrime(i)) {
                    if (i > maxPandigPrime) {
                        maxPandigPrime = i;
                    }
                }
            }
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Solution1: Total execution time: " + (endTime - startTime)+ " milliseconds.");
        System.out.println("Solution1: Largest Pandigital Prime: " + maxPandigPrime);
        return maxPandigPrime;
    }
    static int solution2(){//more elegant solution with permutations
        int maxPandigPrime=2143;
        final long startTime = System.currentTimeMillis();
        boolean foundAnswer=false;
        int count=9; //start with the 9digits and decrease from there
        while (!foundAnswer && count >= 1){ //if foundAnswer==false
            String digitString="";
            for (int i=0; i<count;i++){
                digitString+=i+1;
            }
            List<String> allPermutations=(permutation(digitString));
            Collections.sort(allPermutations);//now allPermutations is sorted from least to greatest
            //so essentially, for each iteration of count, we have (in the list allPermutations) count-digit! elements sorted from least to greatest of all permutations of 1-count.
            //This means that all the elemnts in allPermutations are all the possible pandigital numbers for count digits.
            for (int i=allPermutations.size(); i>0;i--){
                if (isPrime(Integer.parseInt(allPermutations.get(i-1)))){
                    foundAnswer=true;
                    maxPandigPrime=(Integer.parseInt(allPermutations.get(i-1)));

                    break;
                }
            }
            count-=1;
        }
        final long endTime = System.currentTimeMillis();
        System.out.println("Solution2: Total execution time: " + (endTime - startTime)+ " milliseconds.");
        System.out.println("Solution2: Largest Pandigital Prime: " + maxPandigPrime);
        return maxPandigPrime;

    }
//    public static void permutation(String str) {
//        permutation("", str);
//    }
//
//    private static void permutation(String prefix, String str) {
//        int n = str.length();
//        if (n == 0) System.out.println(prefix);
//        else {
//            for (int i = 0; i < n; i++)
//                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
//        }
//    }
    public static List<String> permutation(String str) {
        return permutation("", str);
    }

    // Private helper method that accumulates permutations in a list
    private static List<String> permutation(String prefix, String str) {
        List<String> result = new ArrayList<>();
        int n = str.length();

        if (n == 0) {
            result.add(prefix);  // Add the permutation to the list
        } else {
            for (int i = 0; i < n; i++) {
                result.addAll(permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)));
            }
        }
        return result;
    }

    static boolean pandigChecker(int x){
        int[] countNums=new int[9];
        int xLength=Integer.toString(x).length();
        //System.out.println("xLength: "+xLength);
        int[] realCountNums= {0,0,0,0,0,0,0,0,0}; //the model countNums that is going to be compared with to see if it's all 1s in n indexes
        for (int i=0; i<xLength;i++) {
            realCountNums[i]=1;
        }
        //System.out.println("realCountNums: "+ Arrays.toString(realCountNums));
        int[] xDigits=new int[xLength];
        for (int i=0; i<xLength;i++) {
            if (x%10==0){
                return false; //1-n pandigital cannot include 0
            }else {
                xDigits[i] = x % 10;
                x /= 10;
            }
        }
        //System.out.println("xDigits: "+ Arrays.toString(xDigits));
        for (int i=0; i<xDigits.length;i++) {
            countNums[xDigits[i]-1]+=1;
            //if (xDigits[i])
        }
        //System.out.println("countNums: "+ Arrays.toString(countNums));
        if (Arrays.equals(realCountNums, countNums)){
            return true;
        } else{
            return false;
        }
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


