package com.company;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Scanner;

public class SWERC2019J {
    static int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        long result = 1;

        int ans = -1, prev = Integer.parseInt("3F3F3F3F", 16), ga = 1, gp = 1;
        for (int i = 0; i < T; i++) {
            int read = scn.nextInt();
            if(read == prev){
                gp++;
            }else if(read == ans){
                ga++;
            }else if(read < ans){
                prev = read;
                result = (result*catalan(ga)) % MOD;
                result = (result*catalan(gp)) % MOD;
                ga = 1;
                gp = 1;
            }
            ans = read;
        }

        result = (result*catalan(ga)) % MOD;
        result = (result*catalan(gp)) % MOD;

        System.out.println(result);
    }

    public static BigInteger binomialCoeff(int n, int k) {
        BigInteger res = BigInteger.ONE;
        // Since C(n, k) = C(n, n-k)
        if (k > n - k) {
            k = n - k;
        }

        // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
        for (int i = 0; i < k; ++i) {
            res = res.multiply(new BigInteger(String.valueOf(n - i)));
            res = res.divide(new BigInteger(String.valueOf(i+1)));
        }

        return res;
    }
    public static long catalan(int n) {
        // Calculate value of 2nCn
        BigInteger c = binomialCoeff(2 * n, n);

        // return 2nCn/(n+1)
        return c.divide(new BigInteger(String.valueOf(n+1))).mod(new BigInteger(String.valueOf(MOD))).longValue();
    }
}
