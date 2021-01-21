package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DataServer {
    public static int sPort=777;            //port serwera
    public static int kPort=888;            //port klienta
    public static int bufferSize=1024;      //wielkość pliku buforu
    public static DatagramSocket gniazdo;
    public static byte buffer[] = new byte[bufferSize];


    public static void main(String[] args) throws Exception {
	gniazdo = new DatagramSocket(sPort);
	Serw();
    }

    public static void Serw() throws Exception{
        System.out.println("SERWER");
        System.out.println("Host: " + InetAddress.getLocalHost());
        System.out.println("WIADOMOSC");

        int pos = 0;
        while(true){
            int c = System.in.read();
            switch(c){
                case -1:
                    System.out.println("Serwer STOP");
                    return;
                case '\r':
                    break;
                case '\n':
                    gniazdo.send( new DatagramPacket(buffer, pos, InetAddress.getLocalHost(), kPort));
                    pos = 0;
                    break;
                default:
                    buffer[pos++] = (byte) c;
            }
        }
    }
}
