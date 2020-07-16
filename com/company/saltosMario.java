package com.company;

import java.util.Scanner;

public class saltosMario {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scn.nextInt(), arriba = 0, abajo = 0, actual, anterior = scn.nextInt();
            for (int j = 1; j < N; j++) {
                actual = scn.nextInt();
                if(actual < anterior){
                    abajo++;
                }else if(actual > anterior){
                    arriba++;
                }
                anterior = actual;
            }
            System.out.println(arriba + " " + abajo);
        }
    }
}
