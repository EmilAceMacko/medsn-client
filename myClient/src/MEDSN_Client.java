package src;

import sun.security.krb5.internal.HostAddress;

import javax.net.ServerSocketFactory;
import javax.net.ssl.HostnameVerifier;

public class MEDSN_Client implements Constants {
    public Chat chat;
    public Server_Manager serverMgr;
    private short state;
    private String Username;
    private String hostAddress;

    public static void main(String[] args) {            //MAIN FUNCTION HERE <----|



    }

    public short getState() {
        return state;
    }

    public void setState(short newState) {
        this.state = newState;
    }

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
