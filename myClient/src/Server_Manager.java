package src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;

public class Server_Manager {
    private MEDSN_Client owner;
    private int port = 8000;
    private DataInputStream in;
    private DataOutputStream out;
    private Socket ServerSocket;
}