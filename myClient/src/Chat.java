package src;

import java.util.Scanner;

public class Chat implements Constants
{
    private MEDSN_Client owner;
    public Thread scanThread;

    public Chat (MEDSN_Client owner) // The Chat class' constructor.
    {
        // Check for updates on the class diagram for further instructions.
        this.owner = owner;
    }

    public Void message (String msg) // Check for updates on the class diagram for further instructions.
    {
        owner.handleChatString(msg);
    }

    public void writeChat (String msg) // Check for updates on the class diagram for further instructions.
    {
        System.out.println(msg);
    }
}