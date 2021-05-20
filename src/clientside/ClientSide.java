package clientside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientSide {
    
    private final static String HOST = "localhost";
    private final static int PORT = 4444;
    private static Socket server;
    private static BufferedReader in;
    private static PrintWriter out;
    private static final jHome HOME = new jHome();
    private static ArrayList<User> list = new ArrayList<>();

    public static void main(String[] args) {
        HOME.setVisible(true);
        HOME.showPanel(0);
    }
    
    public static void loadUsers()
    {
        list.clear();
        String rosterList = ClientSide.read();
        String[] roster = rosterList.split(",");
        for (String user : roster) {
            list.add(new User(user));
        }
    }
    
    public static ArrayList<User> getList() {
        return list;
    }

    public static BufferedReader getIn() {
        return in;
    }

    public static PrintWriter getOut() {
        return out;
    }
    
    public static String read() {
        try {
            return in.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static void disconnect() {
        try {
            server.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void write(String s) {
        out.println(s);
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
