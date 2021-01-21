package com.company;

import java.util.concurrent.locks.ReentrantLock;

class Klasa implements  Runnable{
    public void run() {
        for(int i=0;i<100;i++)
            Klasa2.counter++;
    }
}

class Klasa2{
    public static int counter = 0;
}

class KlasaVolatile{
 private int x=1;
 private volatile  boolean i=false;
 public void setX(int x){
     this.x=x;
     i=true;
 }
 public int getX(int x){
     if(i==true)
         return x;
     return 0;
 }
}


public class Main {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new Klasa());
        Thread thread2 = new Thread(new Klasa());
        KlasaVolatile klasa = new KlasaVolatile();


        System.out.println(klasa.getX(2));   //i == false
        klasa.setX(0);                          //i zmienia się z false na true
        System.out.println(klasa.getX(2));

        ReentrantLock L = new ReentrantLock();
        L.lock();
        try {
        }
        finally{
            L.unlock();
        }
    }
}
