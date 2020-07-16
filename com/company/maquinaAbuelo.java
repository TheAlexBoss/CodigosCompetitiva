package com.company;

import java.io.*;

public class maquinaAbuelo {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int N;

        String str = br.readLine();
        String[] interval;
        while((N = Integer.parseInt(br.readLine())) != 0){

            int[] memo = new int[str.length()];
            int c = str.charAt(0);
            int n = 0;

            for (int i = 1; i < str.length(); i++) {
                if(c == str.charAt(i))
                    memo[i] = n;
                else{
                    memo[i] = ++n;
                    c = str.charAt(i);
                }
            }


            for (int i = 0; i < N; i++) {
                interval = br.readLine().split(" ");
                int a = Integer.parseInt(interval[0]);
                int b = Integer.parseInt(interval[1]);

                if(memo[a] ==  memo[b])
                    pw.println("SI");
                else
                    pw.println("NO");
            }
            pw.println();
            str = br.readLine();

        }
        pw.flush();
    }
}
