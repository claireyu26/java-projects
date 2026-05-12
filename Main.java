import java.util.*;

class Template {
    public static void main(String[] args) {
        //ReverseArray()
        int[] numArray = { 5, 6, 7, 8, 9};
        reverseArray(numArray);
        System.out.println(Arrays.toString(numArray)); //print out the reversed list
        //ReversedList()
        List<Integer> numList = List.of(1, 2, 3, 4, 5);
        System.out.println("Reversed LIST"+ reversedList(numList));
        //PrimeFactors
        System.out.println(primeFactors(12345678));

        System.out.println(calcDay("Sunday", 100));
    }

    static void reverseArray(int[] numbers) {
        // Write a method that reverses an Array
        int[] reversedNumbers = numbers.clone(); // instead of make copy into numbers but we should make a copy and turn it into numbers
        int length=numbers.length;

        for (int i=0; i <length;i++){
//            int temp=numbers[i];
            reversedNumbers[i]=numbers[length-i-1];
            //reversedNumbers.add(0, temp);
        }
        System.out.println("Reversed ARRAY: " + Arrays.toString(reversedNumbers));

        //METHOD 2: SWAPPING
//        int left=0;
//        int right=numbers.length-1;
//
//        while (left<right){
//            int temp=numbers[left];
//            numbers[left]=numbers[right];
//            numbers[right]=temp;
//            left++;
//            right--;
//        }
    }

    static List<Integer> reversedList(List<Integer> numbers) {
        // Write a method that that takes a List and returns
        // a new List with the values reversed
        List<Integer> reversedNumbers= new ArrayList<>(Collections.emptyList());
        reversedNumbers.addAll(numbers);
        int size=numbers.size();

        for (int i=0; i<size; i++){
            reversedNumbers.set(i, numbers.get(size-i-1));
        }
        return (reversedNumbers);
        //OR A SLIGHTLY DIFFERENT METHOD with counting backgrounds in a for loop
        //for(int i=numbers.size()-1; i>=0; i--){
        //   reversedNumbers.add(numbers.get(i));
        // }
    }

    static List<Integer> primeFactors(int n) {
        // Write a method that calculates the prime factorization
        // of a number and returns the factors as a List
        List<Integer> factors = new ArrayList<>();

//        for (int i=2; i<=n;i++){
//            if (n%i==0){
//                factors.add(i);
//            }
//        }
        //Wait the above is wrong bc it's not finding the PRIME factors
        int div=2;
        while (n>1){
            if (n%div==0) {
                factors.add(div);
                n/=div;
            } else{
                div++;
            }
        }
        return (factors);
    }

    static String calcDay(String startDay, int offset) {
        // Get a string `startDay` and a number `offset` as input,
        // print out what the day of the week it will be `offset`
        // days from `startDay`
        List<String> weekNames=new ArrayList<String>();
        weekNames.add("Monday");
        weekNames.add("Tuesday");
        weekNames.add("Wednesday");
        weekNames.add("Thursday");
        weekNames.add("Friday");
        weekNames.add("Saturday");
        weekNames.add("Sunday");
        //OR List<String> days = List.of(
        // "Monday",
        // "Tuesday",....
        // );

        //return weekNames.get(weekNames.indexOf(startDay)+(offset%7));

        //WAIT but what happens if the input is something like "Sunday" and "2" in which it will go out of bounds of the loop?
        //ohh
        return weekNames.get((weekNames.indexOf(startDay)+offset)%7);


    }
}
