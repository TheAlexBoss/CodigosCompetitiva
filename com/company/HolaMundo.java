package com.company;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class HolaMundo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int a = scn.nextInt();
        for (int i = 0; i < a; i++) {
            pw.println("Hola mundo.");
        }
        pw.flush();
    }
}
