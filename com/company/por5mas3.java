package com.company;

import java.io.*;

public class por5mas3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);

        int N;
        int[] memo = new int[20001];
        memo[1] = 1;
        memo[3] = 1;
        memo[6] = 1;


        while((N = Integer.parseInt(br.readLine()))!= 0){

            dp(memo,N);

            if(memo[N]>0)
                pw.println("SI");
            else
                pw.println("NO");
        }

        pw.flush();
    }


    public static int dp(int[] memo, int N){
        if(N<=0)
            return -1;

        if(memo[N] != 0)
            return memo[N];

        if(N%3 == 0)
            memo[N] = numOr(dp(memo,N/3), dp(memo,N-5));
        else
            memo[N] = dp(memo,N-5);

        return memo[N];
    }

    public static int numOr(int a, int b){
        int prod = a * b;

        if(prod == 0)
            return 0;

        if(prod<0)
            return 1;

        return a > 0 ? 1:-1;
    }
}
