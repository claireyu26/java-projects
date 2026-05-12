import java.util.*;

// Given a "maze" string, where A is the start, B is the end, and █ is
// a wall, find a path from A to B and mark the path with ▒ characters.

//2/11/2025

class Maze {
    public static void main(String[] args) {
        var maze = """
    █████████████████████████████████
    █A█     █B█         █         █ █
    █ █ ███ █ █ ███ █████ █ █████ █ █
    █ █ █ █ █     █       █ █   █   █
    █ █ █ █ ███████████ ███ █ █ █████
    █   █ █     █     █ █ █   █     █
    █ ███ █████ █ ███ █ █ ███████ █ █
    █ █     █ █ █ █ █ █       █ █ █ █
    █ █ ███ █ █ █ █ █ █████████ ███ █
    █ █   █   █ █   █   █       █   █
    █ ███ ███ █ ███ ███ █ ███████ █ █
    █ █   █ █ █     █ █   █   █   █ █
    █ █ ███ █ ███████ █████ █ █ ███ █
    █ █   █ █       █   █   █ █ █ █ █
    █ ███ █ ███████ █ █ █ ███ █ █ █ █
    █     █           █   █     █   █
    █████████████████████████████████
    """;

        // Split the maze string into lines
        // (ignore blank lines at start and end)
        var lines = maze.trim().split("\n");

        // Make a 2D array of chars to represent maze
        var board = new char[lines.length][];
        var index = 0;

        for (var line : lines) {
            // Split each line into a char array and use to populate the board
            board[index++] = line.toCharArray();
        }

        // Assume we know that the start A character is always at row 1 column 1.
        // Run the search from this starting position.
        search1(board, 1, 1);
    }

    // The search method takes three parameters:
    //
    // - The board object
    // - The row and column of the current search location
    //
    // The search method returns true if we find a path to B
    // that goes through the point (r, c) and false otherwise.
    //
    // If a path is found then search updates board with a ▒ symbol
    // at point (r, c) and subsequent path locations.
    //
    // Additionally, it's ok for `search` to temporarily modify the
    // characters in `board`; just make sure it "cleans up" when it's
    // done. You should use these characters to determine how the
    // search should proceed.
    //
    // Make sure that search doesn't do extra work and keep searching
    // after a valid path is found.

    public static boolean search(char[][] board, int r, int c) {
        // Add 20ms delay to visualize search process in action
        try { Thread.sleep(20); } catch (InterruptedException err) {}

        // Clear the console
//        System.out.print("\033c");
        System.out.print("\033[H\033[2J");
        System.out.flush();


        // Print out the current board
        for (var row : board) {
            System.out.println(new String(row));
        }
        // Your code goes here !!-=
        boolean succeed=false;

        //check sq cell
        if (board[r][c]=='█'){//can't go into a wall
          return false;
        }
//        if (board[r][c]=='O'){ //
//            return false;
//        }
        if (board[r][c]=='x'){//to avoid going bakc to preivous xs
            return false;
        }

        if (board[r][c]=='B'){
            return true;
        }
        board[r][c]='x';
        succeed=search(board, r-1, c);
        if (succeed){//true
            return true;
        }
        succeed=search(board, r+1, c);
        if (succeed){//true
            return true;
        }
        succeed=search(board, r, c+1);
        if (succeed){//true
            return true;
        }
        succeed=search(board, r, c-1);
        if (succeed){//true
            return true;
        }
        board[r][c]=' ';//in order for backtracking=> WHY
        return succeed; // is going to return false

        //can wokr on showing backtrakcing

        /*
        if (board[r-1][c]==' '){ //or in other words, is  a null value/ is a space to walk
            //System.out.println(Arrays.deepToString(board));
            succeed=search(board, r-1, c);
            if (succeed){//true

            }
        }

        if (board[r+1][c]==' '){
            search(board, r+1, c);
        }

        if (board[r][c+1]==' '){
            search(board, r, c+1);
        }
        if (board[r][c-1]==' '){
            search(board, r, c-1);
        }
//        if (succeed==false){
//
//        }
*/

        //rn its getting stuck== if stuck, erase x and go back\
        //^  track if the previous search direction succeeded or not,
        //if else if issue, so change to all if

        //2/20/25
        //board[r][c]
        //one issue: you will go back up and return to the old previously-take path ===> so put a 'wall/blocker' to indicate we alr took this path of the maze

    }


    public static boolean search1(char[][] board, int r, int c) {
        // Add 20ms delay to visualize search process in action
        try { Thread.sleep(20); } catch (InterruptedException err) {}

        // Clear the console
//        System.out.print("\033c");
        System.out.print("\033[H\033[2J");
        System.out.flush();


        // Print out the current board
        for (var row : board) {
            System.out.println(new String(row));
        }
        // Your code goes here !!-=
        if (board[r][c]=='B'){
            return true;
        } else if (board[r][c]=='█' || board[r][c]=='x'){
            return false;
        }
        board[r][c]='x';
        boolean result =(search(board, r-1, c) || search(board, r, c+1) || search (board, r+1, c) || search (board, r, c-1));
        board[r][c]=' ';
        return result;

    }


}
