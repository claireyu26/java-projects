import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //11/19/24
        //Week of 11/18 programming problem

        //Using WordList.txt, find the words that have the highest # of each letter.
        // For example, "powwow" has 3 w's.  Do any words have more than 3 w's?
        // If not, powwow would be one of the words that you would use here.
        // If there are other words that also have 3 w's, you need to find them as well.
        //
        //Add up the lengths of all words--the words with the most a's, the most b's, etc.--and report that total.
        // If there are multiple words with the highest number of the specific letter, include them all.
        //In addition, print out the last word, alphabetically, that has the largest number of "p"s.
        // --> So your final answer should be a number (total number of letters) and a word with a bunch of p's in it.

        try {
            File myObj = new File("/Users/Student/Downloads/WordList.txt");
            Scanner myReader = new Scanner(myObj);
            ArrayList<String> letterCounts = new ArrayList<>(Collections.nCopies(26, ""));

            //System.out.println(letterCounts);
            ArrayList<String> alphabet = new ArrayList(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));

            //tracking the word with the most "p"s (last one alphabetically)
            String maxPWord = "";
            int maxPCount = 0;

            while (myReader.hasNextLine()) {
                int currentNumLetters=0;
                int countMaxLetter=0;
                String data = myReader.nextLine().toLowerCase(); // Read word and make it lowercase.
                ArrayList<Character> currentLetters=new ArrayList<>();
                for (int i = 0;i < data.length(); i++){
                    currentLetters.add(data.charAt(i));
                }
                for(int i=0;i<alphabet.size();i++){//gets the a-z letter
                    for(int j=0; j<currentLetters.size();j++){//each digit of a [w,o,r,d]
                        if (Character.toString(currentLetters.get(j)).equals(alphabet.get(i))){//if the word contains the current letter
                            currentNumLetters++;
                            //System.out.println(alphabet.get(i)+" "+currentLetters+" "+currentNumLetters);
                        }
                    }
                    if (currentNumLetters>countMaxLetter || currentNumLetters==countMaxLetter){
                        countMaxLetter=currentNumLetters;
                        letterCounts.set(i, data);
                    }
                    currentNumLetters=0;
                }
                //System.out.println(currentLetters);

                int pIndex = alphabet.indexOf("p");
                if (Integer.parseInt(letterCounts.get(pIndex)) > maxPCount || (Integer.parseInt(letterCounts.get(pIndex)) == maxPCount)) {
                    maxPCount = Integer.parseInt(letterCounts.get(pIndex));
                    maxPWord = data;
                }

            }
            System.out.println(letterCounts);
            System.out.println(letterCounts.size());
            myReader.close();
            int totalLength=0;
            for(int i=0; i<letterCounts.size();i++){
                totalLength+=letterCounts.get(i).length();
            }
            System.out.println("The final total length of all these words is: "+totalLength);
            System.out.println("Word with most p's (last alphabetically): " + maxPWord);


        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}