import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //Project Euler #4 - Largest Palindrome Product
        //10/11/24
        //A palindrome number reads the same both ways. The largest palindrome made from the rpdouct of two 2-digit numbers is 9009=91x99. Find the largest palindrome made from the product of two 3-digit numbers.
        int largestPalin=0;
        System.out.println(palindromeCheck(12321));
        for (int a = 999; a > 99; a--) {
            for (int b = a; b > 99; b--) {  // b starts from a to avoid redundant checks
                int product = a * b;
                if (palindromeCheck(product) && product > largestPalin) {
                    largestPalin = product;
                }
            }
        }
        System.out.println("The largest palindrome made from the product of 2 three digit numbers is: "+ largestPalin);
    }
    public static boolean palindromeCheck(int x){
        int length=Integer.toString(x).length();
        ArrayList<Integer> lastHalf = new ArrayList<>();
        ArrayList<Integer> firstHalf = new ArrayList<>();

        boolean palindrome=true;
        if (length % 2 == 0) { //if the number has even # of digits

            for (int i=0; i<length/2;i++){
                lastHalf.add(x%10);
                x/=10;
            }
            for (int i=length/2; i>0;i--){
                firstHalf.add(x%10);
                x/=10;
            }
        } else{ //else odd number of digits
            for (int i=0; i<length/2;i++){
                lastHalf.add(x%10);
                x/=10;
            }
            for (int i=(length/2)+1; i>0;i--){
                firstHalf.add(x%10);
                x/=10;
            }
            firstHalf.remove(0);
        }
        for (int i = 0; i < lastHalf.size(); i++) {
            if (!lastHalf.get(i).equals(firstHalf.get(firstHalf.size() - 1 - i))) {
                palindrome = false;
                break;
            }
        }
//        System.out.println("Last half: "+lastHalf);
//        System.out.println("First half: "+firstHalf);
        return palindrome;
    }
}