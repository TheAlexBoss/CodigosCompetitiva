package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;

public class elCodigoDeLaTIA {

    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<String> set;

        while((Integer.parseInt(br.readLine())) != 0){
            String[] str = br.readLine().split(" ");

            set = new HashSet<>(Arrays.asList(str));

            str = br.readLine().split("0");
            long result = 1;

            for (int i = 0; i < str.length; i++) {
                int n = str[i].length();
                int[] memo = new int[n];

                Arrays.fill(memo, -1);
                result = (result * dp(str[i],memo,0,n,set)) % MOD;

            }

            pw.println(result);

        }
        pw.flush();

    }

    public static int dp(String word, int[] memo, int i, int n, HashSet<String> set){
        if(i> n-1)
            return 1;

        if(memo[i] != -1)
            return memo[i];

        memo[i] = 0;

        if(set.contains(""+ word.charAt(i)))
            memo[i] = (memo[i] + dp(word,memo,i+1,n,set)) % MOD;

        if(i + 1 < n && set.contains(""+ word.charAt(i) + word.charAt(i+1)))
            memo[i] = (memo[i] + dp(word,memo,i+2,n,set)) % MOD;

        if(i + 2 < n && set.contains(""+ word.charAt(i) + word.charAt(i+1) + word.charAt(i+2)))
            memo[i] = (memo[i] + dp(word,memo,i+3,n,set)) % MOD;

        return memo[i];
    }
}
