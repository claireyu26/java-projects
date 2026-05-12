import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        //12/19/24
        //Check if a paren expression (str) is balanced
        //"" "()" "( () )" are balanced
        //"(" ")(" "(()" are not balanced
        Scanner console=new Scanner (System.in);
        String expression = console.nextLine();
        System.out.println(checkBalanced(expression));

    }
    public static boolean checkBalanced(String expression){
        expression= expression.replaceAll(" ", "");

        //ArrayList<Character> splitExpression = new ArrayList<>(Arrays.asList(expression.split("")));
        char[] splitExpression = expression.toCharArray();

        int length =expression.length();

        if (length==0){
            return true;
        }
        if (length%2!=0 ){
            return false;
        }
        if (splitExpression[0]==')' || splitExpression[length-1]=='('){
            return false;
        }
        int countLeft=0;
        int countRight=0;

        for (int i=0; i<length;i++){
            if (splitExpression[i]=='('){
                countLeft++;
            } else if (splitExpression[i]==')'){
                countRight++;
            }
        }
        if (countLeft!= countRight){
            return false;
        }

        //ALGORITHM: check the open and closed status  of the sequence
        //you can't start with a ')' when the previous sequence is all closed
        //var int count how many closed
        //var int count how many open
        //var boolean totalsequenceclosed (true or false)
        //if countClosed and countOpen are equal then return true overall

        int countHowManyClosed=0;
        int countHowManyOpen=0;
        boolean totalSequenceClosed=true;

        for (int i=0; i<length;i++){
            if (totalSequenceClosed && splitExpression[i]==')'){
                return false;
            }
            if (splitExpression[i]=='('){
                countHowManyOpen++;
            } else if (splitExpression[i]==')'){
                countHowManyClosed++;
            }
            if (countHowManyClosed!=countHowManyOpen){
                totalSequenceClosed=false;
            } else if (countHowManyClosed==countHowManyOpen){
                totalSequenceClosed=true;
            }
        }
        if (countHowManyClosed==countHowManyOpen){
            return true;
        } else{
            return false;
        }
        //another method: erase pairs as you go and check if it starts validly( starting iwth ( and ending with ) ) and contuinign
        //anotherr method: count 0 and 1 to the number of needed matches to pair eveyrthing up. if it ends in a 0 and not negative then return true
        //use a stack if you actually want ot find the parentheses indices

        //
    }
}