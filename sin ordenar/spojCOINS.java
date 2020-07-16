package com.company;

import java.io.*;

public class spojCOINS {
    static final int size = 100000000;
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String read;
        long[] memo = new long[size];
        for (int n = 1; n < size; n++)
            memo[n] = Math.max(n, memo[n/2] + memo[n/3] + memo[n/4]);

        while((read = br.readLine()) != null && !read.equals(""))
            pw.println(recursive(memo, Integer.parseInt(read)));

        pw.flush();
    }


    static long recursive(long[] memo, int n){
        if(n < size)
            return memo[n];

        long T2 = recursive(memo, n/2);
        long T3 = recursive(memo, n/3);
        long T4 = recursive(memo, n/4);
        return Math.max(n, T2 + T3 + T4);
    }
}
