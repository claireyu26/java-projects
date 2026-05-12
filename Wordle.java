import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays;
import java.util.Scanner;  // Import the Scanner class
import java.util.Random;


public class Main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        Random rand = new Random();

        ArrayList<String> wordBank = new ArrayList<String>(
                Arrays.asList("quick","mound","ocean","river","error","zappy","eagle","enemy","seven"));
        System.out.println(wordBank.toString());

        int randomNum = rand.nextInt(wordBank.size());
        String answer=wordBank.get(randomNum);
        System.out.println("The answer is "+answer);
        ArrayList<Character> splitAnswer = new ArrayList<Character>();
        for (int i = 0;i < answer.length(); i++){
            splitAnswer.add(answer.charAt(i));
        }
        ArrayList<String> board = new ArrayList<String>(
                Arrays.asList("-","-","-","-","-"));
        for (int i=0; i<5;i++){
            System.out.print(board.get(i));
        }
        System.out.println();
        long count = board.stream().filter(x->x.equals('-')).count();
//        System.out.println(count);
        while (count!=0){
            System.out.println("Enter guess: ");
            for (int i=0; i<5;i++) {
                board.set(i, "-");
            }
            String guess = console.nextLine();
            guess=guess.toLowerCase();
            ArrayList<Character> splitGuess = new ArrayList<>();
            for (int i = 0;i < guess.length(); i++){
                splitGuess.add(guess.charAt(i));
            }
            //System.out.println("Your guess is "+splitGuess);
            for (int i=0; i<5;i++){
                if (splitGuess.get(i).equals(splitAnswer.get(i))){
                    //update board to change to green block at the i index
                    board.set(i, "\\033[0;32m");
                    splitAnswer.set(i,'-');
//                    System.out.println(board);
//                    board.set(i, '-');
                }
                else if (answer.contains(Character.toString(splitGuess.get(i)))){
                    System.out.println("entered the yellow else if");
//                    while (answer.contains(Character.toString(splitGuess.get(i)))){
//                        System.out.println("entered the yellow else WHILE");
                        board.set(i, "Y");
//                        splitAnswer.set(i,'-');
//                        int index=answer.indexOf(i);
//                        answer=answer.substring(0, index) + '-' + answer.substring(index + 1);
//                    System.out.println(board);
//                        System.out.println(printBoard(board));
//                    }
//                    board.set(i,'-');
                }
//                board.set(i,'-');

                //s=s.replaceFirst("a","_")
            }
//            for (int i=0; i<5;i++){
//                System.out.print(board.get(i));
//            }
            System.out.println(printBoard(board)); //if this print board is here then we get a board with dashes at the end but if we don't ever enter an if/else if then it owuld not exist
            System.out.println();
            count = board.stream().filter(x->x.equals("-")).count();
            if (answer.equals(guess)){
                System.out.println("Hooray, you got it! The word was "+answer);
                break;
            }
        }
    }
    public static String printBoard(ArrayList<Character> board){
        String stringBoard="";
        for (int i=0; i<5;i++){
//            System.out.print(board.get(i));
            stringBoard+=board.get(i);
        }
        return stringBoard;
    }
}
//9/23/24 IN-CLASS UPDATE: if the answer is river and the guess is error, then in order to handle the edge cases in the YELLOW else if, we should replace the element of the answer/river with -.
