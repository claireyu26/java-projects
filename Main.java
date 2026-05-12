import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //11/30/24
        //P1200 [USACO 1.1] Your Ride Is Here
        //To know if a UFO is going to take a group of loyal supporters, each comet has a name and the names are used to determine whether the group is the specific group taht will be taken away.
        //Both group and comet names are converted to a number in the following way: the final number is the product of all the letters in the name, where A is 1 and Z is 26.
        //For example, USACO, the group is 21*19*1*3*15 =1795.
        //If the number of the group mod 47 equals to the comet mod 47, then tell the group to be prepared to be taken away.
        //Write a program that reads in teh comet name and group name and calculates whether the two names can be matched using the above scheme.
        //If they can be matched, output GO otherwise output STAY.
        // The group name and the comet name are all capital letters (no more than 100 characters) without spaces or punctuation. 6letters).

        //Input: line 1: 1 string of length 6 uppercase letters representing the name of the comet
        //line 2: same thing but represents name of the team

        //COMETQ \n HVNGAT --> GO
        //ABSTAR \n USACO --> STAY

        Scanner console=new Scanner (System.in);

        String cometName=console.nextLine();
        String teamName=console.nextLine();
        //console.nextLine();

        char[] cometNameArray = cometName.toCharArray();
        char[] teamNameArray= teamName.toCharArray();

        long cometProduct=1;
        long teamProduct=1;


        for (int i=0; i<cometNameArray.length;i++){
            cometProduct*=((int) cometNameArray[i] -64); //A's ascii is 65 so minus 64 gets 1
            //System.out.println(cometProduct);
        }
        for (int i=0; i<teamNameArray.length;i++){
            teamProduct*=((int) teamNameArray[i]-64);
        }
        // System.out.println(cometProduct);
        //System.out.println(teamProduct);


        if ((cometProduct%47) ==(teamProduct%47)){
            System.out.println("GO");
        } else{
            System.out.println("STAY");
        }
    }
}
