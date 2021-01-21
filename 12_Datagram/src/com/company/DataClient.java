package com.company;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class DataClient {
    public static int sPort = 777;            //port serwera
    public static int kPort = 888;            //port klienta
    public static int bufferSize = 1024;      //wielkość pliku buforu
    public static DatagramSocket gniazdo;
    public static byte buffer[] = new byte[bufferSize];


    public static void main(String[] args) throws Exception {
        gniazdo = new DatagramSocket(kPort);
        Klie();
    }

    public static void Klie() throws Exception{
        System.out.println("KLIENT");
        System.out.println("Host:" + InetAddress.getLocalHost());
        System.out.println("Wiadomosc");

        while(true){
            DatagramPacket p = new DatagramPacket(buffer, buffer.length);
            gniazdo.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        }
    }
}
