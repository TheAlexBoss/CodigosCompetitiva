package com.company;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class BaseUno {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int N;

        while((N = scn.nextInt()) != 0){
            for (int i = 0; i < N; i++) {
                pw.print(1);
            }
            pw.println();
        }
        pw.flush();
    }
}
