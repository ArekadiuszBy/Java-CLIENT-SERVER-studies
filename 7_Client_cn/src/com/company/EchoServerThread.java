package com.company;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class EchoServerThread implements Runnable {

    protected Socket socket;
    public EchoServerThread(Socket clientSocket){
        this.socket = clientSocket;
    }

    public void run(){

        BufferedReader br = null;
        DataOutputStream dataOut = null;
        String threadName = Thread.currentThread().getName();

        //strumienie
        try{
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            dataOut = new DataOutputStream(socket.getOutputStream());
        }
        catch (IOException e) {
            System.out.println(threadName + " Błąd przy tworzeniu strumieni $e");
            return;
        }
        String line = null;

        while(true){
            try{
                line = br.readLine();
                System.out.println(threadName + "| Odczytano linię:" + line);

                if((line==null) || "quit".equals(line)){
                    System.out.println(threadName + " Zakończenie pracy z klientem " + socket);

                    socket.close();
                    return;
                }
                else {
                    //odesłanie danych do klienta
                    dataOut.writeBytes(line + "\n\r");
                    System.out.println(threadName + " | Wysłano linię: " + line);

                }
            }
            catch (IOException e) {
                System.out.println(threadName + " | Błąd wejścia-wyjścia: " + e);
            }
        }
    }
}
