import java.util.*;

//2/3/25

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers =List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        //System.out.println(numbers);

       // printEach(0, numbers);

        System.out.println(fibonacci(8));

        System.out.println(sum(0, numbers));

        System.out.println(factorial(5));

    }
    static void printEach(int index, List<Integer> nums){
//        for (Integer num : nums) { //for each loop
//            System.out.println(num);
//        }

        //Recursive version
//        if (index<nums.size()) { //important- is to plus 1 bc the index+1 is the parameter
//             System.out.println(nums.get(index));
//            printEach(index+1, nums);
//        }

        //Reverse printEach
        if (index<nums.size()) { //important- is to plus 1 bc the index+1 is the parameter
            printEach(index+1, nums); //this simple subtle concept relies on going through the list with this printEach call and then printing on the way down
            System.out.println(nums.get(index));
        }
    }

    static int sum(int index, List<Integer> nums) {
        int sum=0;
        if(index<nums.size()){ //ig we don't need a base case here
            sum+=nums.get(index)+sum(index+1, nums); // sum(index+1, nums) returns the var sum which is the sum from index 0 of nums to index index+1
        }
        return sum;
    }

    // https://en.wikipedia.org/wiki/Factorial
    static int factorial(int n) {
        int product=1;
        if (n==0){
            return 1;
        } else if (n==1){
            return 1;
        } else{
            product*=n*factorial(n-1); //NOW I REALIZE A CERTAIN PATTERN IN RECURSION: UNIVERSAL VAR, IF/ELSEIF FOR 1-2 BASE CASES, ELSE FOR UNIVERSAL VAR +=/*= THE CURRENT (N) AND RECURSION CALL
        }
        return product;
    }

    // https://en.wikipedia.org/wiki/Fibonacci_sequence
    static int fibonacci(int n) {
        int sum=0;
        if (n==0) {
            return 0;
        } else if (n==1) {
            return 1;
        } else{
            sum+= fibonacci(n-1) +fibonacci(n-2);
        }
        return sum;
    }
}
