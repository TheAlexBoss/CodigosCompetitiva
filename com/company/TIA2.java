package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;

public class TIA2 {
    public static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        HashSet<BigInteger> set;

        while((N = Integer.parseInt(br.readLine())) != 0){

            String[] str = br.readLine().split(" ");
            set = new HashSet<>();

            for (int i = 0; i < N; i++) {
                set.add(new BigInteger(str[i]));
            }

            str = br.readLine().split("0");
            int result = 1;

            for (int i = 0; i < str.length; i++) {
                int[][] memo = new int[str[i].length()][str[i].length()];
                for (int j = 0; j < str[i].length(); j++) {
                    Arrays.fill(memo[j], -1);
                }
                result = (result * dp(memo, new BigInteger(str[i]), set, 0, str[i].length() - 1,str[i].length())) % MOD;
            }

            pw.println(result);

        }
        pw.flush();

    }

    public static BigInteger customSubstring(BigInteger integer, int start, int end, int length){
        return integer.mod(BigInteger.TEN.pow(length-start)).divide(BigInteger.TEN.pow(length-end));
    }

    public static int dp(int[][] memo, BigInteger integer, HashSet<BigInteger> set, int start, int  end, int N){
        if(start > end){
            if(set.contains(customSubstring(integer,end,end+1,N)) || set.contains(customSubstring(integer,start,start+1,N)))
                return 1;
            return 0;
        }


        if(start >= memo.length || end < 0)
            return 0;

        if(memo[start][end] != -1)
            return memo[start][end];

        int contains = set.contains(customSubstring(integer,start,end+1,N)) ? 1 : 0;

        if(start == end){
            memo[start][end] = contains;
            return memo[start][end];
        }


        int T1, T2, T3;

        T1 = dp(memo, integer, set, start,end-1,N);
        T2 = dp(memo, integer, set, start+1,end,N);
        T3 = dp(memo, integer, set, start+1,end-1,N);

        memo[start][end] = (T1 + T2 - T3 + contains) % MOD;

        return memo[start][end];
    }
}
