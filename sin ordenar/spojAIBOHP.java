package com.company;

import java.io.*;
import java.util.Arrays;

public class spojAIBOHP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), false);
        
        
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int[][] memo = new int[str.length()][str.length()];

            for (int j = 0; j < str.length(); j++) {
                Arrays.fill(memo[j], -1);
            }

            pw.println(dp(str,memo, 0,str.length()-1));
        }
        
        pw.flush();
    }



    public static int dp(String word, int[][] memo, int i, int j){
        if(i >= j)
            return 0;

        if(memo[i][j] != -1)
            return memo[i][j];

        if(word.charAt(i) == word.charAt(j))
            memo[i][j] =  dp(word,memo,i+1,j-1);
        else{
            int T1 = dp(word, memo, i+1, j);
            int T2 = dp(word, memo, i, j-1);

            memo[i][j] = 1 + Math.min(T1, T2);
        }
        return memo[i][j];
    }
}
