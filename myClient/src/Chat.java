package src;

import java.util.Scanner;

public class Chat implements Constants
{
    private MEDSN_Client owner;
    public Thread scanThread;

    public Chat (MEDSN_Client owner) // The Chat's constructor.
    {
        // Check for updates on the class diagram for further information.
    }

    public String message(String msg) // Check for updates on the class diagram for further information.
    {
        return null;
    }

    public void writeChat (String msg) // Check for updates on the class diagram for further information.
    {
        System.out.println(msg);
    }
}