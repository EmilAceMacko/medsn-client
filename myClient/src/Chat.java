package src;

import java.util.Scanner;

public class Chat implements Constants
{
    private MEDSN_Client owner;
    public Thread scanThread;

    public Chat (MEDSN_Client owner) // The Chat's constructor.
    {
        // This was removed from the Chat class in the server, since both the client and server Chat classes are identical it has been commented out for now here as well.
        // Thread is now it's own class created by Valdemar

        /*scanThread = new Thread() // The inner class for scanThread
        {
            private Chat owner;
            private String input;
            public Boolean scanning; //

            private Scanner scan = new Scanner(System.in);


            public scanThread(Chat owner) // A bit of issues with this one. Return to look at the class diagram to fix it later.
            {

            }

            public void run()
            {

            }

            public void writeChat(String msg)
            {

            }
        }; */
    }

    public String checkInput()
    {
        return null; // Just for now, so it won't complain.
    }

    public void writeChat (String msg)
    {
        System.out.println(msg);
    }
}
