package src;

import java.util.Scanner;

public class ScanThread extends Thread // The new class for the thread used in the Chat class.
{
    private Chat owner;
    private String input;
    public Boolean scanning = true;

    private Scanner scan = new Scanner(System.in);

    public ScanThread(Chat owner) // The Class' constructor. // Check for updates on the class diagram for further instructions.
    {
        this.owner = owner;
    }

    public void run() //
    {
        while (scanning)
        {
            input = "";
            input = scan.nextLine();
            if (input != "")
            {
                owner.message(input);
            }
        }
    }

    public void setScanning (boolean scanning)
    {
        this.scanning = scanning;
    }
}
