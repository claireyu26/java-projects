import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        // Pandigital Products - Project Euler Problem #32

        int product;
        int sumOfProducts = 0;
        boolean[] productFound = new boolean[10000]; // To track unique products

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

        System.out.println("Pandigital numbers and their products:");

        for (int i = 1; i < 100; i++) {
            for (int j = 1; j < 10000; j++) {
                tryDigits.clear(); // Clear tryDigits for the next combination

                // Add digits of i
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

                // Check if sorted digits match the pandigital pattern
                Collections.sort(tryDigits);
                if (tryDigits.equals(digits)) {
                    // Check if this product was already found
                    if (!productFound[product]) {
                        productFound[product] = true; // Mark as found
                        sumOfProducts += product; // Add to sum
                        System.out.println(i + " x " + j + " = " + product); // Print each pandigital
                    }
                }
            }
        }
        System.out.println("Sum of all unique pandigital products is: " + sumOfProducts);
    }
}
