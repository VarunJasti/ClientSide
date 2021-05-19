package clientside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientSide {
    
    private final static String HOST = "40.112.182.24";
    private final static int PORT = 4444;
    private static Socket server;
    private static BufferedReader in;
    private static PrintWriter out;
    private static final jHome HOME = new jHome();

    public static void main(String[] args) {
        HOME.setVisible(true);
        HOME.showPanel(0);
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
    
    public static String read() {
        try {
            return in.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static jHome getHome() {
        return HOME;
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
        out.println("user,"+user);
        try {
            return in.readLine().equals("connected");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
}
