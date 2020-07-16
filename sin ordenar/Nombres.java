package com.company;

import java.io.*;

public class Nombres {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] str;

        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            str[1] += ".";
            pw.println("Hola, " + str[1]);
        }


        pw.flush();
    }
}
