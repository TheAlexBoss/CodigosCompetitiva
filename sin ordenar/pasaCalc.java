package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class pasaCalc {

    static final int INF = Integer.parseInt("3F3F3F3F", 16);
    static final int[][] posibles = {{0, 0, 0, 0}, {2, 3, 4, 7}, {1, 3, 5, 8}, {1, 2, 6, 9}, {1, 5, 6, 7}, {2, 4, 6, 8}, {3, 4, 5, 9}, {1, 4, 8, 9}, {2, 5, 7, 9}, {3, 6, 7, 8}};

    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] memo = new int[32][10];

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            if(dpOptimizado(memo,Integer.parseInt(str[0]),Integer.parseInt(str[1])) == 1)
                pw.println("GANA");
            else
                pw.println("PIERDE");
        }
        pw.flush();

    }

    public static int dpOptimizado(int[][] memo, int suma, int lastIntroduced) {
        if (suma >= 31)
            return 1;

        if (memo[suma][lastIntroduced] != 0)
            return memo[suma][lastIntroduced];

        int dp1 = dpOptimizado(memo, suma + posibles[lastIntroduced][0], posibles[lastIntroduced][0]);
        int dp2 = dpOptimizado(memo, suma + posibles[lastIntroduced][1], posibles[lastIntroduced][1]);
        int dp3 = dpOptimizado(memo, suma + posibles[lastIntroduced][2], posibles[lastIntroduced][2]);
        int dp4 = dpOptimizado(memo, suma + posibles[lastIntroduced][3], posibles[lastIntroduced][3]);

        int sum = dp1+dp2+dp3+dp4;

        if(sum < 4)
            memo[suma][lastIntroduced] = 1;
        else
            memo[suma][lastIntroduced] = -1;

        return memo[suma][lastIntroduced];

    }
}
