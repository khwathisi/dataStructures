import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static Scanner scan = new Scanner(System.in);
    public static dataStructures data = new dataStructures();
    public static void main(String[] args)
    {
        //user's project preference
        System.out.println("Conway's Game of Life");
        System.out.println("please enter 1 to run with default generation\n or " +
                "enter 2 to run with custom generation");
        String choice = scan.nextLine();
        if(choice.equals("1"))
        {
            data.Default();
        }else if(choice.equals("2"))
        {
            //Taking the user input
            System.out.println("Conway's Game of Life");
            int runTimes = 10;
            String Lines = "";

            for(int i = 0; i < runTimes; i++)
            {
                int seq = i + 1;
                System.out.println("Enter " + seq);
                while(scan.hasNext(Pattern.compile("\\*|\\."))) {
                    System.out.println("* For alive and . for dead");
                    System.out.println("Try again for " + seq);
                    scan.next();
                }
                Lines += scan.nextLine();
            }

            data.Custom(Lines);
        }else
        {
            System.out.println("Invalid");
        }
    }
}
