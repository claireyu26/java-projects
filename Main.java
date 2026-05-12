import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {

        //11/13/24
        //Weekly programming problem
        //The word facetious is very unusual.  What other words in English share the unusual characteristic of facetious?

        //facetious has all vowels (not including y)
        int count=0;
        try {
            File myObj = new File("/Users/Student/Downloads/words.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.contains("a") && data.contains("e") && data.contains("i") && data.contains("o") && data.contains("u")){
                    count++;
                    System.out.println(data);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(count+ " words that have all 5 vowels in this words.txt file.");

            // Print the string
            //System.out.println(st);
    }
}