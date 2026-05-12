import java.util.*;

public class Main {
    public static void main(String[] args) {
        //the number of ways to get to a certain point is by adding the number of ways to get to the point above and the point to the right
        //also math way: 40 choose 20
        //choosing 20 to go right/down bc the rest 20 will go down/right
        long[][] grid = new long[21][21];
        grid[0][0]=1; //initialize most left top to 1
        for (int r = 0; r<=20; r++){ //r=row //double for loop =cartesian product
            for (int c = 0; c<=20; c++){ //c=column
                if (r>0){// greater than 0 to check if we're on an edge to not go off the board
                    grid[r][c] += grid[r-1][c];
                }
                if (c>0){
                    grid[r][c] += grid [r] [c-1];
                }
            }
        }
        //System.out.println(Arrays.deepToString(grid));
        System.out.println(grid[20][20]);

    }
}
