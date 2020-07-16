package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class codigoTIA {

    static final int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out), false);


        HashSet<String> set;
        int N;


        while ((N = Integer.parseInt(reader.readLine())) != 0) {

            String[] str = reader.readLine().split(" ");

            set = new HashSet<>(Arrays.asList(str).subList(0, N));

            str = reader.readLine().split("0");

            int result = 1;

            for (int i = 0; i < str.length; i++) {

                int n = str[i].length();
                int[] memo = new int[n + 1];
                String t1,t2,t3;

                memo[0] = 1;
                for (int j = 0; j < n; j++) {
                    if (j == 0){
                        t1 = "" + str[i].charAt(j);
                        memo[j+1] = set.contains(t1) ? memo[j]: 0;
                    }else if(j == 1){
                        t1 = "" + str[i].charAt(j);
                        t2 = str[i].charAt(j-1) + t1;
                        memo[j+1] = set.contains(t1) ? memo[j]: 0;
                        memo[j+1] = set.contains(t2) ? (memo[j+1] + memo[j-1]) % MOD: memo[j+1];
                    }else{
                        t1 = "" + str[i].charAt(j);
                        t2 = str[i].charAt(j-1) + t1;
                        t3 = str[i].charAt(j-2) + t2;
                        memo[j+1] = set.contains(t1) ? memo[j]: 0;
                        memo[j+1] = set.contains(t2) ? (memo[j+1] + memo[j-1]) % MOD: memo[j+1];
                        memo[j+1] = set.contains(t3) ? ((memo[j+1]) % MOD + memo[j-2]) % MOD: memo[j+1];
                    }
                }

                result = (result * memo[n]) % MOD;
            }

            writer.println(result);
        }
        writer.flush();
    }

}
