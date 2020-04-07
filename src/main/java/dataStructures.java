import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class dataStructures {
    public static Scanner scan = new Scanner(System.in);
    public static StringBuilder stringBuilder = new StringBuilder();
    public static List<String> arrayLines = new ArrayList<String>();
    public static int vertical = 10;
    public static int horizontal = 10;

    public static String Custom(String Lines)
    {
         int[][] customGrid = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

         try
         {

         }catch(Exception e){
             System.out.println("");
         }



        //Setting up Custom Grid
        try
        {
            for(int x = 0; x < Lines.length(); x++)
            {
                arrayLines.add(Character.toString(Lines.charAt(x)));
            }

            for(int y = 0; y < arrayLines.size(); y++)
            {
                int horizontalShift = 0;
                int verticalShift = 0;
                try
                {
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
                        System.out.println("ERROR: Custom Grid: invalid horizontal shift");
                    }
                }catch(Exception e){
                    System.out.println("Custom Grid: Couldn't deal with the horizontal shift");
                }

                try
                {
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
                        System.out.println("ERROR: Custom Grid: invalid vertical shift");
                    }
                }catch(Exception e){
                    System.out.println("Custom Grid: Couldn't deal with the vertical shift");
                }

                try
                {
                    //Alive
                    if(arrayLines.get(y).equals("*"))
                    {
                        customGrid[verticalShift][horizontalShift] = 1;
                    }//Dead
                    else if(arrayLines.get(y).equals("."))
                    {
                        customGrid[verticalShift][horizontalShift] = 0;
                    }
                }catch(Exception e){
                    System.out.println("");
                }

            }
        }catch(Exception e){
            System.out.println("Setting up Custom Grid Failed");
        }

        try
        {
            // Displaying the Custom Generation
            System.out.println("Your Generation");
            for (int i = 0; i < vertical; i++)
            {
                for (int j = 0; j < horizontal; j++)
                {
                    if (customGrid[i][j] == 0)
                        System.out.print(".");
                    else
                        System.out.print("*");
                }
                System.out.println();
            }
            System.out.println();
        }catch(Exception e){
            System.out.println("Displaying the Custom Grid Failed");
        }

        nextGen(customGrid, vertical, horizontal);


        return "";
    }

    //default Generation
    public static void Default()
    {
        int[][] defaultGrid = {
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 1, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
        };

        try
        {
            //Displaying the Default Generation
            System.out.println("Default Generation");
            for (int i = 0; i < vertical; i++)
            {
                for (int j = 0; j < horizontal; j++)
                {
                    if (defaultGrid[i][j] == 0)
                        System.out.print(".");
                    else
                        System.out.print("*");
                }
                System.out.println();
            }
            System.out.println();
        }catch(Exception e){
            System.out.println("Displaying the Default Generation Failed");
        }

        nextGen(defaultGrid, vertical, horizontal);
    }

    //Killing and Resurrecting for the Next Generation
    public static void nextGen(int[][] grid, int vertical, int horizontal)
    {
        int[][] next = new int[vertical][horizontal];

        for (int q = 1; q < vertical - 1; q++)
        {
            for (int x = 1; x < horizontal - 1; x++)
            {
                int aliveNeighbours = 0;
                //Looking for living neighbors
                try
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        for (int y = -1; y <= 1; y++)
                        {
                            aliveNeighbours += grid[q + z][x + y];
                        }
                    }
                    aliveNeighbours -= grid[q][x];
                }catch(Exception e){
                    System.out.println("Looking for living neighbors failed");
                }

                //Killing and Resurrecting
                try
                {
                    //Under Population
                    if((grid[q][x] == 1) && (aliveNeighbours < 2)){next[q][x] = 0;}
                    //Overpopulation
                    else if((grid[q][x] == 1) && (aliveNeighbours > 3)){next[q][x] = 0;}
                    //Reproduction
                    else if((grid[q][x] == 0) && (aliveNeighbours == 3)){next[q][x] = 1;}
                    //Nothing changes
                    else{next[q][x] = grid[q][x];}
                }catch(Exception e){
                    System.out.println("Killing and\\\\or Resurrecting Failed");
                }

            }
        }

        //Displaying the Next Generation
        try
        {
            System.out.println("Next Generation");
            for(int b = 0; b < vertical; b++)
            {
                for(int w = 0; w < horizontal; w++)
                {
                    if(next[b][w] == 0)
                    {
                        System.out.print(".");
                    }
                    else
                    {
                        System.out.print("*");
                    }
                }
                System.out.println();
            }
        }catch(Exception e){
            System.out.println("Displaying the Next Generation Failed");
        }

    }
}
