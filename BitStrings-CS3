import java.util.*;

class Main {
    public static void main(String[] args) {
        // bitStrings(4) should produce the following:
        //
        // 0000
        // 0001
        // 0010
        // 0011
        // 0100
        // 0101
        // 0110
        // 0111
        // 1000
        // 1001
        // 1010
        // 1011
        // 1100
        // 1101
        // 1110
        // 1111

        for (var bitStr : bitStrings(4)) {
            System.out.println(bitStr);
        }
//        for (var bitStr : bitStringsNonRecursion(4)) {
//            System.out.println(bitStr);
//        }
    }

    // Implement the method bitStrings below, which returns a list
    // containing each possible binary string of length len.
    //
    // A binary string is a string that contains a sequence of bits
    // (binary digits), which are each either 0 or 1.
    //
    // There are 2^n possible binary strings of length n.
    //
    // You should use recursion to implement bitStrings.
    //
    // Things to consider:
    //
    // - How can we generate a list of binary strings of length n given
    //   a list of binary strings of length n-1?
    //
    // - What value of len should trigger the base case for bitStrings?
    //
    // - What should bitStrings return in the base case?
    //
    // If you get bitStrings working, you can challenge yourself by trying
    // to implement the bitStrings method *without* using recursion. Which
    // solution do you find simpler, recursive or non-recursive?

    static List<String> bitStrings(int len) {
        //len is the number of total 0s and 1s
        // _ _ _ _ => _2 _2 _2 _2 ==2^4=16
        //
        // _ _ _ => _2 _2 _2 == 2^3=8
        //0, 1
        //00, 11, 01, 10
        //000, 111, 100, 010, 001, 011, 101, 110
        //0000, 1111, 1000, 0100, 0010, 0001, 0011, 0101, 1010, 1100, 1001, 0110, 0111, 1011, 1101, 1110
        //
         //recursion = start with 2^n then go down to base case and then build it back up
        List<String> allPermutations = new ArrayList<>();
        if (len == 1) {
            return List.of("0", "1");
        } else{
            List<String> newCall = bitStrings(len-1); // go smaller and smaller until len ==1 then go back and built up again

            for (int i=0; i<bitStrings(len-1).size(); i++){
                allPermutations.add(newCall.get(i));
            }
            //base case good then go up to add a 0 and 1 for each 0 and 1 (the previous list). then this goes into the new call to continue adding 0 and 1.
        }
        return allPermutations;
    }

//    static List<String> bitStringsNonRecursion(int len){
//        int currentNum=0;
//        for (int i=0; i<4; i++){
//            // _ _ _ _
//            currentNum=1000*2+
//                    currentNum=1000*1+
//        }
//    }
}
