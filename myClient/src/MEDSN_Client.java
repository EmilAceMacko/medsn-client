package src;

import sun.security.krb5.internal.HostAddress;

import javax.net.ServerSocketFactory;
import javax.net.ssl.HostnameVerifier;

public class MEDSN_Client implements Constants {

    public Chat chat;
    public Server_Manager serverMgr;
    private static short state;
    private String Username;
    private String hostAddress;

    public static void main(String[] args) {            //MAIN FUNCTION HERE <----|

        switch(state) {
            case(STATE_CLIENT_OFFLINE): {
                //Input to connect IP address and username
                //connect();



                setState(STATE_CLIENT_CONNECTING);
                break;
            }
            case(STATE_CLIENT_CONNECTING): {

                short i = socket.readshort();//<-----Check socket bliver lavet af Rasmus

                if(i == NET_SERVER_JOIN_ACCEPT) { // <-- I'm not sure the right constant is used here?
                    setState(STATE_CLIENT_ONLINE);
                }
                break;
            }
            case(STATE_CLIENT_ONLINE): {
                //Something something
                //setState(STATE_CLIENT_DISCONNECTING);
                break;

            }
            case(STATE_CLIENT_DISCONNECTING): {

                //something
                break;


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

}
