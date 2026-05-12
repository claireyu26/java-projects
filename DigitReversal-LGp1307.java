public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //11/2/24
        //Luogu Digital Reversal #1307
        //Given an integer
        //N, please reverse the digits of the number to get a new number. The new number should also satisfy the common form of integers, that is, unless the given original number is zero, the highest digit of the new number after reversal should not be zero
        System.out.println(digitReverse(-300900));
    }
    static String digitReverse(int num){
        boolean hasStarted=false;
        String reversedNum= "";
        if (num==0){
            return "0";
        } else if (num<0){
            reversedNum+="-";
            num=-num;
            while(num>0){
                if ((num%10)==0 && !hasStarted){
                    num/=10;
                } else {
                    reversedNum+=(num % 10);
                    num/=10;
                    hasStarted=true;
                }
            }
            return reversedNum;
        } else{ //positive
            while(num>0){
                if ((num%10)==0 && !hasStarted){ //meaning if the current digit is 0 and hasn't started yet (the later last digits)
                    num/=10;
                } else {
                    reversedNum+=(num % 10);
                    num/=10;
                    hasStarted=true;
                }
            }
            return reversedNum;
        }
    }
}
