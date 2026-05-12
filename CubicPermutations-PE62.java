import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        //2/6/25
        //Weekly programming problem
        //Project Euler #62 Cubic Permutations

        //The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104
        //(384^3) and 66430125 (405^3).
        //In fact, 41063625 is the smallest cube which has exactly three permutations
        //of its digits which are also cube.
        //Find the smallest cube for which exactly 5 permutations of its digits are cube.

        System.out.println(cubicPermutations());

    }
    static int cubicPermutations(){
        int num;
        int permuCount=0;
        ArrayList<Integer> allNums=new ArrayList<>();
        for (int i=41063625; i<Integer.MAX_VALUE; i++){
            ArrayList<Integer> digitPermu = new ArrayList<>();
            digitPermu=permute(String.valueOf(i), "");
           // System.out.println(digitPermu);
            for (int j=0; j<digitPermu.size();j++){
                for (int k=1; k<j;k++){
                    if (k*k*k==j){
                        permuCount++;
                    }
                }
                if (permuCount==5){
                    allNums.add(i);
                    System.out.println(i);
                }
            }

        }
        num=allNums.get(0);
        return num;
    }

    static ArrayList<Integer> permutations(int x){
        ArrayList<Integer> nums=new ArrayList<>();
        return nums;

    }

    static ArrayList<Integer> permute(String s, String answer) {
        ArrayList<Integer> result = new ArrayList<>();

        // Base case: if the string is empty, we have a permutation
        if (s.length() == 0) {
            // Convert the permutation (String) to an integer and add it to the result list
            result.add(Integer.parseInt(answer));
            return result;
        }

        // Recursive case: Generate permutations by picking each character
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;

            // Recursively get the permutations of the remaining string
            ArrayList<Integer> tempResult = permute(rest, answer + ch);

            // Add the resulting permutations to the final result
            result.addAll(tempResult);
        }

        return result;
    }
}
