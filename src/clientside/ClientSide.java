package clientside;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientSide {

    public static void main(String[] args) {
        if (args.length < 2) {
            return;
        }
        String host = args[0];
        int port = Integer.parseInt(args[1]);
        try {
            Socket server = new Socket(host, port);
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
            PrintWriter out = new PrintWriter(server.getOutputStream(), true);
            Scanner sc = new Scanner(System.in);
            System.out.print("Send Message >>>  ");
            String message = sc.nextLine();
            out.println(message);
            System.out.println(in.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
