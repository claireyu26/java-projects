import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // Matt's first weekly programming problem in 2025
        // 1/7/25

        // We shall define a small factor number as a number whose only prime factors are 2, 3, and 5.
        // Thus, 30 (2 * 3 * 5) is a small factor number, as is 120 (2^3 * 3 * 5).
        // 48 = 2^4 * 3, so without a 5 as a factor, it is not a small factor number.
        // Neither is 40, which is 2^3 * 5, missing a factor of 3.
        //
        // What is the sum of all small factor numbers between 1 million and 2 million?

        // METHOD 1: looping through a million numbers and checking if the prime factors are 2, 3, 5
        BigInteger sum = BigInteger.ZERO;

        for (int i = 1000000; i <= 2000000; i++) {
            if (isSmallFactorNumber(i)) {
                sum = sum.add(BigInteger.valueOf(i));
            }
        }
        System.out.println("Method 1 Sum: " + sum);

        // METHOD 2: generating the small factor numbers
        BigInteger sum2 = BigInteger.ZERO;

        //initially i had starting i, j, k value of 0 but that is what made my answer wrong. Change to int i=1 instead for i j and k
        for (int i = 1; i < 21; i++) { // 2^21 is just over 2,000,000
            for (int j = 1; j < 14; j++) { // 3^13 is just over 2,000,000
                for (int k = 1; k < 10; k++) { // 5^9 is just over 2,000,000
                    BigInteger current = BigInteger.valueOf(2).pow(i)
                            .multiply(BigInteger.valueOf(3).pow(j))
                            .multiply(BigInteger.valueOf(5).pow(k));

                    if (current.compareTo(BigInteger.valueOf(1000000)) >= 0 &&
                            current.compareTo(BigInteger.valueOf(2000000)) <= 0) {
                        sum2 = sum2.add(current);
                    }

                    // Break early if the current value exceeds the upper bound
                    if (current.compareTo(BigInteger.valueOf(2000000)) > 0) {
                        break;
                    }
                }
            }
        }
        System.out.println("Method 2 Sum: " + sum2);
    }

    // Checks if a number's only prime factors are 2, 3, and 5
    static boolean isSmallFactorNumber(int x) {
        while (x % 2 == 0) {
            x /= 2;
        }
        while (x % 3 == 0) {
            x /= 3;
        }
        while (x % 5 == 0) {
            x /= 5;
        }
        return x == 1; // True if all factors are reduced to 1
    }
}
