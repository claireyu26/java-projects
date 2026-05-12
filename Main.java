//import java.lang.Math;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //11/2/24
        //Input n, output F(n) given F(n) is the nth number in the Fibinacci sequence
        //Also the problem gives us the explicit formula for F(n)
        //F(n)= [ [(1+sqrt 5)/2 ]^n  - [ (1-sqrt5) / 2 ] ^n ] / sqrt 5

        double result=fibonacci(6);
        //System.out.println("The 6th number in the Fibonacci sequence is "+ Math.round(result*100.00)/100.00);
        System.out.println("The 6th number in the Fibonacci sequence is " + String.format("%.2f", result));
    }
    static Double fibonacci(int n){
        //METHOD 1 - using the F(n) formula [brute force]
        /*
        double partOne= (1+ Math.sqrt(5))/2;
        partOne=Math.pow(partOne, n);
        double partTwo = (1-Math.sqrt(5))/2;
        partTwo=Math.pow(partTwo, n);
        return ((partOne-partTwo)/ Math.sqrt(5));

         */
        //METHOD 2 - using actual programming F(n)
        /*
        if (n==0) return 0.00;
        if (n==1) return 1.00;

        double num1=0.00;
        double num2=1.00;
        double fibonacciNumber = 0.00;

        for (int i = 2; i <= n; i++) {
            fibonacciNumber = num1 + num2;
            num1 = num2; // Update num1 to the previous Fibonacci number
            num2 = fibonacciNumber; // Update num2 to the current Fibonacci number
        }
        return fibonacciNumber;*/

        //METHOD 3 - more efficient (very smart)

        if (n==0) return 0.00;
        if (n==1) return 1.00;

        double a=0.0;
        double b=1.0;
        double sum=a+b;

        while (n>1){
            sum=a+b;
            a=b;
            b=sum;
            n--;
        }
        return sum;
    }
}