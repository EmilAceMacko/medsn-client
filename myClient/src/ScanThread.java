package src;

import java.util.Scanner;

public class ScanThread implements Constants
{
    // The new class for the thread used in the Chat class.

    private Chat owner;
    private String input;
    public Boolean scanning;

    public ScanThread(Chat owner) // The Class' constructor. // Check for updates on the class diagram for further information.
    {
        //
    }

    public void run() // Check for updates on the class diagram for further information.
    {
        while (scanning == true)
        {

            owner.message();
        }
    }
}
