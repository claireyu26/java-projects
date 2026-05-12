import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        //11/9/24
        //Luogu P5726 Scoring
        //Now there is n (n≤1000) judges that give the contestants scores, ranging from 0 to 10.
        //You need to remove the highest score and the lowest score (if there are multiple highest or lowest scores, you only need to remove one), and the average of the remaining scores is the contestant's score.
        // Now enter the number of judges and their scores, and please output the contestant's final score, accurate to 2 decimal places.

        //Input Format - Enter a positive integer in the first line, n, indicating that there is n judges.
        //Second line of input is n positive integers, each positive integer represents the score given by each judge.

        //Output Format - Output one line of two decimal places, representing the player's final score.

        //Data assurance,3≤n≤1000, each judge's score is an integer between 0 arrive 10 (Including 0 and 10).

        Scanner console=new Scanner (System.in);
        //n number of judges
        int numJudges=console.nextInt();
        console.nextLine();

        String scores=console.nextLine();
        //console.nextLine();

        int maxScore=-1;
        int minScore=11;
        String[] scoresArray= scores.split(" ");

        ArrayList<Integer> scoresArrayList= new ArrayList<>();
        for (int i=0; i <scoresArray.length;i++){
            scoresArrayList.add(Integer.parseInt(scoresArray[i]));
        }

        for(int i=0; i<scoresArray.length; i++){
            if (Integer.parseInt(scoresArray[i])>maxScore){
                maxScore=Integer.parseInt(scoresArray[i]);
            }
            if (Integer.parseInt(scoresArray[i])<minScore){
                minScore=Integer.parseInt(scoresArray[i]);
            }
        }
        //System.out.println(maxScore);
        //System.out.println(minScore);

        scoresArrayList.remove(scoresArrayList.indexOf(maxScore));
        scoresArrayList.remove(scoresArrayList.indexOf(minScore));
        //System.out.println(scoresArrayList);

        double finalScore=0;
        for(int i=0; i<scoresArrayList.size();i++){
            finalScore+=scoresArrayList.get(i);
        }
        finalScore/= scoresArrayList.size();
        System.out.format("%.2f", finalScore);


    }
}