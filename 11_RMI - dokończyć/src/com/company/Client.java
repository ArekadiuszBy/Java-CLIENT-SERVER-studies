package com.company;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client
{
    public static void main( String args[]) throws RemoteException
    {
        Client c= new Client();
        c.connectRemote();
    }

    private void connectRemote() {
        try
        {
            Registry reg=LocateRegistry.getRegistry("localhost", 4444);
            adder ad=(adder) reg.lookup( "hi serwer");
            System.out.println("Wynik " +ad.add(50,80));
        }
        catch(NotBoundException|RemoteException e)
        {
            System.out.println(e);
        }

    }
}

