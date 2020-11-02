package src;

import java.util.Scanner;

public class Chat implements Constants
{
    //private MEDSN_Client owner;
    public ScanThread scanThread;

    public Chat () // The Chat class' constructor.
    {
        // Check for updates on the class diagram for further instructions.

        //this.owner = owner;

        scanThread = new ScanThread(this);
        scanThread.start(); // Starts the scanner
    }

    public void stopScanner()
    {
        //scanThread.setScanning = false;
        scanThread.setScanning(false);
    }

    public void message (String msg) // Check for updates on the class diagram for further instructions.
    {
        MEDSN_Client.handleChatString(msg);
    }

    public void writeChat (String msg) // Check for updates on the class diagram for further instructions.
    {
        System.out.println(msg);
    }
}