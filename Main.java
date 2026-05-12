public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //Highly Divisible Triangular Number
        //10/19/24
        int sum=0;
        int divisors=0;
        for (int i=1; i<=Integer.MAX_VALUE;i++){
            sum+=i;
            divisors=countDivisors(sum);
//            for (int j=1; j<=sum;j++){
//                if (sum%j==0){
//                    divisors++;
//                }
//            }
            if (divisors>500){
                System.out.println("The first triangular number with more than 500 divisors is: "+sum);
                break;
            }
        }

    }
    public static int countDivisors(int x){
        int count=0;
        for (int i=1;i<=x;i++){
            if (x%i==0){
                count++;
            }
        }
        return count;

        //OR A FASTER WAY USING SQRT to automatically count half the factors
//        int count = 0;
//        for (int j = 1; j * j <= number; j++) {
//            if (number % j == 0) {
//                count += 2; // j and (number / j)
//                if (j * j == number) {
//                    count--; // If it's a perfect square, we counted one divisor twice
//                }
//            }
//        }
//        return count;
    }
}