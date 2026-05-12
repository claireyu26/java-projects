import java.util.*;

public class Main {
    public static void main(String[] args) {
        long[][] grid = new long[21][21];
        grid[0][0]=1;
        for (int r = 0; r<=20; r++){
            for (int c = 0; c<=20; c++){
                if (r>0){
                    grid[r][c] += grid[r-1][c];
                }
                if (c>0){
                    grid[r][c] += grid [r] [c-1];
                }
            }
        }
        System.out.println(grid[20][20]);

    }
}