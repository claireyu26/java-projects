import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // BigInteger to hold the sum
        BigInteger sum = BigInteger.ZERO;

        // Loop through numbers between 1 million and 2 million
        for (int i = 1000000; i < 2000001; i++) {
            if (isSmallFactorNumber(i)) {
                sum = sum.add(BigInteger.valueOf(i));
            }
        }

        // Print the result
        System.out.println(sum);
    }

    // Check if a number is a small factor number (i.e., only has 2, 3, and 5 as its prime factors)
    static boolean isSmallFactorNumber(int x) {
        // Divide by 2 as much as possible
        while (x % 2 == 0) {
            x /= 2;
        }

        // Divide by 3 as much as possible
        while (x % 3 == 0) {
            x /= 3;
        }

        // Divide by 5 as much as possible
        while (x % 5 == 0) {
            x /= 5;
        }

        // If the remaining value is 1, the number only has 2, 3, and 5 as prime factors
        return x == 1;
    }
}
