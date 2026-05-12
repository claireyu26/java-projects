import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(3, 1, 4, 1, 5, 9, 2, 6, 5, 4));
        List<Integer> numbers2 = new ArrayList<>(List.of(1, 4, 3, -2));
        System.out.println(numbers);
        System.out.println("numbers2 boolean: "+ isSorted(numbers2));
        System.out.println("numbers1 boolean isSorted: " +isSorted(numbers));

        sort(numbers);

        System.out.println("AFTER sorted numbers1 " +numbers);
        System.out.println("AFTER numbers1 boolean isSorted: " + isSorted(numbers));
    }

    static boolean isSorted(List<Integer> numbers) { //DONE
        // Check whether or not a list is sorted (from low to high)
        for (int i=0; i<numbers.size()-1; i++){
            if (numbers.get(i)>numbers.get(i+1)){
                return false; // to prove that it is true, we can prove that it is not false.
            }
        }
        return true;
    }

    static void sort(List<Integer> numbers) {
        // Sort numbers in place using the selection sort algorithm
        // https://en.wikipedia.org/wiki/Selection_sort

        int temp=numbers.get(0);
//                for (int i=0; i<numbers.size()-1;i++){
//                    int min=numbers.get(i);
//                    int minIndex=0;
//                    for (int j=i+1; j<numbers.size(); j++) {
//                        //find the minimum and swap outside this for loop
//                        if (numbers.get(j) < min) {
//                            //1) UPDATE THE MIN
//                            min=numbers.get(j);
//                            minIndex=j;
//                        } //2) SWAP
//                        //numbers.set(temp, j);
//                        temp = numbers.get(i);
//                        numbers.set(i, numbers.get(minIndex));
//                        numbers.set(minIndex, temp);
//                    }
//                }
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
        System.out.println("Selection sorted list " + numbers);
    }

}
