import java.util.Scanner;  // Import the Scanner class

public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the year that you want to check: ");
        int year = console.nextInt();
        String booleanLeap=checkLeap(year);
        System.out.println(booleanLeap);

    }
    public static String checkLeap(int year){
        if (year%400==0 || ((year%100!=0) && (year%4==0))){
            return "Yes";
        }
        return "No";
    }
}
