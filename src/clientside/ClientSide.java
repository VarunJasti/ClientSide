package clientside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientSide {
    
    private final static String HOST = "104.209.44.90";
    private final static int PORT = 4444;
    private static Socket server;
    private static BufferedReader in;
    private static PrintWriter out;
    public static jHome home = new jHome();

    public static void main(String[] args) {
        if (!getCon()) {
            return;
        }
        home.setVisible(true);
        home.showPanel(1);
//        try {
//            Socket server = new Socket(HOST, PORT);
//            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
//            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
//            Scanner sc = new Scanner(System.in);
//            System.out.print("Send Message >>>  ");
//            String message = sc.nextLine();
//            out.println(message);
//            System.out.println(in.readLine());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
    }
    
    public static boolean getCon()
    {
        try {
            server = new Socket(HOST, PORT);
            in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            out = new PrintWriter(server.getOutputStream(), true);
            return true;
        } catch (IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    
    public static boolean newUser(String user) {
        out.write("user," + user);
        try {
            return in.readLine().equals("connected");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
}
