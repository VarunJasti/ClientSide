package clientside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {
    
    private final static String HOST = "104.209.44.90";
    private final static int PORT = 4444;
    public static jHome home = new jHome();

    public static void main(String[] args) {
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
    
}
