package com.company;

import java.io.*;
import java.util.Arrays;

public class spojEDIST {
    static final int INF = Integer.parseInt("3F3F3F3F",16);
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String a = br.readLine();
            String b = br.readLine();

            int[][] memo = new int[a.length()][b.length()];

            for (int j = 0; j < a.length(); j++) {
                Arrays.fill(memo[j],-1);
            }

            pw.println(dp(a,b,memo,0,0));

        }

        pw.flush();


    }

    public static int dp(String a, String b, int[][] memo, int i, int j){
        if(i >= a.length() && j >= b.length())
            return 0;

        if(i >= a.length() || j >= b.length())
            return INF;

        if(memo[i][j] != -1)
            return memo[i][j];

        if(a.charAt(i) == b.charAt(j))
            memo[i][j] = dp(a,b,memo,i+1,j+1);
        else
            memo[i][j] = Math.min(dp(a,b,memo,i+1,j+1), Math.min(dp(a,b,memo, i+1,j),dp(a,b,memo,i,j+1))) + 1;

        return memo[i][j];
    }
}
