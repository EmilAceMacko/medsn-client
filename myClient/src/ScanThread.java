package src;

import java.util.Scanner;

public class ScanThread implements Constants
{
    // The new class for the thread used in the Chat class.

    private Chat owner;
    private String input;
    public Boolean scanning;

    private Scanner scan = new Scanner(System.in);

    public ScanThread(Chat owner) // The Class' constructor. // Check for updates on the class diagram for further information.
    {
        this.owner = owner;
    }

    public void run() //
    {
        while (scanning == true)
        {
            input = "";
            input = scan.nextLine();
            if (input != "")
            {
                owner.message(input);
            }
        }
    }
}
