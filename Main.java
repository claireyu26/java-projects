import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //10/27/24
        //Pandigital Products - Problem #32 Project Euler
        //also Programming Problem of 10/21 week

        //We shall say that an n-digit number is pandigital if it makes use of all the digits 1 to n exactly once; for example, the 5-digit number, 15234, is 1 through 5 pandigital.
        //The product 7254 is unusual, as the identity, 39x186=7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
        //Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
        //HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.

        int product;
        int sumOfProducts = 0;
        int numOfPandigits = 0;

        ArrayList<Integer> digits = new ArrayList<>();
        digits.add(1);
        digits.add(2);
        digits.add(3);
        digits.add(4);
        digits.add(5);
        digits.add(6);
        digits.add(7);
        digits.add(8);
        digits.add(9);

        ArrayList<Integer> tryDigits = new ArrayList<>();
        ArrayList<Integer> pandigProducts=new ArrayList<>();

        for (int i = 1; i < 100; i++) {

            for (int j = 1; j < 10000; j++) {
                tryDigits.clear(); // Clear tryDigits for the next combination

                int temp = i;
                while (temp > 0) {
                    tryDigits.add(temp % 10);
                    temp /= 10;
                }

                // Add digits of j
                temp = j;
                while (temp > 0) {
                    tryDigits.add(temp % 10);
                    temp /= 10;
                }

                // Add digits of product
                product = i * j;
                temp = product;
                while (temp > 0) {
                    tryDigits.add(temp % 10);
                    temp /= 10;
                }

                Collections.sort(tryDigits);
                if (tryDigits.equals(digits) & !pandigProducts.contains(product)) {
                    numOfPandigits += 1;
                    sumOfProducts += product;
                    System.out.println(i+ " " + j+ " " +product);
                    pandigProducts.add(product);
                }

            }
        }
        System.out.println("Sum of all unique pandigital products is: " + sumOfProducts);
        System.out.println("Number of pandigital products is: " + numOfPandigits);



    }
}