import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;  // Import the Scanner class

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter the first boundary: ");
        int limit1 = console.nextInt();
        System.out.println("Enter the second boundary: ");
        int limit2 = console.nextInt();

        for (int i=limit1; i<=limit2;i++){
            if (palindromeCheck(i)&&(primeFactors(i).size()==1)){
                System.out.println(i);
            }
        }

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
    static List<Integer> primeFactors(int n) {
        // Write a method that calculates the prime factorization
        // of a number and returns the factors as a List
        List<Integer> factors = new ArrayList<>();

//        for (int i=2; i<=n;i++){
//            if (n%i==0){
//                factors.add(i);
//            }
//        }
        //Wait the above is wrong bc it's not finding the PRIME factors
        int div=2;
        while (n>1){
            if (n%div==0) {
                factors.add(div);
                n/=div;
            } else{
                div++;
            }
        }
        return (factors);
    }
}
