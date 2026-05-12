public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //Digit Fifth Powers - Project Euler 30
        //10/19/24
        int totalSum=0;
        for (int i=2;i<Integer.MAX_VALUE;i++){
            if (sumOfFifthPowerDigits(i)==i){
                totalSum+=i;
            }
        }
        System.out.println(totalSum);
    }
    public static int sumOfFifthPowerDigits(int x){
        int finalSum=0;
        int length=Integer.toString(x).length();
        for (int i=0;i<length;i++){
            finalSum+=Math.pow(x%10,5);
            x/=10;
        }
        return finalSum;
    }
}