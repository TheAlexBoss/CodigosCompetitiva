package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class spojSCUBADIV {

    static class Tank{
        int O, N, P;

        public Tank(int o, int n, int p) {
            O = o;
            N = n;
            P = p;
        }
    }

    static int INF = Integer.parseInt("3F3F3F3F",16);
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        Scanner scn = new Scanner(System.in);

        int C = scn.nextInt();
        for (int i = 0; i < C; i++) {

            int objO = scn.nextInt(), objN = scn.nextInt(), N = scn.nextInt();
            Tank[] tanks = new Tank[N];
            int[][][] memo = new int[N][objO+1][objN+1];

            for (int j = 0; j < N; j++) {
                tanks[j] = new Tank(scn.nextInt(), scn.nextInt(), scn.nextInt());
                for (int k = 0; k < objO+1; k++) {
                    Arrays.fill(memo[j][k], -1);
                }
            }

            pw.println(dp(objO, objN,0,0,0, memo,tanks));
        }
        pw.flush();
    }

    public static int dp(int objO, int objN, int i, int carriedO, int carriedN, int[][][] memo, Tank[] list){
        if((objO <= carriedO && objN <= carriedN))
            return 0;

        if(i >= memo.length)
            return INF;

        carriedO = Math.min(carriedO, objO);
        carriedN = Math.min(carriedN, objN);

        if(memo[i][carriedO][carriedN] != -1){
            return memo[i][carriedO][carriedN];
        }


        int T1 = list[i].P + dp(objO, objN, i+1,carriedO + list[i].O,carriedN + list[i].N, memo, list);
        int T2 = dp(objO, objN, i+1, carriedO, carriedN, memo, list);

        memo[i][carriedO][carriedN] = Math.min(T1,T2);
        return memo[i][carriedO][carriedN];
    }
}
