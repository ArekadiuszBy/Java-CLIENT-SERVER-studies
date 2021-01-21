package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        //Zad1

        new MyThread().start();
        new MyThread().start();

        //Zad2

        new MyClass("aaaaa").run();
        new MyClass("aaa");

        //Zad3

        Thread tr1 = new Thread(new MyClass("aaa"), "Pierwszy");
        Thread tr2 = new Thread(new MyClass("bbb"), "Drugi");

        tr1.start();
        tr2.start();

        //Zad BONUSOWE
        List<String> extractedUrls = MyClass.extractUrls("Welcome to https://stackoverflow.com/ and here is another link http://www.google.com/ \n which is a great search engine");

        for (String url : extractedUrls)
        {
            System.out.println(url);
        }

    }

    //Zad1
    public static class MyThread extends Thread{
        public void run(){
            System.out.println(this.getName());
        }
    }

    //Zad 2
    static class MyClass implements Runnable{
        private Random rnd;
        private String str;

        String watek = Thread.currentThread().getName();

        public MyClass(String str){
            this.str = str;
            rnd = new Random();
        }
        public void run()
        {
            for (int i=0;i<5;i++){
                try{
                    Thread.sleep(rnd.nextInt(2500)+500);
                    System.out.println(watek);
                }
                catch(InterruptedException e){
                    System.out.println(str + " " + i);

                }
            }
        }

        // ZADANIE BONUSOWE
        public static List<String> extractUrls(String text)
        {
            List<String> containedUrls = new ArrayList<String>();
            String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
            Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
            Matcher urlMatcher = pattern.matcher(text);

            while (urlMatcher.find())
            {
                containedUrls.add(text.substring(urlMatcher.start(0),
                        urlMatcher.end(0)));
            }

            return containedUrls;
        }



    }
}
