import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        System.out.println(maxFunction(999, 998, -3));
    }
    public static int maxFunction(int a, int b, int c){
        ArrayList<Integer> nums = new ArrayList<Integer>(
                Arrays.asList(a, b, c));
//reorder into [greatest, 2nd greatest, smallest];
//        for (int i=0; i<2; i++){
//            if (nums.get(i)<nums.get(i+1)){
//                int temp=nums.get(i);
////                nums.get(i)=nums.get(i+1);
////                nums.get(i+1)=temp;
//                nums.set(i, nums.get(i+1));
//                nums.set(i+1, temp);
//                System.out.println(nums);
//            }
//        }
        int max, min;
        min=max=nums.get(0);
        for (int i=1; i<nums.size(); i++){
            min=Math.min(min, nums.get(i));
            max=Math.max(max, nums.get(i));
        }

        //now we have a new ordered nums
        return max;
    }
}