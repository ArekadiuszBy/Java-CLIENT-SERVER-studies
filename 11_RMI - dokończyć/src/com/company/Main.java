package com.company;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface adder extends Remote
{
    public int add(int n1, int n2)  throws RemoteException;
}


public class Main {

    public static void main(String[] args) {
	// write your code here
    }
}
