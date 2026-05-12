import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        //11/2/24
        //Luogu P1420 The Longest Consecutive Number {sequence}

        //Input: first line is an integer n, second line are n integers separated by spaces
        //Output: a number, the number of the longest consecutive numbers
        Scanner console = new Scanner(System.in);

        //  System.out.println("Enter the length of the total sequence of numbers:");//10
        int length= console.nextInt();
        console.nextLine(); // Consume the newline character after the integer input

        // System.out.println("Enter n integers separated by spaces:");// 1 5 6 2 3 4 5 6 8 9
        String sequence= console.nextLine();

        ArrayList<Integer> sequenceList = new ArrayList<>();

        // Split the string into an array of strings
        String[] numsString = sequence.split(" ");

        // Convert each string to an integer and add to the ArrayList
        for (String num : numsString) {
            sequenceList.add(Integer.parseInt(num)); //parseInt converts from String to Int
        }
        System.out.println(sequenceList);
        int longestConsecutiveCount=0;
        int currentConsecutiveCount=1;
        for (int i=0; i<sequenceList.size()-1;i++){
            if ((sequenceList.get(i)+1==(sequenceList.get(i+1)))){
                ++currentConsecutiveCount;
            } else{
                currentConsecutiveCount=1; //reset current count
            }
            if (currentConsecutiveCount>longestConsecutiveCount){
                longestConsecutiveCount=currentConsecutiveCount;
            }
            // System.out.println("current "+ currentConsecutiveCount);
            // System.out.println("longest "+longestConsecutiveCount);
        }
        if (sequenceList.size() == 1) {
            longestConsecutiveCount = 1;
        }
        System.out.println(longestConsecutiveCount);
    }
}
