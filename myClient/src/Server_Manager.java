package src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;

public class Server_Manager {
    //private MEDSN_Client owner;
    private int port = 8000;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    // constructor
    public Server_Manager() {
        //this.owner = owner;
    }

    public void connect(String host, String name, String pass) {

        try {
            // attempts to connect to server with socket
            socket = new Socket(host, port);
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            out.writeShort(MEDSN_Client.NET_CLIENT_JOIN_REQUEST);

            // sends username and admin password to client manager
            byte[] array = name.getBytes();
            out.writeInt(array.length);
            out.write(array);
            array = pass.getBytes();
            out.writeInt(array.length);
            out.write(array);

        } catch (IOException e) {
            System.err.println("CLIENT ERROR: " + e + " - Could not set up socket on host " + host + " and port " + port);
            System.exit(-1); // closes the program
        }

    }

    public void disconnect(boolean messageServer) {
        try {
            if(messageServer) out.writeShort(MEDSN_Client.NET_CLIENT_QUIT);
            MEDSN_Client.setState(MEDSN_Client.STATE_CLIENT_DISCONNECTING);
            socket.close();
        }
        catch(IOException e) {
            System.err.println("Could not close socket.");
        }
    }

    public void sendMessage(String msg){
        try{
            // creates byte array from the given message and saves the length
            byte[] array = msg.getBytes();
            int length = array.length;

            // writes the identifier, length and array to client manager
            out.writeShort(MEDSN_Client.NET_CLIENT_CHAT);
            out.writeInt(length);
            out.write(array);
        } catch (IOException e) {
            System.err.println("CLIENT ERROR: " + e + " - Could not send message");

        }
    }

    public void receiveMessage(){
        try{
            // variables for identifier and connection state for client
           short clientState = MEDSN_Client.getState();
           short identifier = in.readShort();

           // checks if the client state is connecting
           if (clientState == MEDSN_Client.STATE_CLIENT_CONNECTING) {

               String deniedMsg = null;
                // checks if the server has accepted the connection
               if (identifier == MEDSN_Client.NET_SERVER_JOIN_ACCEPT){
                   MEDSN_Client.setState(MEDSN_Client.STATE_CLIENT_ONLINE);
               }
               // checks if the server has denied the connection
               else if (identifier == MEDSN_Client.NET_SERVER_JOIN_DENY_BANNED_IP){
                   deniedMsg = "Denied: Banned IP";
               }
               else if (identifier == MEDSN_Client.NET_SERVER_JOIN_DENY_BANNED_NAME){
                   deniedMsg = "Denied: Banned Name";
               }
               else if (identifier == MEDSN_Client.NET_SERVER_JOIN_DENY_DUPLICATE){
                   deniedMsg = "Denied: Already connected";
               }
               else if (identifier == MEDSN_Client.NET_SERVER_JOIN_DENY_NO_ROOM){
                   deniedMsg = "Denied: No Room";
               }
                // handles denied connection
               if (deniedMsg != null){
                   MEDSN_Client.setState(MEDSN_Client.STATE_CLIENT_OFFLINE);
                   MEDSN_Client.chat.writeChat(deniedMsg);
               }
           }
           // checks if client state is online
           else if (clientState == MEDSN_Client.STATE_CLIENT_ONLINE) {
               // check if message received
               if (identifier == MEDSN_Client.NET_SERVER_CHAT){
                   byte[] array = new byte[in.readInt()];
                   in.read(array);
                   String msg = Arrays.toString(array);
                   MEDSN_Client.chat.writeChat(msg);
               }
               // check if client should quit
               else if (identifier == MEDSN_Client.NET_SERVER_QUIT){
                   disconnect(false);
               }
           }
        } catch (IOException e) {
            System.err.println("CLIENT ERROR: " + e + " - Could not receive message");
        }
    }
}

