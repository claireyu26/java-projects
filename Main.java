import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        //11/4/24
        //CS 3
        //CS 3 GitHub README - Dynamic Programming - Lattice Paths Puzzle
        //Starting in the top left corner of a 2 x 2 grid, and only being able to move to the right and down, there are exactly 6 routes to the bottom right corner.
        //lattice image
        //How many such routes are there through a 20 x 20 grid?
        //What if we block off some of the nodes (connecting points) in the grid. How would we calculate the number of paths from the top left corner to the bottom right given some set of blocked nodes?

        //at the top left, we can 1) move right 2) move down

        boolean atHorizEdge=true;
        boolean atVertEdge=true;

        String currentCoord;

        int totalRoutes=0;
        ArrayList<String> coordinates = new ArrayList<>();

        for (int i=1; i<21;i++){
            for (int j=1; j<21;j++){
                String newCoord=Integer.toString(i)+ " " +Integer.toString(j);
                coordinates.add(newCoord);
            }
        }
        System.out.println(coordinates);

        //answer is 40 choose 20
        //bc we need to go 20 right and 20 down
    }
}