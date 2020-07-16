package codeF291119;

import java.io.*;
import java.util.Scanner;
import java.util.TreeSet;

public class C {

    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), false);
        StringBuilder out;


        int T = scn.nextInt();
        int N;
        for (int i = 0; i < T; i++) {
            N = scn.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            int d = 1,c = 2;
            set.add(0);

            while(c>=d){
                c = N/d;
                set.add(c);
                if (c>=d) set.add(d);
                d++;
            }

            pw.println(set.size());
            for (int in: set){
                pw.print(in + " ");
            }
            pw.println();
        }
        pw.flush();


    }

}
