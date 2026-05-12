import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //11/30/24
        //Luogu P1205 Transformations [USACO 1.2]

        //A piece of nxn square black and white tiles is to be transformed into a new pattern of squares.
        // Write a program to find the minimum way to transform the original pattern into the new pattern using the following transformations:
        // 1. Rotate 90deg: the pattern rotates clockwise 90 deg.
        // 2. Rotate 180deg: the pattern rotates clockwise 180deg.
        // 3. Rotate 270deg: the pattern rotates clockwise 270deg.
        // 4. Reflection: the pattern is flipped horizontally (forming a mirror image of the original pattern centered on the central plumb line).
        // 5. Combination: the pattern is flipped horizontally and then a 1-3 kind of conversion between them again.
        // 6. No change: the original pattern is equal to the new pattern, remains unchanged.
        // 7. Invalid conversion: it is impossible to get a new pattern using the above methods.
        //If there are multiple conversion methods available, choose the one with the lowest sequence number.
        //Only use the above 7, the conversion is done in one of these steps.

        //Input format: the first line contains a positive integer n,
        // the n lines each with n characters all @ or - representing the initial square,
        // then another n lines each with n characters all @ or - representing the final square.
        //Output format: a single line, containing a number 1-7 that indicates the conversion method needed to
        // transform the pre-conversion square into the post-conversion square.

        //Input #1: 3 \n @-@ \n --- \n @@- \n @-@ \n @-- \n --@
        //Output #1: 1

        //Data range: for 100% data, 1<= n <= 10
        Scanner console=new Scanner (System.in);
        //N desired money amount total
        String temp=console.nextLine();
        //console.nextLine();
        int n=Integer.parseInt(temp);

        char[][] initialArray=new char[n][n];
        char[][] finalArray=new char[n][n];

        for(int i=0;i<n;i++){
            String temp2=console.nextLine();
            for(int j=0;j<n;j++){
                initialArray[i][j]=temp2.charAt(j);
            }
        }
        for(int i=0;i<n;i++){
            String temp2=console.nextLine();
            for(int j=0;j<n;j++){
                finalArray[i][j]=temp2.charAt(j);
            }
        }
        /*
        String row1Initial=console.nextLine();
        //console.nextLine();
        String row2Initial=console.nextLine();
        //console.nextLine();
        String row3Initial=console.nextLine();
        //console.nextLine();
        String row1Final=console.nextLine();
        //console.nextLine();
        String row2Final=console.nextLine();
        //console.nextLine();
        String row3Final=console.nextLine();
        //console.nextLine();

        char[] row1InitialArray = row1Initial.toCharArray();
        char[] row2InitialArray = row2Initial.toCharArray();
        char[] row3InitialArray = row3Initial.toCharArray();


        System.out.println("row1initialarray "+ Arrays.toString(row1InitialArray));
        System.out.println("row2initialarray "+ Arrays.toString(row2InitialArray));
        System.out.println("row3initialarray "+ Arrays.toString(row3InitialArray));

        System.out.println(Arrays.deepToString(initialArray));

        initialArray[0] = Arrays.copyOf(row1InitialArray, n);
        initialArray[1] = Arrays.copyOf(row2InitialArray, n);
        initialArray[2] = Arrays.copyOf(row3InitialArray, n);
*/
        System.out.println(Arrays.deepToString(initialArray));
        System.out.println(Arrays.deepToString(finalArray));

    }
}