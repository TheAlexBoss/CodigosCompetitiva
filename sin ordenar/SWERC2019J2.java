package com.company;

import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.Scanner;

public class SWERC2019J2 {
    static int MOD = 1000000007;
    static BigInteger[] factorial = new BigInteger[2000001];

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        factorial[0] = BigInteger.ONE;
        factorial[1] = BigInteger.ONE;

        for (int i = 2; i < 2000001; i++) {
            factorial[i] = factorial[i-1].multiply(new BigInteger(String.valueOf(i)));
        }


        System.out.println(factorial[2000000]);
        System.out.println(catalan(1000000));

        int T = scn.nextInt();
        long result = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int ans = -1, elem, elemPrev, group;
        for (int i = 0; i < T; i++) {
            int read = scn.nextInt();

            if(read < ans){
                group = 1;
                elemPrev = -1;
                while(!stack.isEmpty() && stack.peek() != read){
                    elem = stack.pop();
                    if(elem == elemPrev){
                        group++;
                    }
                    elemPrev = elem;
                }

                result = (result * catalan(group))%MOD;
            }

            stack.push(read);
            ans = read;
        }

        group = 1;
        elemPrev = -1;
        while(!stack.isEmpty()){
            elem = stack.pop();
            if(elem == elemPrev){
                group++;
            }else{
                group = 1;
            }
            elemPrev = elem;
        }

        result = (result * catalan(group))%MOD;

        System.out.println(result);
    }


    public static long catalan(int n){
        BigInteger cuenta = factorial[2*n].divide(factorial[n+1]).divide(factorial[n]);
        return cuenta.mod(new BigInteger(String.valueOf(MOD))).longValue();
    }
}
