package com.company;

import java.util.Scanner;

public class Acuarios {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for (int i = 0; i < T; i++) {
            long N = scn.nextInt(), M = scn.nextInt(), D = scn.nextInt();

            long aux = D*((N*N - N)/2);

            System.out.println(N*M - aux);
        }
    }
}