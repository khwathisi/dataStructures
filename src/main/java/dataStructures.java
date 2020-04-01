import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class dataStructures {
    public static Scanner scan = new Scanner(System.in);
    public static StringBuilder stringBuilder = new StringBuilder();
    public static List<String> arrayLines = new ArrayList<String>();

    public static String Conway()
    {
        int M = 10, N = 10;
        // Initializing the grid.
        int[][] grid = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        //Taking the user input
        System.out.println("Conway's Game of Life");
        int runTimes = 10;
        String Lines = "";
        //scan.nextLine(); // Discard line terminator

        for(int i = 0; i < runTimes; i++)
        {
            int seq = i + 1;
            System.out.println("Enter " + seq);
            //System.out.println("Even and odd numbers, please enter a number");
            while(scan.hasNext(Pattern.compile("\\*|\\."))) {
                System.out.println("* For alive and . for dead");
                System.out.println("Try again for " + seq);
                scan.next();
            }
            Lines += scan.nextLine();
        }

        for(int x = 0; x < Lines.length(); x++)
        {
            arrayLines.add(Character.toString(Lines.charAt(x)));
        }

        for(int y = 0; y < arrayLines.size(); y++)
        {
            int horizontalShift = 0;
            int verticalShift = 0;
            if(y <= 10) {verticalShift = 0;}
            else if(y >10 && y <=20) {verticalShift = 1;}
            else if(y >20 && y <=30) {verticalShift = 2;}
            else if(y >30 && y <=40) {verticalShift = 3;}
            else if(y >40 && y <=50) {verticalShift = 4;}
            else if(y >50 && y <=60) {verticalShift = 5;}
            else if(y >60 && y <=70) {verticalShift = 6;}
            else if(y >70 && y <=80) {verticalShift = 7;}
            else if(y >80 && y <=90) {verticalShift = 8;}
            else if(y >90 && y <=100) {verticalShift = 9;}
            else{
                System.out.println("ERROR: couldn't deal with the horizontal shift");
            }

            if(y <= 10) {horizontalShift = y;}
            else if(y >10 && y <=20) {horizontalShift = y-10;}
            else if(y >20 && y <=30) {horizontalShift = y-20;}
            else if(y >30 && y <=40) {horizontalShift = y-30;}
            else if(y >40 && y <=50) {horizontalShift = y-40;}
            else if(y >50 && y <=60) {horizontalShift = y-50;}
            else if(y >60 && y <=70) {horizontalShift = y-60;}
            else if(y >70 && y <=80) {horizontalShift = y-70;}
            else if(y >80 && y <=90) {horizontalShift = y-80;}
            else if(y >90 && y <=100) {horizontalShift = y-90;}
            else{
                System.out.println("ERROR: couldn't deal with the vertical shift");
            }

            //Alive
            if(arrayLines.get(y) == "*")
            {
                grid[verticalShift][horizontalShift] = 1;
            }//Dead
            else if(arrayLines.get(y) == ".")
            {
                grid[verticalShift][horizontalShift] = 0;
            }//Can't tell, must be a zombie
            /*else if(arrayLines.get(y) != "." || arrayLines.get(y) != "*" ){
                System.out.println("ERROR: a zombie detected");
            }*/
        }

        // Displaying the grid
        System.out.println("Original Generation");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (grid[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
        nextGeneration(grid, M, N);


        return "";
    }

    // Function to print next generation
    static void nextGeneration(int grid[][], int M, int N)
    {
        int[][] future = new int[M][N];

        // Loop through every cell
        for (int l = 1; l < M - 1; l++)
        {
            for (int m = 1; m < N - 1; m++)
            {
                // finding no Of Neighbours that are alive
                int aliveNeighbours = 0;
                for (int i = -1; i <= 1; i++)
                    for (int j = -1; j <= 1; j++)
                        aliveNeighbours += grid[l + i][m + j];

                // The cell needs to be subtracted from
                // its neighbours as it was counted before
                aliveNeighbours -= grid[l][m];

                // Implementing the Rules of Life

                // Cell is lonely and dies
                if ((grid[l][m] == 1) && (aliveNeighbours < 2))
                    future[l][m] = 0;

                    // Cell dies due to over population
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3))
                    future[l][m] = 0;

                    // A new cell is born
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3))
                    future[l][m] = 1;

                    // Remains the same
                else
                    future[l][m] = grid[l][m];
            }
        }

        System.out.println("Next Generation");
        for (int i = 0; i < M; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (future[i][j] == 0)
                    System.out.print(".");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
