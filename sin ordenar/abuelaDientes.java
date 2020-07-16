package com.company;

import java.io.*;

public class abuelaDientes {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        String[] u,d;

        for (int i = 0; i < T; i++) {
            u = br.readLine().split(" ");
            d = br.readLine().split(" ");
            boolean sigue = true;
            int ans = (Integer.parseInt(u[0]) + Integer.parseInt(d[0]));
            if(u.length == d.length){
                for (int j = 1; j < u.length && sigue; j++) {
                    sigue = (Integer.parseInt(u[j]) + Integer.parseInt(d[j])) == ans;
                }

                if(sigue)
                    pw.println("SI");
                else
                    pw.println("NO");
            }else{
                pw.println("NO");
            }
        }
        pw.flush();
    }
}
