package com.company;

import java.net.*;
import java.io.*;
public class Server {
    public static void main(String args[]) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        BufferedReader brinp = null;
        DataOutputStream out = null;
        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println(
                    "Błąd przy tworzeniu gniazda serwerowego.");
            System.exit(-1);
        }
        while(true)
        {
        try {
            socket = serverSocket.accept();
        } catch (IOException e) {
            System.out.println(e);
            System.exit(-1);
        }
        try {
            brinp = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new DataOutputStream(socket.getOutputStream());
        }
        catch(IOException e){
            System.out.println("Błąd przy tworzeniu strumieni.");
            System.exit(-1);
        }
        while(true) {
            try {
                String line = brinp.readLine();
                if (line.equals("quit")) {
                    try {
                        socket.close();
                        serverSocket.close();
                    } catch (IOException e) {
                        System.out.println(
                                "Błąd przy zamykaniu gniazd.");
                    }
                    System.exit(0);
                }
                out.writeBytes(line + "\n\r");
            } catch (IOException e) {
                System.out.println("Błąd wejścia-wyjścia.");
                System.exit(-1);
            }
        }
        }
    }
}
