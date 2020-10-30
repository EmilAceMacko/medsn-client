package src;

import java.util.Scanner;

public class Chat implements Constants
{
    private MEDSN_Client owner;
    public Thread scanThread;

    public Chat (MEDSN_Client owner) // The Chat's constructor.
    {
        scanThread = new Thread() // The inner class for scanThread. Will be moved to the new class for the thread.
        {
            private Chat owner;
            private String input;
            public Boolean scanning;

            private Scanner scan = new Scanner(System.in);


            public ScanThread(Chat owner) // Can't be done like this must make a class for thread in order for it to work.
            {
                //
            }

            public void run()
            {
                while (scanning == true)
                {
                    // Check class diagram for further information
                }
            }

            public void writeChat(String msg)
            {

            }
        };
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