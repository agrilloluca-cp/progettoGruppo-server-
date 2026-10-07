package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");

        ServerSocket ss = new ServerSocket(3001);   
        Socket s = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        System.out.println("qualcuno si è collegato");
        out.println("welcome");

        String operazione = in.readLine(); // "s1,2,5"

        String[] elementi = operazione.split(",");


        double risultato = calcola(elementi[0],elementi[1], elementi[2]);

        out.println(risultato);

        in.close();
        out.close();
        s.close();
        ss.close();
    }

    private static double calcola(String op, String num1, String num2){

        double risultato = 0;
        double var1 = Double.parseDouble(num1);
        double var2 = Double.parseDouble(num2);

          if(op.equals("s1")){
            risultato = var1 + var2;
        }else if (op.equals("s2")){
            risultato = var1 - var2;
        }else if (op.equals("m")){
            risultato = var1 * var2;
        }else if(op.equals("d")){
            risultato = var1 / var2;
        }
        return risultato;
    }
}