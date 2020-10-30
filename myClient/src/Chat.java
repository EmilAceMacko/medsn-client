package src;

import java.util.Scanner;

public class Chat implements Constants
{
    private MEDSN_Client owner;
    public Thread scanThread;

    public Chat (MEDSN_Client owner) // The Chat's constructor.
    {
        //
    }

    public String message(String msg)
    {
        return null;
    }

    public void writeChat (String msg)
    {
        System.out.println(msg);
    }
}