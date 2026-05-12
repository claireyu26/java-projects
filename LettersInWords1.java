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

            //ArrayList<String> letterCounts = new ArrayList<>(Collections.nCopies(26, ""));

            //System.out.println(letterCounts);
            //ArrayList<String> alphabet = new ArrayList(Arrays.asList("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"));

            //tracking the word with the most "p"s (last one alphabetically)
            //String maxPWord = "";
            //int maxPCount = 0;

            char the_a = 'a';

            int[] currWordCharCount = new int [26]; // 1) array vs arraylist?
            //Arrays.fill(currWordCharCount, 0);
            int[] maxCharCount = new int [26];
            //Arrays.fill(maxCharCount, 0);
            String lastMaxPWord="";
            int[] each_char_max_word_length_sum = new int [26];
            //Arrays.fill(each_char_max_word_length_sum, 0);

            while (myReader.hasNextLine()) {
                //int currentNumLetters=0;
                //int countMaxLetter=0;
                String data = myReader.nextLine().toLowerCase().trim(); // read word and make it lowercase. .trim() removes whitespace
                //ArrayList<Character> currentLetters=new ArrayList<>();
                Arrays.fill(currWordCharCount, 0); //start w 0
                int currWordLength = data.length();

                for (int i = 0; i < data.length(); i++){ //per each word in txt
                    char oneChar = data.charAt(i); //each letter in the word
                    //System.out.println(oneChar);
                    int delta = oneChar - the_a; //current char - a
                    // ^ 2) why subtract them? how can char be subtracted?
                    if (delta>=0 && delta<26){
                        currWordCharCount[delta]++; //+1 for that letter
                    }
                }// get the count of each letter-26- in current word

                for (int i=0;i<26;i++){ //process for each letter
                    if(currWordCharCount[i]>maxCharCount[i]){ //if current word have more letter i
                        maxCharCount[i] = currWordCharCount[i]; //update max
                        each_char_max_word_length_sum[i] = currWordLength; // reset total length of letter i and add current word length
                        if(i==15){//handle for 'p'
                            lastMaxPWord = data;
                        }
                        // 3) below, why check if currWordCharCount[i] >0 ?
                    } else if (currWordCharCount[i]>0 && currWordCharCount[i]==maxCharCount[i]){// if current word have same letter i as max
                        each_char_max_word_length_sum[i] += currWordLength;//add current word length to total length of letter i
                        if(i==15 && data.compareTo(lastMaxPWord)>0){//handle for p
                            lastMaxPWord = data;
                        }
                    }
                }
            }
            //System.out.println(letterCounts);
            //System.out.println(letterCounts.size());
            myReader.close();

            int totalLength=0;
            for(int i=0; i<26;i++){
                totalLength += each_char_max_word_length_sum[i];
            }
            //System.out.println();
            System.out.println("The final total length of all these words is: "+totalLength);
            System.out.println("Word with most p's (last alphabetically): " + lastMaxPWord);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
