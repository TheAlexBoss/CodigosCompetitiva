package com.company;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class spojCDC12_D {

    static final int INF = Integer.parseInt("3F3F3F3F",16);
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int fastest = scn.nextInt(), m = scn.nextInt(), v = scn.nextInt(), boost = scn.nextInt();
            int timeBoost = scn.nextInt(), timeRecoverBoost = scn.nextInt();

            int[][] memo = new int[m+1][timeBoost + 1];
            for (int j = 0; j < m+1; j++) {
                Arrays.fill(memo[j], -1);
            }

            int result = dp(memo, 0,0,m, fastest,v,boost,timeBoost,timeBoost,timeRecoverBoost);

            if(result == INF)
                pw.println("Scenario #" + (i+1) + ": Ronny will be annihilated");
            else
                pw.println("Scenario #" + (i+1) + ": Ronny wins in time " + result);

        }
        pw.flush();

    }


    public static int dp(int[][] memo, int t, int m, int M, int F, int V, int B, int timeB, int TimeB, int TimeRB){

        if(t >= F)
            return INF;

        if(m >= M)
            return t;

        if(timeB > TimeB)
            return INF;

        if(memo[m][timeB] != -1){
            return memo[m][timeB];
        }

        int T1 = INF, T2 = INF, T3;
        if(timeB > 0)
            T1 = dp(memo, t+1, m+V+B, M, F, V, B, timeB - 1, TimeB, TimeRB);
        else
            T2 = dp(memo, t+1, m,M,F,V,B,timeB+TimeRB, TimeB, TimeRB);

        T3 = dp(memo, t+1, m+V,M,F,V,B, timeB , TimeB, TimeRB);

        memo[m][timeB] = Math.min(Math.min(T1,T2),T3);
        return  memo[m][timeB];

    }
}
