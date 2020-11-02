package src;

import sun.security.krb5.internal.HostAddress;

import javax.net.ServerSocketFactory;
import javax.net.ssl.HostnameVerifier;

public class MEDSN_Client implements Constants {

    public static Chat chat;
    public static Server_Manager serverMgr;
    private static short state;
    private static String username;
    private static String hostAddress;

    public static void main(String[] args) {            //MAIN FUNCTION HERE <----|

        chat = new Chat();
        serverMgr = new Server_Manager();
        state = STATE_CLIENT_OFFLINE;

        while (state != STATE_NULL) {


            switch (state) {
                case (STATE_CLIENT_OFFLINE): {
                    //Input to connect IP address and username
                    //connect();


                    //setState(STATE_CLIENT_CONNECTING);
                    break;
                }
                case (STATE_CLIENT_CONNECTING):
                case (STATE_CLIENT_ONLINE): {
                    serverMgr.receiveMessage();
                    break;
                }
                case (STATE_CLIENT_DISCONNECTING): {
                    // Go offline:
                    setState(STATE_CLIENT_OFFLINE);
                    break;
                }
            }

        }

        chat.stopScanner();
    }

    public static short getState() {
        return state;
    }    //Gets state

    public static void setState(short newState) {
        state = newState;
    }   //Changes state

    public String getUsername() {
        return username;
    }

    public void setUsername(String newUsername) {
        username = newUsername;
    }

    public String getHostAddress(){
        return hostAddress;
    }

    public void setHostAddress (String newHostAddress) {
        hostAddress = newHostAddress;
    }
    // Handles chat strings from the user (via the chat scanner).
    public static void handleChatString(String chatStr) {

        boolean sendToServer = true;

        if(chatStr.startsWith("/")) {
            String[] param = chatStr.split("\\s+");

            switch(param[0]) {
                case("/help"): {
                    sendToServer = false;
                    chat.writeChat("Here's all the commands:\n" +
                            "/help - Display this list of commands.\n" +
                            "/quit or /exit - Quits the program.\n" +
                            "/connect <ip> <username> <adminpass> - Connect to a server with a username (and an optional admin password)\n" +
                            "/disconnect - Disconnect from a server (when connected).");
                    break;
                }
                case("/quit"):
                case("/exit"): {
                    sendToServer = false;
                    setState(STATE_NULL);
                    break;
                }
                case("/connect"): {
                    sendToServer = false;
                    if(state == STATE_CLIENT_OFFLINE)
                    {
                        // If the user gave enough parameters:
                        if(param.length >= 3)
                        {
                            hostAddress = param[1];
                            username = param[2];
                            String adminPass = "";
                            if(param.length >= 4) adminPass = param[3];

                            serverMgr.connect(hostAddress, username, adminPass);
                            setState(STATE_CLIENT_CONNECTING);
                        }
                        else chat.writeChat("You did not give enough parameters. /connect <ip> <username> (opt)<password>");
                    }
                    else chat.writeChat("You can't connect when already connected/connecting.");
                    break;
                }
                case("/disconnect"): {
                    sendToServer = false;

                    // Send message to the server that we've disconnected, and then set our state to offline:
                    serverMgr.disconnect(true);
                    break;
                }
            }

        }

        // At this point, if sendToServer is true and we are online, then we send the command or message to the server:
        if(sendToServer && state == STATE_CLIENT_ONLINE)
        {
            serverMgr.sendMessage(chatStr);
        }

    }

}
