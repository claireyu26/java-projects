import java.lang.Math;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {

        //12/16/24
        //Powerful Digit Sum - Project Euler #56
        //Weekly programming problem, week before junior winter break

        //A googol (10^100) is a massive number: one followed by one-hundred zeros;
        //100^100 is almost unimaginably large: one followed by two-hundred zeros. Despite their size, the sum of the digits in each number is only 1.
        //Considering natural numbers of the form, a^b, where a,b<100, what is the maximum digital sum?

        //natural numbers= 1, 2,3... (sometimes 0)

        int maxDigSum=1;
        //double current;
        BigInteger current;

        int currentDigSum;

        for (int a=1; a<100;a++){
            for (int b=1; b<100; b++){ //1-3
                //current=Math.pow(a,b);
                current = BigInteger.valueOf(a).pow(b);

                System.out.println(a+" "+b);
                System.out.println("current "+current);
                currentDigSum=calcDigSum(current);
                System.out.println(currentDigSum);
                if (currentDigSum>maxDigSum){
                    maxDigSum=currentDigSum;
                }
            }
        }
        System.out.println("maxDigSum = "+maxDigSum);
    }

    public static Integer calcDigSum(BigInteger x){
        int digSum=0;

//        while (x>0){
//            digSum+= (x%10);
//            x/=10;
//        }
        while (x.compareTo(BigInteger.ZERO) > 0) {
            BigInteger[] divmod = x.divideAndRemainder(BigInteger.TEN); //big integer's % function
            digSum += divmod[1].intValue(); // the above divide and remainder returns an array of 2 bigintegers [quotient, remainder]
            x = divmod[0]; //leftover quotient
        }
        return digSum;
    }
}
