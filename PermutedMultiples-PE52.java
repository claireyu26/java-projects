import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //12/6/26
        //Project Euler #52
        //Permuted Multiples

        //It can be seen that the number, 125874, and its double, 251748, contain exactly the same digits, but in a different order.
        //Find the smallest positive integer x, such that 2x, 3x, 4x, 5x, and 6x contain the same digits.
        method1(); //brute force method of simply counting up by 1 and using selection sort to compare if they're equal
        method2(); //using the Permutations method

        }
    static Integer method1(){
        //brute force method of simply counting up by 1 and using selection sort to compare if they're equal

        long start = System.currentTimeMillis();

        boolean foundNum=false;
        int resultX=1;
        int i=1;
        while(!foundNum){
            ArrayList<Integer> arrayX=new ArrayList<>();
            ArrayList<Integer> arrayTwoX=new ArrayList<>();
            ArrayList<Integer> arrayThreeX=new ArrayList<>();
            ArrayList<Integer> arrayFourX=new ArrayList<>();
            ArrayList<Integer> arrayFiveX= new ArrayList<>();
            ArrayList<Integer> arraySixX=new ArrayList<>();

            int temp=i;
            while(temp>0){
                arrayX.add(temp%10);
                temp/=10;
            }
            temp=2*i;
            while(temp>0){
                arrayTwoX.add(temp%10);
                temp/=10;
            }
            temp=3*i;
            while(temp>0){
                arrayThreeX.add(temp%10);
                temp/=10;
            }
            temp=4*i;
            while(temp>0){
                arrayFourX.add(temp%10);
                temp/=10;
            }
            temp=5*i;
            while(temp>0){
                arrayFiveX.add(temp%10);
                temp/=10;
            }
            temp=6*i;
            while(temp>0){
                arraySixX.add(temp%10);
                temp/=10;
            }
            if (sameContentsOfArray(arrayX, arrayTwoX) && sameContentsOfArray(arrayX, arrayThreeX) && sameContentsOfArray(arrayX, arrayFourX) && sameContentsOfArray(arrayX, arrayFiveX) && sameContentsOfArray(arrayX, arraySixX)){
                resultX=i;
                foundNum=true;
            }
            i++;
            //System.out.println("i "+ i);
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("method 1 took: "+ timeElapsed+" milliseconds");
        System.out.println("resultX/ the smallest positive integer x, such that 2x, 3x, 4x, 5x, and 6x contain the same digits: "+ resultX);
        return resultX;
    }
    static void method2(){//using the permutations code that i found online
        //finds the permutations of incremented number i and sees if the 6 multiples of i are in the permutations.
        long start = System.currentTimeMillis();
        boolean foundNum=false;
        int resultX=1;
        int i=1;
        while(!foundNum){
            //System.out.println(permutation(String.valueOf(i)));
            if (permutation(String.valueOf(i)).contains(String.valueOf(i)) && permutation(String.valueOf(i)).contains(String.valueOf(i*2)) && permutation(String.valueOf(i)).contains(String.valueOf(i*3)) &&permutation(String.valueOf(i)).contains(String.valueOf(i*4))&&permutation(String.valueOf(i)).contains(String.valueOf(i*5))&&permutation(String.valueOf(i)).contains(String.valueOf(i*6))){
                resultX=i;
                foundNum=true;
            }
            i++;
            //System.out.println("i "+ i);
        }
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("method 2 took: "+ timeElapsed+" milliseconds");
        System.out.println("resultX/ the smallest positive integer x, such that 2x, 3x, 4x, 5x, and 6x contain the same digits: "+ resultX);
    }
    //sameContentsOfArray method is basically a selection sort and check
    static boolean sameContentsOfArray(ArrayList<Integer> a, ArrayList<Integer> b){
        if (a.size()!=b.size()){
            return false;
        } else {
            //ArrayList<Integer> countOfAValueOccurrencesInB = new ArrayList<>();//like bucket counting the values of b array to a array
            //for (int i = 0; i < b.size(); i++) {
            //}
            if ((selectionSort(a)).equals(selectionSort(b))){
                return true;
            } else{
                return false;
            }
        }
    }
    static ArrayList<Integer> selectionSort(List<Integer> numbers) {
        // Sort numbers in place using the selection sort algorithm
        // https://en.wikipedia.org/wiki/Selection_sort

        int temp=numbers.get(0);

        for (int i = 0; i < numbers.size() - 1; i++){
            int min = numbers.get(i);
            // --------------------
            // We need to make sure to initialize minIndex to i, not to 0; if we don't and
            // the number at index i is the next minimum then minIndex will stay 0 instead
            // of getting set to the correct index which will mess up the swap
            // --------------------
            int minIndex = i;

            for (int j = i + 1; j < numbers.size(); j++) {
                // find the minimum and swap outside this for loop
                if (numbers.get(j) < min) {
                    // 1) UPDATE THE MIN
                    min = numbers.get(j);
                    minIndex = j;
                }
            }
            // --------------------
            // We need to move the swap code out of the inner for loop; otherwise we end
            // up doing a swap for each element
            // --------------------
            // 2) SWAP
            temp = numbers.get(i);
            numbers.set(i, numbers.get(minIndex));
            numbers.set(minIndex, temp);
        }
        //System.out.println("Selection sorted list " + numbers);
        return (ArrayList<Integer>) numbers;
    }
    public static List<String> permutation(String str) {
        return permutation("", str);
    }

    // Private helper method that accumulates permutations in a list
    private static List<String> permutation(String prefix, String str) {
        List<String> result = new ArrayList<>();
        int n = str.length();

        if (n == 0) {
            result.add(prefix);  // Add the permutation to the list
        } else {
            for (int i = 0; i < n; i++) {
                result.addAll(permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n)));
            }
        }
        return result;
    }
}
