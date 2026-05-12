public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        //Coin Sums - Project Euler #31
        //10/19/24
        //one direction only, highest--> lowest
        //7 variables to make 200

        int count=1; //start with 1 because one 200coin is an option

        for (int hun=0; hun<3;hun++){ //follows the idea of the Cartesian Product
            for (int fifty=0;fifty<5;fifty++){
                for (int twenty=0;twenty<11;twenty++){
                    for (int ten=0;ten<21;ten++){
                        for(int five=0;five<41;five++){
                            for (int two=0;two<101;two++){
                                for (int one=0; one<201;one++){
                                    if (one+two*2+five*5+ten*10+twenty*20+fifty*50+hun*100==200) {
                                        count+=1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count+" possible combinations to create 200.");
        //MORE EFFICIENT SOLUTION (not as much brute force)
        //make 100p,
        //binary search
        //to make 200p, half it first to get to 2 100ps, half the 2 100ps to 4 50ps and keep going until we get to the 1p solution
        //everytime you half, count the possible ways to create that half
        //permute the number of halves (the # of combinations)

        //profiling it (optimizing effciency by timing it) or dynamic programming

        //Like fibonacci and tiles problem, we are using smaller solutions to build larger ones
        //Tiles problem, for a tile graph 2xn --> T(n) = T(n-1) + T(n-2)
        //Similarly, we want to build a function C(goal, max_coin) and vary the arguments each time from smaller values
        //C(100, 1, 2, 5);
        //C(200, 1, 2);
    }
    static int fasterSolution(){
        int count=1; //start with 1 bc one 200 coin is an option
        int goal=200;

        while (goal>)
        goal/=2;
    }
}
