package src;

import sun.security.krb5.internal.HostAddress;

import javax.net.ServerSocketFactory;
import javax.net.ssl.HostnameVerifier;

public class MEDSN_Client implements Constants {

    public Chat chat;
    public  Server_Manager serverMgr;
    private static short state;
    private static String Username;
    private static String hostAddress;


    public void main(String[] args) {            //MAIN FUNCTION HERE <----|

        chat = new Chat(this);
        serverMgr = new Server_Manager(this);
        state = STATE_CLIENT_OFFLINE;


        while (state != STATE_NULL) {


            switch (state) {
                case (STATE_CLIENT_OFFLINE): {
                    //Input to connect IP address and username
                    //connect();


                    setState(STATE_CLIENT_CONNECTING);
                    break;
                }
                case (STATE_CLIENT_CONNECTING): {

                    if (state == NET_SERVER_JOIN_ACCEPT) { // <-- I'm not sure the right constant is used here?
                        setState(STATE_CLIENT_ONLINE);
                    }
                    break;
                }
                case (STATE_CLIENT_ONLINE): {
                    //Something something
                    //setState(STATE_CLIENT_DISCONNECTING);
                    break;

                }
                case (STATE_CLIENT_DISCONNECTING): {

                    setState(STATE_CLIENT_OFFLINE);
                    //something
                    break;

                }
            }

        }
    }

    public short getState() {
        return state;
    }    //Gets state

    public static void setState(short newState) {
        state = newState;
    }   //Changes state

    public String getUsername() {
        return Username;
    }

    public void setUsername(String newUsername) {
        this.Username = newUsername;
    }

    public String getHostAddress(){
        return hostAddress;
    }

    public void setHostAddress (String newHostAddress) {
        this.hostAddress = newHostAddress;
    }
    public void handleChatString(String chat) { //This Method needs something within it.
        if(chat.startsWith("/")) {
            String[] param = chat.split("\\s+");


        } else {
            System.out.println("You cannot send a message being offline. Please type /connect to enter the chat module");
        }


    }

}
