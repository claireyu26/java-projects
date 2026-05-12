import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        //11/2/24
        //Luogu Digit Occurences
        //P1980 [NOIP2013 Popularization Group] Counting Problems

        //Two arguments: first is the upper limit to the range of searched numbers, second is the digit 0-9 that we want to search for
        //11 1 <-- input
        //4 <--output

        System.out.println("Between 1 and 11, there are "+ digitOccurrences(11, 1)+" occurrences of 1.");
    }
    static Integer digitOccurrences(int upper, int num){
        //from 1 to upper
        //break down each into digits to go into an arraylist and count the appearances of num in arraylist
        int countNum=0;
        ArrayList<Integer> allDigits= new ArrayList<>();
        for (int i=1; i<=upper;i++){
            if (i<10){
                allDigits.add(i);
            } else{
                int temp=i;
                while (temp > 0) {
                    allDigits.add(temp%10);
                    temp/=10;
                }
            }
        }
        //System.out.println(allDigits);
        for (Integer allDigit : allDigits) {
            if (allDigit == num) {
                ++countNum;
            }
        }
        return countNum;
    }
}